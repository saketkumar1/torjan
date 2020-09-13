package com.example.torjan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.torjan.Contact_Helpline.Regional;
import com.example.torjan.Contact_Helpline.getContacts;
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
    private ArrayList<Regional> list;
    private ArrayList<String> number;
    TextView callTextView;
    Integer stateNo=-1;
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
        spinner=findViewById(R.id.state_spinner);
        callTextView=findViewById(R.id.callTextView);
        load();

        callTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                if(stateNo==-1)
                    callIntent.setData(Uri.parse("tel:" + "1075"));
                else
                    callIntent.setData(Uri.parse("tel:" + number.get(stateNo)));//change the number
                startActivity(callIntent);
            }
        });


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
    public void load() {
        AppAPI appAPI = BaseURL.getAPIService();
        Call<getContacts> call = appAPI.getContacts();
        call.enqueue(new Callback<getContacts>() {
            @Override
            public void onResponse(Call<getContacts> call, Response<getContacts> response) {
                list=new ArrayList<>();
                list=response.body().getData().getContacts().getRegional();
                //String[] ss={"Delhi","Raj","up","mp","dsa","up","mp","dsa"};
                ArrayList<String> arrayList=new ArrayList<>();
                number=new ArrayList<>();
                arrayList.add("Select your state");
                for(int item=0;item<list.size();item++){
                    arrayList.add(list.get(item).getLoc());
                    number.add((list.get(item).getNumber()));
                }
                ArrayAdapter<String> adapter=new ArrayAdapter<>(phone_activity.this,R.layout.state,arrayList);
                spinner.setAdapter(adapter);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position>0) {
                            stateNo=position-1;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onFailure(Call<getContacts> call, Throwable t) {

            }
        });

    }


}