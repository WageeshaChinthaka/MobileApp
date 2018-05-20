package com.example.umanga.clicker;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;

public class Main3Activity_speach extends  AppCompatActivity {

    private TextView txvResult3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_speach);
        txvResult3=(TextView)findViewById(R.id.editText_n);
        setupDomath_2();
    }
    private void setupDomath_2(){
        Button b_ok3;
        b_ok3=(Button)findViewById(R.id.button_go_main3);
        b_ok3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userTextEntry3=(EditText)findViewById(R.id.editText_n);
                String userdeta3=userTextEntry3.getText().toString();
                int usernumber3=Integer.parseInt(userdeta3);
                StoreValues.getInstance().setNo3(usernumber3);
                Intent intent=new Intent(getApplicationContext(),Level1QuestionsActivity.class);
                intent.putExtra("level","1");
                startActivity(intent);

            }
        }); 


    }
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
                if (resultCode==RESULT_OK && data!=null){
                    ArrayList<String> result  =data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txvResult3.setText(result.get(0));
                }

                break;
        }

    }
}

