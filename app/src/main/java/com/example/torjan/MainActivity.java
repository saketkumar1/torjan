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
    }
}