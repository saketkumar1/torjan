package com.example.torjan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class notification extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NotificationAdapter adapter;
    private ArrayList<NotificationModel> notifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.navigation_notification);
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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView=findViewById(R.id.recyclerViewNotifications);
        notifications=new ArrayList<>();

        notifications.add(new NotificationModel("Revised guidelines for International\n" +
                "Arrivals","02.08.2020","https://www.mohfw.gov.in/pdf/RevisedguidelinesforInternationalArrivals02082020.pdf"));
        notifications.add(new NotificationModel("Revised guidelines for International\n" +
                "Arrivals","02.08.2020","https://www.mohfw.gov.in/pdf/RevisedguidelinesforInternationalArrivals02082020.pdf"));
        notifications.add(new NotificationModel("Revised guidelines for International\n" +
                "Arrivals","02.08.2020","https://www.mohfw.gov.in/pdf/RevisedguidelinesforInternationalArrivals02082020.pdf"));
        notifications.add(new NotificationModel("Revised guidelines for International\n" +
                "Arrivals","02.08.2020","https://www.mohfw.gov.in/pdf/RevisedguidelinesforInternationalArrivals02082020.pdf"));

        adapter=new NotificationAdapter(notification.this);
        adapter.setNotifications(notifications);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:
                onBackPressed();
                break;

            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}