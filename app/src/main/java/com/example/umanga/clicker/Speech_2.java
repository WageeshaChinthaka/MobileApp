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

public class Speech_2 extends AppCompatActivity {

    private TextView txvResult2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_2);
        txvResult2=(TextView)findViewById(R.id.editText_2);
        setupDomath_2();
    }
    private void setupDomath_2(){
        Button b_ok2;
        b_ok2=(Button)findViewById(R.id.button_go_spech2);
        b_ok2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userTextEntry2=(EditText)findViewById(R.id.editText_2);
                String userdeta2=userTextEntry2.getText().toString();
                int usernumber2=Integer.parseInt(userdeta2);
                StoreValues.getInstance().setNo2(usernumber2);
                Intent intent=new Intent(Speech_2.this,Plus.class);
//                intent.putExtra("parameter nam",usernumber2);
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
                    txvResult2.setText(result.get(0));
                }

                break;
        }

    }
}
