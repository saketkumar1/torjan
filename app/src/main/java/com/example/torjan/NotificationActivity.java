package com.example.torjan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NotificationAdapter adapter;
    private ArrayList<NotificationModel> notifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

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

        adapter=new NotificationAdapter(NotificationActivity.this);
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