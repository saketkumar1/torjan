package com.example.torjan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class stat extends AppCompatActivity {


    private Spinner states,gender,age;
    private TextView start,end;
    private CardView c1,c2;
    private int m1,d1,y1,m2,d2,y2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.navigation_stat);

        states=findViewById(R.id.state_spinner1);
        gender=findViewById(R.id.gender_spinner);
        age=findViewById(R.id.age_spinner);
        start=findViewById(R.id.start_date);
        end=findViewById(R.id.end_date);
        c1=findViewById(R.id.card_start);
        c2=findViewById(R.id.card_end);



        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal=Calendar.getInstance();

                m1=cal.get(Calendar.MONTH);
                d1=cal.get(Calendar.DATE);
                y1=cal.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog=new DatePickerDialog(stat.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        start.setText(month+"/"+dayOfMonth+"/"+year);
                    }
                },y1,m1,d1);
                datePickerDialog.show();

            }
        });


        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal=Calendar.getInstance();

                m2=cal.get(Calendar.MONTH);
                d2=cal.get(Calendar.DATE);
                y2=cal.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog=new DatePickerDialog(stat.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        end.setText(month+"/"+dayOfMonth+"/"+year);
                    }
                },y2,m2,d2);
                datePickerDialog.show();

            }
        });



        String[] state={"delhi","up","mp","bihar"};
        ArrayList<String> arrayList=new ArrayList<>(Arrays.asList(state));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.state,arrayList);
        states.setAdapter(arrayAdapter);

        String[] genders={"Male","Female","N/a"};
        ArrayList<String> arrayList1=new ArrayList<>(Arrays.asList(genders));
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this,R.layout.state,arrayList1);
        gender.setAdapter(arrayAdapter1);


        String[] gap={"0-9","10-19","20-29","30-39","40-49"};
        ArrayList<String> arrayList2=new ArrayList<>(Arrays.asList(gap));
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this,R.layout.state,arrayList2);
        age.setAdapter(arrayAdapter2);




















        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_helpline:
                        startActivity(new Intent(getApplicationContext(), phone_activity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_stat:
                        startActivity(new Intent(getApplicationContext(),stat.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_notification:
                        startActivity(new Intent(getApplicationContext(), notification1.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_hospital_dashboard:
                        startActivity(new Intent(getApplicationContext(),dashboard_activity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}