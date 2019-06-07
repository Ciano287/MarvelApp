package com.example.marvelapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ComicWebViewActivity extends AppCompatActivity {
    public final static String EXTRA_BUY_LINK = "com.example.marvelapp.EXTRA_BUY_LINK";
    WebView comicWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_web_view);
        Intent intent = getIntent();

        comicWebView = findViewById(R.id.web_view_comic);
        comicWebView.setWebViewClient(new WebViewClient());
        comicWebView.loadUrl(intent.getStringExtra(EXTRA_BUY_LINK) );
    }
    @Override
    public void onBackPressed() {

        if(comicWebView.canGoBack()){
            comicWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
