package com.example.torjan;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDialogFragment;

public class CustomDialogColleges extends AppCompatDialogFragment {

    private Activity activity;
    private AlertDialog dialog;
    private TextView txtStateName,txtCollegeName,txtCityName,txtOwnership,txtAdmissionCapacity,txtHospitalBeds;
    private String stateName,collegeName,cityName,ownership,admissionCapacity,hospitalBeds;

    public CustomDialogColleges(Activity activity, String stateName, String collegeName, String cityName, String ownership, String admissionCapacity, String hospitalBeds) {
        this.activity = activity;
        this.stateName = stateName;
        this.collegeName = collegeName;
        this.cityName = cityName;
        this.ownership = ownership;
        this.admissionCapacity = admissionCapacity;
        this.hospitalBeds = hospitalBeds;
    }

    public void startLoading(){

        AlertDialog.Builder builder=new AlertDialog.Builder(activity);

        LayoutInflater inflater=activity.getLayoutInflater();
        View view=inflater.inflate(R.layout.custom_dialog_colleges,null);


        txtStateName=view.findViewById(R.id.txtStateNmaeColleges);
        txtCollegeName=view.findViewById(R.id.txtCollegeName);
        txtCityName=view.findViewById(R.id.txtCities);
        txtOwnership=view.findViewById(R.id.txtOwnership);
        txtAdmissionCapacity=view.findViewById(R.id.txtAdmissionCapicity);
        txtHospitalBeds=view.findViewById(R.id.txtHospitalBeds);

        txtStateName.setText(stateName);
        txtCollegeName.setText(collegeName);
        txtCityName.setText(cityName);
        txtOwnership.setText(ownership);
        txtAdmissionCapacity.setText(admissionCapacity);
        txtHospitalBeds.setText(hospitalBeds);

        builder.setView(view);
        builder.setCancelable(true);
        dialog=builder.create();
        dialog.show();

    }

    public void dismissDialog(){
        dialog.dismiss();
    }

}
