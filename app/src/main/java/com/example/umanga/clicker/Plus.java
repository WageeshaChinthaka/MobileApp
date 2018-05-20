package com.example.umanga.clicker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Plus extends Activity {
    Button num_1;
    Button num_2;
    int no1;
    int no2;
    TextView textCount;
    //Button result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus);

        no1 = StoreValues.getInstance().getNo1();
        no2 = StoreValues.getInstance().getNo2();
        Intent intent=getIntent();
//        if(intent.hasExtra("parameter name")){
//            int muvalue=intent.getIntExtra("parameter name",0);
            TextView displayNumber;
            displayNumber=(TextView)findViewById(R.id.textViewUserNumber);
            displayNumber.setText(""+no1);
//        }


//      Intent intents=getIntent();
//        int mvalue=intents.getIntExtra("parameter nam",0);
        TextView displayNumber2;
        displayNumber2=(TextView)findViewById(R.id.textView);
        displayNumber2.setText(""+no2);

        num_2=(Button)findViewById(R.id.button_2num);
        num_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Speech_2.class);
                startActivity(intent);

            }
        });
        num_1=(Button)findViewById(R.id.button_1num);
        num_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Speech.class);
                startActivity(intent);
            }
        });


        Button button_answer = (Button)findViewById(R.id.button_answer);
        button_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int answer = no1 + no2;
                TextView textanswer = (TextView)findViewById(R.id.textanswer);
                textanswer.setText(answer+"");
            }
        });
    }
}
