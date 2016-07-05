package com.example.gradle.imagelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageActivity extends AppCompatActivity {

    ImageView imageView;
    TextView joke;

    public static final String JOKE_EXTRA_INTENT_KEY = "joke";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_activity_layout);

        joke = (TextView) findViewById(R.id.joke);

        joke.setText(getIntent().getStringExtra(JOKE_EXTRA_INTENT_KEY));


//        imageView = (ImageView) findViewById(R.id.imageView);
//        imageView.setImageResource(R.drawable.gradlelogo);

    }
}
