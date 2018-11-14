package com.devandroid.androidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private TextView mTvJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        mTvJoke = findViewById(R.id.tvJoke);

        Intent intent = getIntent();
        String joke = intent.getStringExtra("ExtraKey");
        if (joke != null && joke.length() != 0) {
            mTvJoke.setText(joke);
        }

    }
}
