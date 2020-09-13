package com.example.torjan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.torjan.Hospitals_Dashboards.getHospitalbeds;
import com.example.torjan.Notification_Advisiroy.getAdvisory;
import com.example.torjan.Webservice.AppAPI;
import com.example.torjan.Webservice.BaseURL;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class phone_activity extends AppCompatActivity {
//firebase credentials
//torjantrio@gmail.com
//topper@9876


    int a=0;//by abhinav sample data
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.navigation_helpline);
        spinner=findViewById(R.id.state_spinner);

        String[] ss={"Delhi","Raj","up","mp"};
        ArrayList<String> arrayList=new ArrayList<>(Arrays.asList(ss));
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.state,arrayList);
        spinner.setAdapter(adapter);


        load();


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

    public static void load() {
        AppAPI appAPI = BaseURL.getAPIService();
        Call<getHospitalbeds> call = appAPI.getHospitalbeds();
        call.enqueue(new Callback<getHospitalbeds>() {
            @Override
            public void onResponse(Call<getHospitalbeds> call, Response<getHospitalbeds> response) {
                Log.e("safadsfsda", response.body().getData().getRegional().get(5).getState());
            }

            @Override
            public void onFailure(Call<getHospitalbeds> call, Throwable t) {

            }
        });
    }
}