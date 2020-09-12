package com.example.torjan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class dashboard_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.navigation_hospital_dashboard);


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
                        startActivity(new Intent(getApplicationContext(),notification.class));
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