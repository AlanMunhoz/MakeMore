package com.udacity.gradle.buiditbigger.paid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.devandroid.androidlib.JokeActivity;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;


public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.CallbackAsyncTask {

    private Button btnTellJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTellJoke = findViewById(R.id.tellJoke);

        btnTellJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EndpointsAsyncTask().execute(MainActivity.this);
            }
        });
    }

    @Override
    public void resultOnPostExecute(String strJoke) {

        /**
         * Configuring intent to Android Library
         */
        final Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra("ExtraKey", strJoke);

        /**
         * Calling Android Library
         */
        startActivity(intent);
    }
}
