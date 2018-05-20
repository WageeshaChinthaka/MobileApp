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
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends Activity {
    TextToSpeech t1;
   //  Button btnClick;
    Button btnRefresh;
   // TextView textCount;
    //;
    Button vib;


    Button button_got_to_other_activity;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });


       // btnClick =(Button)findViewById(R.id.buttonClick);
       // btnRefresh=(Button)findViewById(R.id.buttonRefresh);
       // textCount=(TextView)findViewById(R.id.textViewCounter);
        button_got_to_other_activity = (Button)findViewById(R.id.button_go_to_other_page);
        final MediaPlayer mp=MediaPlayer.create(this,R.raw.double_click);

        final Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
     //   vib=(Button)findViewById(R.id.button_vibrate) ;
//        vib.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               vibrator.vibrate(new long[]{0, 1000, 100, 1000}, -1);
//            }
//        });

      /*  vib.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                vibrator.vibrate(new long[]{1000, 1000,1000,1000}, -1);
                return true;
            }
        });*/







        button_got_to_other_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 i++;
                final View  mPager = v;
                Handler handler= new Handler();
                handler.postDelayed( new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){

                            vibrator.vibrate(1000);
                            Toast.makeText(MainActivity.this,"Single Click",Toast.LENGTH_SHORT).show();
//
                            Button b = (Button)mPager;
                            String toSpeak = b.getText().toString();

                           // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                        }
                        else if (i==2){
                            mp.start();
                            Toast.makeText(MainActivity.this,"Double Click",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                            startActivity(intent);

                        }
                        i=0;

                    }
                },1000);

            }
        });

    /*    btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String countValue=textCount.getText().toString();
                int intcountValue=Integer.parseInt(countValue);
                intcountValue++;
                textCount.setText(String.valueOf(intcountValue));
            }
        });*/
    }
}
