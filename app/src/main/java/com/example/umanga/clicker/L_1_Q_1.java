package com.example.umanga.clicker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class L_1_Q_1 extends Activity{
    Button proceed;
    Button q1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_1__q_1);
        q1=(Button)findViewById(R.id.button_1_number);
        q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Speech.class);
                startActivity(intent);

            }
        });
        proceed=(Button)findViewById(R.id.button_proceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Level_1.class);
                startActivity(intent);
            }
        });
    }
}
