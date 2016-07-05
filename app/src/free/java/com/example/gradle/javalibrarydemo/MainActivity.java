package com.example.gradle.javalibrarydemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.WizardJoker;
import com.example.gradle.imagelibrary.ImageActivity;
import com.example.jokes.Joker;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView label;

    Button showImage;
    Button connectBackend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        showImage = (Button) findViewById(R.id.showImageButton);
        connectBackend = (Button) findViewById(R.id.connectBackendButton);

        label = (TextView) findViewById(R.id.label);
        //label.setText("Hello from java Jokes !!");

        Joker joker = new Joker();

        //label.setText(joker.getJoke());


        EndpointsAsyncTask task = new EndpointsAsyncTask();

        task.execute(new Pair<Context, String>(this, "Sumeet"));



        showImage.setOnClickListener(this);
        connectBackend.setOnClickListener(this);


        // display an add
        AdView mAdView = (AdView)findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        //

        mAdView.loadAd(adRequest);
    }


    @Override
    public void onClick(View v) {


        switch(v.getId())
        {

            case R.id.showImageButton:

                WizardJoker wizardJoker = new WizardJoker();

                Intent intent = new Intent(this, ImageActivity.class);
                intent.putExtra(ImageActivity.JOKE_EXTRA_INTENT_KEY,wizardJoker.getJokes());

                startActivity(intent);

                break;


            case R.id.connectBackendButton:


                    connectBackend();



                break;

            default:

            break;

        }

    }


    public void connectBackend()
    {
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));



    }


}
