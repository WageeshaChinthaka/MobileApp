package com.example.umanga.clicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Level1QuestionsActivity extends Activity {

    TextView textViewQuestion;
    EditText editTextAnswer;
    Button buttonCheckAnswer;
    TextView textViewAnswerState;
    TextView tt;
    TextToSpeech ttn;
    Button a;
    private TextView txvResult;
    int i=0;
    Button back_question;

    String level1Quetion = "5 + 2";
    String level2Quetion = "6 + 3";
    String level3Quetion = "8 - 2";
    String level4Quetion = "3 + 5";
    String level5Quetion = "6 - 1";

    String level1Answer = "7";
    String level2Answer = "9";
    String level3Answer = "6";
    String level4Answer = "8";
    String level5Answer = "5";
    Context context;
    int no1;
    int no3;

    String releventAnswer = "";
    public void getSpeechInput(View view) {
        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager())!= null) {
            startActivityForResult(intent, 10);
        } else {

            Toast.makeText(this,"Your device don't support speech input",Toast.LENGTH_SHORT).show();
        }



    }

    private void setupDomath(){


       Button b_ok;
       b_ok=(Button)findViewById(R.id.button_go_spech);
        b_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userTextEntry=(EditText)findViewById(R.id.activity_level1_questions_edittext_answer);
                String userdeta=userTextEntry.getText().toString();
                int usernumber=Integer.parseInt(userdeta);
                StoreValues.getInstance().setNo1(usernumber);
                Intent intent=new Intent(Level1QuestionsActivity.this,Plus.class);
//                intent.putExtra("parameter name",usernumber);
                startActivity(intent);
            }
        });

    }
    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
                if (resultCode==RESULT_OK && data!=null){
                    ArrayList<String> result  =data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    editTextAnswer.setText(result.get(0));
                }

                break;
        }

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1_questions);

        ttn=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    ttn.setLanguage(Locale.UK);
                }
            }
        });

        context = this;
        no1 = StoreValues.getInstance().getNo1();
        TextView displayNumber;
        displayNumber=(TextView)findViewById(R.id.activity_level1_questions_textview_answer_state);
        displayNumber.setText(""+no1);

        final Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        final MediaPlayer mp3=MediaPlayer.create(this,R.raw.double_click);
        back_question=(Button)findViewById(R.id.back_question1);
        back_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;

                final View  m6backPager = v;
                Handler handler= new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){
                            vibrator.vibrate(1000);
                            Toast.makeText(Level1QuestionsActivity.this,"Single Click",Toast.LENGTH_SHORT).show();
                            Button b = (Button)m6backPager;
                            String toSpeak = b.getText().toString();

                           // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            ttn.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);


                        }
                        else if (i==2){
                            mp3.start();
                            Toast.makeText(Level1QuestionsActivity.this,"Double Click",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Level_1 .class);
                            startActivity(intent);

                        }
                        i=0;

                    }
                },1000);
            }
        });






        final String level = getIntent().getStringExtra("level");
        final MediaPlayer mp=MediaPlayer.create(this,R.raw.catsound);
        final MediaPlayer mp2=MediaPlayer.create(this,R.raw.incorrect);


        textViewQuestion = (TextView)findViewById(R.id.activity_level1_questions_textview_question);
        editTextAnswer = (EditText)findViewById(R.id.activity_level1_questions_edittext_answer);
        buttonCheckAnswer = (Button)findViewById(R.id.activity_level1_questions_button_checkanswer);
        textViewAnswerState = (TextView)findViewById(R.id.activity_level1_questions_textview_answer_state);
        tt=(TextView)findViewById(R.id.activity_level1_questions_gotanswer) ;
        a=(Button)findViewById(R.id.button_answer_n);

        no3 = StoreValues.getInstance().getNo3();
        Intent intent=getIntent();
        editTextAnswer
                .setText(""+no3);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                final View  m_backPager = v;
                Handler handler= new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){
                            vibrator.vibrate(1000);
                            Toast.makeText(Level1QuestionsActivity.this,"Single Click",Toast.LENGTH_SHORT).show();
//
                            Button b = (Button)m_backPager;
                            String toSpeak = b.getText().toString();

                            //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            ttn.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                        }
                        else if (i==2){
                            if(level.equals("1")){
                            Button b = (Button)m_backPager;
                            String buttonText = b.getText().toString();
                            String toSpeak = level1Quetion;

                            // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                            ttn.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                            Toast.makeText(Level1QuestionsActivity.this,"Double Click",Toast.LENGTH_SHORT).show();



                        }
                            if(level.equals("2")){
                                Button b = (Button)m_backPager;
                                String buttonText = b.getText().toString();
                                String toSpeak = level2Quetion;
                                // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                                ttn.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                                Toast.makeText(Level1QuestionsActivity.this,"Double Click",Toast.LENGTH_SHORT).show();



                            }
                            if(level.equals("3")){
                                Button b = (Button)m_backPager;
                                String buttonText = b.getText().toString();
                                String toSpeak = "eight minus two";
                                // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                                ttn.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                                Toast.makeText(Level1QuestionsActivity.this,"Double Click",Toast.LENGTH_SHORT).show();



                            }
                            if(level.equals("4")){
                                Button b = (Button)m_backPager;
                                String buttonText = b.getText().toString();
                                String toSpeak = level4Quetion;
                                // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                                ttn.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                                Toast.makeText(Level1QuestionsActivity.this,"Double Click",Toast.LENGTH_SHORT).show();



                            }
                            if(level.equals("5")){
                                Button b = (Button)m_backPager;
                                String buttonText = b.getText().toString();
                                String toSpeak = "Six minus one";
                                // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                                ttn.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                                Toast.makeText(Level1QuestionsActivity.this,"Double Click",Toast.LENGTH_SHORT).show();



                            }


                        }
                        i=0;

                    }
                },1000);

            }
        });
      /*  tt= new TextToSpeech(getApplicationContext(),new TextToSpeech.OnInitListener()
        {
            public void onInit(int status){

                if(status !=TextToSpeech.ERROR)
                    tt.setLanguage(Locale.UK);
            }

        }

        );*/

        if(level.equals("1")){
            textViewQuestion.setText(level1Quetion);
            releventAnswer = level1Answer;
        }
        else if(level.equals("2")){
            textViewQuestion.setText(level2Quetion);
            releventAnswer = level2Answer;
        }
        else if(level.equals("3")){
            textViewQuestion.setText(level3Quetion);
            releventAnswer = level3Answer;
        }
        else if(level.equals("4")){
            textViewQuestion.setText(level4Quetion);
            releventAnswer = level4Answer;
        }
        else if(level.equals("5")){
            textViewQuestion.setText(level5Quetion);
            releventAnswer = level5Answer;
        }

       buttonCheckAnswer.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               i++;
               final View  mlevel1Pager = v;
               Handler handler= new Handler();
               handler.postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       if(i==1){
                           vibrator.vibrate(1000);
                           Toast.makeText(Level1QuestionsActivity.this,"Single Click",Toast.LENGTH_SHORT).show();
//
                           Button b = (Button)mlevel1Pager;
                           String toSpeak = b.getText().toString();

                           // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                           ttn.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                       }
                       else if (i==2){
                           if(releventAnswer.equals(editTextAnswer.getText().toString())){

                               if(level.equals("1")){
                                   textViewAnswerState.setText("Correct");
                                   SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
                                   SharedPreferences.Editor editor = preferences.edit();
                                   editor.putString("isLevel"+level+"Answered","yes");
                                   editor.apply();
                                   Button b = (Button)mlevel1Pager;
                                   String buttonText = b.getText().toString();
                                   String toSpeak = "Answer is correct you have to move next question";
                                   // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                                   ttn.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                                   mp.start();


                               }
                               if(level.equals("2")){
                                   textViewAnswerState.setText("Correct");
                                   SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
                                   SharedPreferences.Editor editor = preferences.edit();
                                   editor.putString("isLevel"+level+"Answered","yes");
                                   editor.apply();
                                   Button b = (Button)mlevel1Pager;
                                   String buttonText = b.getText().toString();
                                   String toSpeak = "Answer is correct you have to move next question";
                                   // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                                   ttn.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                                   mp.start();


                               }
                               if(level.equals("3")){
                                   textViewAnswerState.setText("Correct");
                                   SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
                                   SharedPreferences.Editor editor = preferences.edit();
                                   editor.putString("isLevel"+level+"Answered","yes");
                                   editor.apply();
                                   Button b = (Button)mlevel1Pager;
                                   String buttonText = b.getText().toString();
                                   String toSpeak = "Answer is correct you have to move next question";
                                   // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                                   ttn.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                                   mp.start();


                               }
                               if(level.equals("4")){
                                   textViewAnswerState.setText("Correct");
                                   SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
                                   SharedPreferences.Editor editor = preferences.edit();
                                   editor.putString("isLevel"+level+"Answered","yes");
                                   editor.apply();
                                   Button b = (Button)mlevel1Pager;
                                   String buttonText = b.getText().toString();
                                   String toSpeak = "Answer is correct you have to move next question";
                                   // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                                   ttn.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                                   mp.start();


                               }
                               if(level.equals("5")){
                                   textViewAnswerState.setText("Correct");
                                   SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
                                   SharedPreferences.Editor editor = preferences.edit();
                                   editor.putString("isLevel"+level+"Answered","yes");
                                   editor.apply();
                                   Button b = (Button)mlevel1Pager;
                                   String buttonText = b.getText().toString();
                                   String toSpeak = "Answer is correct you have to move next level";
                                   // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                                   ttn.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                                   mp.start();


                               }



                           }
                           else{
                               textViewAnswerState.setText("Incorrect");
                               Button b = (Button)mlevel1Pager;
                               String buttonText = b.getText().toString();
                               String toSpeak = "Answer is Incorrect";
                               //
                               ttn.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                               mp2.start();


                           }


                       }
                       i=0;

                   }
               },1000);
           }
       });

    }
   /* public void speach_my_text(View vv){

        String string=textViewQuestion.toString();
        tt.speak(string,TextToSpeech.QUEUE_FLUSH,null,null);
    }*/
}
