package com.example.torjan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class stat extends AppCompatActivity {


    private Spinner states, gender, age;
    int statedata, agedata, genderdata;
    private TextView start, end;
    private CardView c1, c2;
    String datedata;
    String[] genders = {"male", "female", "N/a"};
    String[] gap = {"0-9", "10-19", "20-29", "30-39", "40-49", "50-59", "60-69", "70 & above"};
    String[] state = {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhatisgarh", "Chandigarh", "Delhi", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajsthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal"};

    private int m1, d1, y1, m2, d2, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.navigation_stat);

        states = findViewById(R.id.state_spinner1);
        gender = findViewById(R.id.gender_spinner);
        age = findViewById(R.id.age_spinner);
        start = findViewById(R.id.start_date);
        end = findViewById(R.id.end_date);
        c1 = findViewById(R.id.card_start);
        c2 = findViewById(R.id.card_end);


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();

                m1 = cal.get(Calendar.MONTH);
                d1 = cal.get(Calendar.DATE);
                y1 = cal.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(stat.this, android.R.style.Theme_DeviceDefault_Dialog_NoActionBar, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        if (dayOfMonth > 10)
                            datedata = dayOfMonth + "/" + month + "/" + year;
                        else
                            datedata = "0" + dayOfMonth + "/" + month + "/" + year;
                        start.setText(datedata);
                    }
                }, y1, m1, d1);
                datePickerDialog.show();

            }
        });


        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();

                m2 = cal.get(Calendar.MONTH);
                d2 = cal.get(Calendar.DATE);
                y2 = cal.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(stat.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        end.setText(month + "/" + dayOfMonth + "/" + year);
                    }
                }, y2, m2, d2);
                datePickerDialog.show();

            }
        });
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(state));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.state, arrayList);
        states.setAdapter(arrayAdapter);
        states.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                statedata = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList(genders));
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this, R.layout.state, arrayList1);
        gender.setAdapter(arrayAdapter1);
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                genderdata = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);






        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList(gap));
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this, R.layout.state, arrayList2);
        age.setAdapter(arrayAdapter2);
        age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                agedata = position;
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference();
                Query dataquery = myRef.orderByChild("Value").equalTo(state[statedata] + " " + datedata + " " + genders[genderdata] + " " + agedata + " " + "Deceased");
                dataquery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Log.e("jashdjuasasjukd", "" + snapshot.getChildrenCount());
                        Log.e("dasdadsds", state[statedata] + " " + datedata + " " + genders[genderdata] + " " + agedata + " " + "Deceased");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_helpline:
                        startActivity(new Intent(getApplicationContext(), phone_activity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navigation_stat:
                        startActivity(new Intent(getApplicationContext(), stat.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navigation_notification:
                        startActivity(new Intent(getApplicationContext(), notification1.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navigation_hospital_dashboard:
                        startActivity(new Intent(getApplicationContext(), dashboard_activity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,phone_activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

}