package com.example.umanga.clicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class Ratings extends Activity {
    TextToSpeech t1;
    Button rate;
    Button back_rate;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });


        final Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        final MediaPlayer mp=MediaPlayer.create(this,R.raw.double_click);

        back_rate=(Button)findViewById(R.id.back_rate);
        rate=(Button)findViewById(R.id.button_rate);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if(preferences.getString("isLevel1Answered", null) != null){

            String toSpeak = "You are now in level 1 question 2";
            // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

        }
        else {
            String toSpeak = "You are now in level 1 question 1";
            // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

        }



        back_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;

                final View  m6Pager = v;
                Handler handler= new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){


                            vibrator.vibrate(1000);
                            Toast.makeText(Ratings.this,"Single Click",Toast.LENGTH_SHORT).show();
                            Button b = (Button)m6Pager;
                            String toSpeak = b.getText().toString();

                            //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);


                        }
                        else if (i==2){
                            mp.start();
                            Toast.makeText(Ratings.this,"Double Click",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                            startActivity(intent);

                        }
                        i=0;

                    }
                },1000);
                ///

            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;

                final View  m6Pager = v;
                Handler handler= new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){
                            Button b = (Button)m6Pager;
                            String toSpeak = b.getText().toString();


                            //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);



                            //vibrator.vibrate(1000);


                            //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                         //   t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);


                        }
                        else if (i==2){
                            Button b = (Button)m6Pager;
                            //String toSpeak = b.getText().toString();
                            String toSpeak = "now you are in level 1 question 2";

                            //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                        }
                        i=0;

                    }
                },1000);
                ///

            }
        });


    }
}
