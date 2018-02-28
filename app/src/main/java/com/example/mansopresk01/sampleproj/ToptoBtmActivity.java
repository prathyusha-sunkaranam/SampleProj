package com.example.mansopresk01.sampleproj;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.SlidingDrawer;
import android.widget.Toast;

public class ToptoBtmActivity extends AppCompatActivity {

    SlidingDrawer slidingdrawer;
    Button SlidingButton;
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topto_btm);

        slidingdrawer = (SlidingDrawer)findViewById(R.id.slidingDrawer1);
        SlidingButton = (Button)findViewById(R.id.handle);

        slidingdrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {

            @Override
            public void onDrawerOpened() {

                Toast.makeText(ToptoBtmActivity.this, "Sliding drawer open", Toast.LENGTH_LONG).show();
            }
        });

        slidingdrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {

            public void onDrawerClosed() {

                Toast.makeText(ToptoBtmActivity.this, "Sliding drawer close", Toast.LENGTH_LONG).show();

            }

        });

    }


}
