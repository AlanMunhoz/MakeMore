package com.udacity.gradle.buiditbigger.free;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.devandroid.androidlib.JokeActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;


public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.CallbackAsyncTask {

    private Button btnTellJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTellJoke = findViewById(R.id.tellJoke);

        AdView mAdView = findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

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
        intent.putExtra(getString(R.string.extra_key), strJoke);

        /**
         * Calling Android Library
         */
        startActivity(intent);
    }
}
