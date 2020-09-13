package com.example.torjan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.torjan.Hospitals_Dashboards.getHospitalbeds;
import com.example.torjan.Hospitals_Dashboards.getMedicalcollegeBeds;
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
    RecyclerView recyclerView;
    ArrayList<word> title;
    recycleadapter recycleadapter1;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.navigation_helpline);
        spinner=findViewById(R.id.state_spinner);
        recyclerView=findViewById(R.id.state_recycle);

        String[] ss={"Delhi","Raj","up","mp"};
        ArrayList<String> arrayList=new ArrayList<>(Arrays.asList(ss));
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.state,arrayList);
        spinner.setAdapter(adapter);


        title = new ArrayList<>();


        title.add(new word("delhiii","987654321"));
        title.add(new word("up","987654321"));
        title.add(new word("mp","987654321"));
        title.add(new word("bihar","987654321"));
        title.add(new word("delhiii","987654321"));
        title.add(new word("delhiii","987654321"));


        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recycleadapter1 = new recycleadapter(title);
        recyclerView.setAdapter(recycleadapter1);




















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
        Call<getMedicalcollegeBeds> call = appAPI.getMedicalcollegeBeds();
        call.enqueue(new Callback<getMedicalcollegeBeds>() {
            @Override
            public void onResponse(Call<getMedicalcollegeBeds> call, Response<getMedicalcollegeBeds> response) {
                Log.i("dsakjdn",response.body().getData().getMedicalColleges().get(15).getState());
            }

            @Override
            public void onFailure(Call<getMedicalcollegeBeds> call, Throwable t) {

            }
        });
    }
}