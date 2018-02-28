package com.example.mansopresk01.sampleproj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NavMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_main);
    }
    public void lefttorgt(View v){
        Intent i = new Intent(NavMainActivity.this,NavigationLtr.class);
        startActivity(i);
    }
    public void btmtotop(View v){
        Intent i2 = new Intent(NavMainActivity.this,RghtLeftActivity.class);
        startActivity(i2);
    }
    public void botmtotop(View v){
        Intent i2 = new Intent(NavMainActivity.this,BottomNavActivity.class);
        startActivity(i2);
    }
    public void toptobtm(View v){
        Intent i2 = new Intent(NavMainActivity.this,ToptoBtmActivity.class);
        startActivity(i2);
    }
}
