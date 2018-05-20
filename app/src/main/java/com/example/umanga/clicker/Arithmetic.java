package com.example.umanga.clicker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Arithmetic extends Activity{

    Button pls;
    Button mn;
    Button mul;
    Button devition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arithmetic);
        devition=(Button)findViewById(R.id.button_d);
        devition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Division.class);
                startActivity(intent);

            }
        });
        mul=(Button)findViewById(R.id.button_s);
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),Multification.class);
                startActivity(intent);

            }
        });
        mn=(Button)findViewById(R.id.button_m);
        mn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),Minus.class);
                startActivity(intent);

            }
        });
        pls=(Button)findViewById(R.id.button_p);

pls.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent intent=new Intent(getApplicationContext(),Plus.class);
        startActivity(intent);
    }
});    }
}
