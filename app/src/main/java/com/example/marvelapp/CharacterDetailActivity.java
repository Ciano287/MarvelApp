package com.example.marvelapp;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.marvelapp.database.CharacterObject;
import com.example.marvelapp.database.ComicObject;

import java.util.ArrayList;
import java.util.List;

public class CharacterDetailActivity extends AppCompatActivity {
    public final static String EXTRA_NAME = "com.example.marvelapp.EXTRA_NAME";
    public final static String EXTRA_IMAGE_PATH = "com.example.marvelapp.EXTRA_IMAGE_PATH";
    public final static String EXTRA_DESCRIPTION = "com.example.marvelapp.EXTRA_DESCRIPTION";
    public final static String EXTRA_ID = "com.example.marvelapp.EXTRA_ID";
    public final static String EXTRA_ISCHECKED = "com.example.marvelapp.EXTRA_ISCHECKED";

    ImageView characterDetailImage;
    TextView characterDetailDescription;
    Button addButton;

    boolean checked;

    private static String name;
    private static String description;
    private static String imagePath;

    private static int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        characterDetailImage = findViewById(R.id.character_detail_imageview);
        characterDetailDescription = findViewById(R.id.character_detail_description_textview);
        characterDetailDescription.setMovementMethod(new ScrollingMovementMethod());
        addButton = findViewById(R.id.character_detail_button_favorite);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        description = intent.getStringExtra(EXTRA_DESCRIPTION);
        name = intent.getStringExtra(EXTRA_NAME);
        imagePath = intent.getStringExtra(EXTRA_IMAGE_PATH);
        setTitle(name);

        final int randomId = (int) (Math.random() * 3);
        id = intent.getIntExtra(EXTRA_ID, randomId);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra(EXTRA_NAME, name);
                data.putExtra(EXTRA_ID, id);
                data.putExtra(EXTRA_DESCRIPTION, description);
                data.putExtra(EXTRA_IMAGE_PATH, imagePath);
                data.putExtra(EXTRA_ISCHECKED, checked);

                setResult(RESULT_OK, data);
                finish();
            }
        });

        Glide.with(this).load(imagePath).into(characterDetailImage);
        characterDetailDescription.setText(description);


    }

    @Override
    protected void onPause() {
        super.onPause();


    }

    @Override
    protected void onStop() {
        super.onStop();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
