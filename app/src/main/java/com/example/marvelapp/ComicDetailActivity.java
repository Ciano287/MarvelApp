package com.example.marvelapp;

import android.app.Notification;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ComicDetailActivity extends AppCompatActivity {
    public final static String EXTRA_NAME = "com.example.marvelapp.EXTRA_NAME";
    public final static String EXTRA_DESCRIPTION = "com.example.marvelapp.EXTRA_DESCRIPTION";
    public final static String EXTRA_IMAGE_PATH = "com.example.marvelapp.EXTRA_IMAGE_PATH";
    public final static String EXTRA_BUY_LINK = "com.example.marvelapp.EXTRA_BUY_LINK";
    public final static String EXTRA_ID = "com.example.marvelapp.EXTRA_ID";
    Button buyButton;
    TextView comicDescription;
    ImageView comicImageView;
    Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_detail);

        buyButton = findViewById(R.id.comic_buy_button);
        comicDescription = findViewById(R.id.comic_detail_description);
        comicDescription.setMovementMethod(new ScrollingMovementMethod());
        comicImageView = findViewById(R.id.comic_detail_imageview);
        addButton = findViewById(R.id.comic_button_detail_favorite);
        Intent intent = getIntent();
        final String name = intent.getStringExtra(EXTRA_NAME);
        final String description = intent.getStringExtra(EXTRA_DESCRIPTION);
        final String imagePath = intent.getStringExtra(EXTRA_IMAGE_PATH);
        final String buyLink = intent.getStringExtra(EXTRA_BUY_LINK);
        final int id = intent.getIntExtra(EXTRA_ID, 0);
        setTitle(name);

        comicDescription.setText(description);
        Glide.with(this).load(imagePath).into(comicImageView);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buyLink == null){
                    Toast.makeText(getApplicationContext(), R.string.buying_not_available, Toast.LENGTH_SHORT).show();
                } else {
                    Intent data = new Intent(ComicDetailActivity.this, ComicWebViewActivity.class);
                    data.putExtra(ComicWebViewActivity.EXTRA_BUY_LINK, buyLink);
                    startActivity(data);
                }
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra(EXTRA_ID, id);
                data.putExtra(EXTRA_NAME, name);
                data.putExtra(EXTRA_IMAGE_PATH, imagePath);
                data.putExtra(EXTRA_BUY_LINK, buyLink);
                data.putExtra(EXTRA_DESCRIPTION, description);

                setResult(RESULT_OK, data);
                finish();
            }
        });


    }

}
