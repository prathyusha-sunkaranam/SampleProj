package com.example.mansopresk01.sampleproj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
    public void labels(View v){
        Intent lab = new Intent(FirstActivity.this,MainActivity.class);
        startActivity(lab);
    }
    public void navigation(View v){
        Intent lab = new Intent(FirstActivity.this,NavMainActivity.class);
        startActivity(lab);
    }
    public void webview(View v){
        Intent lab = new Intent(FirstActivity.this,WebViewActivity.class);
        startActivity(lab);
    }

}
