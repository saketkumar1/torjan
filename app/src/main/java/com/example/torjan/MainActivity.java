package com.example.torjan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.torjan.Contact_Helpline.getContacts;
import com.example.torjan.Webservice.AppAPI;
import com.example.torjan.Webservice.BaseURL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
//firebase credentials
//torjantrio@gmail.com
//topper@9876

    int a=0;//by abhinav sample data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView=findViewById(R.id.TextView);
        load();
    }
    public static void load(){
        AppAPI appAPI= BaseURL.getAPIService();
        Call<getContacts>call=appAPI.getContacts();
        call.enqueue(new Callback<getContacts>() {
            @Override
            public void onResponse(Call<getContacts> call, Response<getContacts> response) {
                Log.e("dasdsa",response.body().getData().getContacts().getRegional().get(0).getLoc().toString());
                Log.i("fsdafddfdsfdsf",response.body().getLastOriginUpdate());
            }

            @Override
            public void onFailure(Call<getContacts> call, Throwable t) {
                Log.e("error",t.getCause().toString());
            }
        });
    }
}