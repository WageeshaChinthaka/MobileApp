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

public class Level_1 extends Activity{
 Button q1;
    Button buttonQuestion1;
    Button buttonQuestion2;
    Button buttonQuestion3;
    Button buttonQuestion4;
    Button buttonQuestion5;
    Button back_exam;
    int i=0;
    TextToSpeech t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1);
        t4=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t4.setLanguage(Locale.UK);
                }
            }
        });

        buttonQuestion1 = (Button)findViewById(R.id.activity_level_1_button_question1);
        buttonQuestion2 = (Button)findViewById(R.id.activity_level_1_button_question2);
        buttonQuestion3 = (Button)findViewById(R.id.activity_level_1_button_question3);
        buttonQuestion4 = (Button)findViewById(R.id.activity_level_1_button_question4);
        buttonQuestion5 = (Button)findViewById(R.id.activity_level_1_button_question5);
        back_exam=(Button)findViewById(R.id.button_back_to_exam);
    //    final MediaPlayer mp=MediaPlayer.create(this,R.raw.q_1);
        final MediaPlayer mp=MediaPlayer.create(this,R.raw.double_click);
        final Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if(preferences.getString("isLevel1Answered", null) != null){
            buttonQuestion2.setClickable(true);
            buttonQuestion2.setEnabled(true);
        }
        if(preferences.getString("isLevel2Answered", null) != null){
            buttonQuestion3.setClickable(true);
            buttonQuestion3.setEnabled(true);
        }
        if(preferences.getString("isLevel3Answered", null) != null){
            buttonQuestion4.setClickable(true);
            buttonQuestion4.setEnabled(true);
        }
        if(preferences.getString("isLevel4Answered", null) != null){
            buttonQuestion5.setClickable(true);
            buttonQuestion5.setEnabled(true);
        }

        back_exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                final View  lebmPager = v;
                Handler handler= new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){
                            vibrator.vibrate(1000);
                            Toast.makeText(Level_1.this,"Single Click",Toast.LENGTH_SHORT).show();
                            // mp.start();
                            Button b = (Button)lebmPager;
                            String toSpeak = b.getText().toString();

                           // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            t4.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                        }
                        else if (i==2){
                            mp.start();
                            Toast.makeText(Level_1.this,"Double Click",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Exam .class);
                            intent.putExtra("level", "2");
                            startActivity(intent);

                        }
                        i=0;

                    }
                },1000);

            }
        });

        buttonQuestion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                final View  lemPager = v;
                Handler handler= new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){
                            vibrator.vibrate(1000);
                            Toast.makeText(Level_1.this,"Single Click",Toast.LENGTH_SHORT).show();
                          //  mp.start();
                            Button b = (Button)lemPager;
                            String toSpeak = b.getText().toString();

                            //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            t4.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                        }
                        else if (i==2){
                            mp.start();
                            Toast.makeText(Level_1.this,"Double Click",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Level1QuestionsActivity .class);
                            intent.putExtra("level", "1");
                            startActivity(intent);

                        }
                        i=0;

                    }
                },1000);

            }
        });

        buttonQuestion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                final View  le2mPager = v;
                Handler handler= new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){
                            vibrator.vibrate(1000);
                            Toast.makeText(Level_1.this,"Single Click",Toast.LENGTH_SHORT).show();
                            //  mp.start();
                            Button b = (Button)le2mPager;
                            String toSpeak = b.getText().toString();

                           // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            t4.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                        }
                        else if (i==2){
                            mp.start();
                            Toast.makeText(Level_1.this,"Double Click",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Level1QuestionsActivity .class);
                            intent.putExtra("level", "2");
                            startActivity(intent);

                        }
                        i=0;

                    }
                },1000);

            }
        });

        buttonQuestion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                final View  le3mPager = v;
                Handler handler= new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){
                            vibrator.vibrate(1000);
                            Toast.makeText(Level_1.this,"Single Click",Toast.LENGTH_SHORT).show();
                             //mp.start();
                            Button b = (Button)le3mPager;
                            String toSpeak = b.getText().toString();

                           // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            t4.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                        }
                        else if (i==2){
                            mp.start();
                            Toast.makeText(Level_1.this,"Double Click",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Level1QuestionsActivity .class);
                            intent.putExtra("level", "3");
                            startActivity(intent);

                        }
                        i=0;

                    }
                },1000);

            }
        });

        buttonQuestion4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                final View  le4mPager = v;
                Handler handler= new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){
                            vibrator.vibrate(1000);
                            Toast.makeText(Level_1.this,"Single Click",Toast.LENGTH_SHORT).show();
                            //  mp.start();
                            Button b = (Button)le4mPager;
                            String toSpeak = b.getText().toString();

                            //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            t4.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                        }
                        else if (i==2){
                            mp.start();
                            Toast.makeText(Level_1.this,"Double Click",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Level1QuestionsActivity .class);
                            intent.putExtra("level", "4");
                            startActivity(intent);

                        }
                        i=0;

                    }
                },1000);

            }
        });

        buttonQuestion5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                final View  le5mPager = v;
                Handler handler= new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){
                            vibrator.vibrate(1000);
                            Toast.makeText(Level_1.this,"Single Click",Toast.LENGTH_SHORT).show();
                            //  mp.start();
                            Button b = (Button)le5mPager;
                            String toSpeak = b.getText().toString();

                           // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            t4.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                        }
                        else if (i==2){
                            mp.start();
                            Toast.makeText(Level_1.this,"Double Click",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Level1QuestionsActivity .class);
                            intent.putExtra("level", "5");
                            startActivity(intent);

                        }
                        i=0;

                    }
                },1000);

            }
        });


    }
}
