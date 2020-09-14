package com.example.torjan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
    ArrayList<String> arrayList;
    recycleadapter recycleadapter1;
    private RecyclerView.LayoutManager layoutManager;
    ImageView facebook;
    String facebbokvalue;
    ImageView twitter;
    String twittervalue;
    ImageView gmail;
    String gmailvalue;
    ImageView media;
    String mediavalue;
    ProgressBar progressbar;

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
        facebook=findViewById(R.id.facebookImageView);
        twitter=findViewById(R.id.TwitterImageVIew);
        gmail=findViewById(R.id.gmailImageVIew);
        media=findViewById(R.id.mediaImageView);
        progressbar=findViewById(R.id.progressbar);
        progressbar.setVisibility(View.VISIBLE);
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
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(facebbokvalue));
                startActivity(intent);

            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(twittervalue));
                startActivity(intent);
            }
        });
        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + gmailvalue));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "your_subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "your_text");
                    startActivity(intent);
                }catch(ActivityNotFoundException e){
                    //TODO smth
                }

            }
        });
        media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(mediavalue));
                startActivity(intent);
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
    public void load() {
        AppAPI appAPI = BaseURL.getAPIService();
        Call<getContacts> call = appAPI.getContacts();
        call.enqueue(new Callback<getContacts>() {
            @Override
            public void onResponse(Call<getContacts> call, Response<getContacts> response) {
                list=new ArrayList<>();
                list=response.body().getData().getContacts().getRegional();
                facebbokvalue=response.body().getData().getContacts().getPrimary().getFacebook();
                twittervalue=response.body().getData().getContacts().getPrimary().getTwitter();
                gmailvalue=response.body().getData().getContacts().getPrimary().getEmail();
                mediavalue=response.body().getData().getContacts().getPrimary().getmedia().get(0);
                //String[] ss={"Delhi","Raj","up","mp","dsa","up","mp","dsa"};
                arrayList=new ArrayList<>();
                number=new ArrayList<>();
                arrayList.add("Select your state");
                for(int item=0;item<list.size();item++){
                    arrayList.add(list.get(item).getLoc());
                    number.add((list.get(item).getNumber()));
                }
                progressbar.setVisibility(View.GONE);
                ArrayAdapter<String> adapter=new ArrayAdapter<>(phone_activity.this,R.layout.state,arrayList);
                spinner.setAdapter(adapter);
                title = new ArrayList<>();
                for(int count=0;count<number.size();count++){
                    title.add(new word(arrayList.get(count+1),number.get(count)));
                }


                recyclerView.setHasFixedSize(true);
                layoutManager = new LinearLayoutManager(phone_activity.this, LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(layoutManager);
                recycleadapter1 = new recycleadapter(title);
                recyclerView.setAdapter(recycleadapter1);

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