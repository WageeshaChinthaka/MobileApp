package com.example.umanga.clicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class Main2Activity extends Activity {
    Button plus;
    Button exam;
    Button rating;
    Button identify;
    Button back;
    int i=0;
    TextToSpeech t2;



   // MediaPlayer mp1;
   // MediaPlayer mp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t2=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t2.setLanguage(Locale.UK);
                }
            }
        });

        final Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        final MediaPlayer mp=MediaPlayer.create(this,R.raw.double_click);
       // mp1=MediaPlayer.create(this,R.raw.emamine_skils);
       // mp2=MediaPlayer.create(this,R.raw.ask_question);

        plus=(Button)findViewById(R.id.button_plus);
        exam=(Button)findViewById(R.id.button_exam);
        rating=(Button)findViewById(R.id.button_rating);
        identify=(Button)findViewById(R.id.button_identify);
        back=(Button)findViewById(R.id.button_back1);


        //vibrate pateerns





        back.setOnClickListener(new View.OnClickListener() {
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
                            Toast.makeText(Main2Activity.this,"Single Click",Toast.LENGTH_SHORT).show();
                            Button b = (Button)m6Pager;
                            String toSpeak = b.getText().toString();

                            //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            t2.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);


                        }
                        else if (i==2){
                            mp.start();
                            Toast.makeText(Main2Activity.this,"Double Click",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);

                        }
                        i=0;

                    }
                },1000);
                ///

            }
        });

        identify.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                i++;

                final View  m2Pager = v;
                Handler handler= new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){
                            vibrator.vibrate(1000);
                            Toast.makeText(Main2Activity.this,"Single Click",Toast.LENGTH_SHORT).show();
                            Button b = (Button)m2Pager;
                            String toSpeak = b.getText().toString();

                           // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            t2.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);


                        }
                        else if (i==2){
                            mp.start();
                            Toast.makeText(Main2Activity.this,"Double Click",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Iden_numbers.class);
                            startActivity(intent);

                        }
                        i=0;

                    }
                },1000);
                ///

            }
        });
        rating.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                i++;
                final View  m3Pager = v;
                Handler handler= new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){
                            vibrator.vibrate(1000);
                            Toast.makeText(Main2Activity.this,"Single Click",Toast.LENGTH_SHORT).show();
                            Button b = (Button)m3Pager;
                            String toSpeak = b.getText().toString();

                            //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            t2.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                        }
                        else if (i==2){
                            mp.start();
                            Toast.makeText(Main2Activity.this,"Double Click",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Ratings.class);
                            startActivity(intent);

                        }
                        i=0;

                    }
                },1000);

            }
        });
        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                final View  m4Pager = v;
                Handler handler= new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){
                            vibrator.vibrate(1000);
                           // mp1.start();
                            Toast.makeText(Main2Activity.this,"Single Click",Toast.LENGTH_SHORT).show();
                            Button b = (Button)m4Pager;
                            String toSpeak = b.getText().toString();

                           // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            t2.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                        }
                        else if (i==2){
                            mp.start();
                            Toast.makeText(Main2Activity.this,"Double Click",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Exam.class);
                            startActivity(intent);

                        }
                        i=0;

                    }
                },1000);

            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                final View  m5Pager = v;
                Handler handler= new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){
                            vibrator.vibrate(1000);
                           // mp2.start();
                            Toast.makeText(Main2Activity.this,"Single Click",Toast.LENGTH_SHORT).show();
                            Button b = (Button)m5Pager;
                            String toSpeak = b.getText().toString();

                            //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            t2.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                        }
                        else if (i==2){
                            mp.start();
                            Toast.makeText(Main2Activity.this,"Double Click",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Arithmetic.class);
                            startActivity(intent);

                        }
                        i=0;

                    }
                },1000);

            }
        });

    }
}
