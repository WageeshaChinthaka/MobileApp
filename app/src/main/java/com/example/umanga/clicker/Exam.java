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

public class Exam extends Activity {
    Button buttonLevel1;
    Button buttonLevel2;
    Button back2;
    int i=0;
    TextToSpeech t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        t3=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t3.setLanguage(Locale.UK);
                }
            }
        });
        final Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        buttonLevel1=(Button)findViewById(R.id.activity_exam_button_level1);
        buttonLevel2=(Button)findViewById(R.id.activity_exam_button_level2);
        back2=(Button)findViewById(R.id.button_bavk2);
       // final MediaPlayer mp=MediaPlayer.create(this,R.raw.level_1);
        final MediaPlayer mp=MediaPlayer.create(this,R.raw.double_click);

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                final View  l3mPager = v;
                Handler handler= new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){
                            //;
                            vibrator.vibrate(1000);
                            Toast.makeText(Exam.this,"Single Click",Toast.LENGTH_SHORT).show();
                            Button b = (Button)l3mPager;
                            String toSpeak = b.getText().toString();

                            //   Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            t3.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                        }
                        else if (i==2){
                            mp.start();
                            Toast.makeText(Exam.this,"Double Click",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                            startActivity(intent);

                        }
                        i=0;

                    }
                },1000);

            }
        });

        buttonLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                final View  lmPager = v;
                Handler handler= new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){
                            vibrator.vibrate(1000);
                          //  mp.start();;
                            Toast.makeText(Exam.this,"Single Click",Toast.LENGTH_SHORT).show();
                            Button b = (Button)lmPager;
                            String toSpeak = b.getText().toString();

                         //   Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            t3.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                        }
                        else if (i==2){
                            mp.start();
                            Toast.makeText(Exam.this,"Double Click",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Level_1.class);
                            startActivity(intent);

                        }
                        i=0;

                    }
                },1000);

            }
        });

        buttonLevel2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                i++;
                final View  l2mPager = v;
                Handler handler= new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){
                            vibrator.vibrate(1000);
                           // mp.start();;
                            Toast.makeText(Exam.this,"Single Click",Toast.LENGTH_SHORT).show();
                            Button b = (Button)l2mPager;
                            String toSpeak = b.getText().toString();

                            //   Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            t3.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                        }
                        else if (i==2){
                            mp.start();
                            Toast.makeText(Exam.this,"Double Click",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Level_2.class);
                            startActivity(intent);

                        }
                        i=0;

                    }
                },1000);

            }
        });


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if(preferences.getString("isLevel5Answered", null) != null){
            buttonLevel2.setClickable(true);
            buttonLevel2.setEnabled(true);
        }

    }
}
