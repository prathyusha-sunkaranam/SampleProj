package com.example.mansopresk01.sampleproj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    CheckBox tc;
    Button login,clear,validate,test,lefttorgt,btmtotop;
    RadioButton rb;
    RadioGroup radioGroup;
    RatingBar rating;
    ToggleButton toglebtn;
    Switch Switch;
    TextView date;
    Spinner spinner;
    Calendar c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.username_input);
        password = (EditText) findViewById(R.id.password_input);
        tc = (CheckBox) findViewById(R.id.terms);
        login = (Button) findViewById(R.id.login_btn);
        clear = (Button) findViewById(R.id.clear_btn);
        validate = (Button) findViewById(R.id.validate);
        test = (Button) findViewById(R.id.test_btn);
radioGroup=(RadioGroup)findViewById(R.id.radiogroup) ;
        rating = (RatingBar) findViewById(R.id.rating);
        toglebtn = (ToggleButton) findViewById(R.id.toggle_btn);
        Switch = (Switch) findViewById(R.id.switch_btn);
        date = (TextView)findViewById(R.id.date_Lable);
        spinner=(Spinner)findViewById(R.id.spnr);
//        //String date1 = date.getText().toString();
//        String date1 = c.get(Calendar.DAY_OF_MONTH)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.YEAR);
//        Toast.makeText(this, "date1", Toast.LENGTH_SHORT).show();
        String dt;
        Date cal = (Date) Calendar.getInstance().getTime();
        dt = cal.toLocaleString();
        date.setText(dt.toString());


    }
    public void valid(View v){
        if(username.getText().toString().isEmpty()){
            username.requestFocus();
            username.setError("");
        }
        else if (password.getText().toString().isEmpty()){
            password.requestFocus();
            password.setError("");
        }
        else if (tc.isChecked()){
            Toast.makeText(this, "Validation successful", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(this, "Accept terms and conditions", Toast.LENGTH_SHORT).show();
        }
    }
    public void clear(View v){
        username.setText("");
        password.setText("");
    }
    public void validation (View v){
        String rating1 = String.valueOf(rating.getRating());
        int selectedId = radioGroup.getCheckedRadioButtonId();
        rb = (RadioButton)findViewById(selectedId);
        String st = spinner.getSelectedItem().toString();
       Toast.makeText(this, rb.getText().toString()+""+rating1+""+st, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, st, Toast.LENGTH_SHORT).show();
    }
    public void test (View v){
        if(Switch.isChecked() && toglebtn.isChecked()){
            Toast.makeText(this, "on", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "off", Toast.LENGTH_SHORT).show();
        }
    }



}
