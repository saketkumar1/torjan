package com.example.torjan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.torjan.Notification_Advisiroy.getAdvisory;
import com.example.torjan.Webservice.AppAPI;
import com.example.torjan.Webservice.BaseURL;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class notification1 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NotificationAdapter adapter;
    private ArrayList<com.example.torjan.Notification_Advisiroy.notification> notifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_nav);
        load();

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
                        startActivity(new Intent(getApplicationContext(),notification1.class));
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
    public void load(){
        AppAPI appAPI= BaseURL.getAPIService();
        Call<getAdvisory> call=appAPI.getAdvisory();
        call.enqueue(new Callback<getAdvisory>() {
            @Override
            public void onResponse(Call<getAdvisory> call, Response<getAdvisory> response) {
                notifications=new ArrayList<>();
                notifications=response.body().getData().getNotification();
                if(notifications.size()>0) {
                    adapter = new NotificationAdapter(notification1.this, notifications);
                    adapter.setNotifications(notifications);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    Log.i("djasjhfdaskjdhask", "" + notifications.size());
                }
            }

            @Override
            public void onFailure(Call<getAdvisory> call, Throwable t) {
                Log.e("error",t.getCause().toString());
            }
        });
    }



}