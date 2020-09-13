package com.example.torjan;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDialogFragment;

public class CustomDialog extends AppCompatDialogFragment {

    private Activity activity;
    private AlertDialog dialog;
    private TextView txtStateName,txtTotalHospital,txtTotalBeds,txtRuralHospital,txtUrbanHospital,txtRuralBeds,txtUrbanBeds,txtLastUpdated;
    private String stateName,totalHospital,totalBeds,ruralHospital,urbanHospital,ruralBeds,urbanBeds,lastUpdated;

    public CustomDialog(Activity activity, String stateName, String totalHospital, String totalBeds, String ruralHospital, String urbanHospital, String ruralBeds, String urbanBeds, String lastUpdated) {
        this.activity = activity;
        this.stateName = stateName;
        this.totalHospital = totalHospital;
        this.totalBeds = totalBeds;
        this.ruralHospital = ruralHospital;
        this.urbanHospital = urbanHospital;
        this.ruralBeds = ruralBeds;
        this.urbanBeds = urbanBeds;
        this.lastUpdated = lastUpdated;
    }

    public void startLoading(){

        AlertDialog.Builder builder=new AlertDialog.Builder(activity);

        LayoutInflater inflater=activity.getLayoutInflater();
        View view=inflater.inflate(R.layout.custom_dialog,null);
        builder.setView(view);

        txtStateName=view.findViewById(R.id.txtStateName);
        txtTotalHospital=view.findViewById(R.id.txtTotalHospitalStates);
        txtTotalBeds=view.findViewById(R.id.txtTotalBedsStates);
        txtRuralHospital=view.findViewById(R.id.txtTotalRuralHospitalStates);
        txtRuralBeds=view.findViewById(R.id.txtRuralBedsStates);
        txtUrbanHospital=view.findViewById(R.id.txtUrbanHospitalStates);
        txtUrbanBeds=view.findViewById(R.id.txtUrbanBedsStates);
        txtLastUpdated=view.findViewById(R.id.txtLastUpdatesHostipal);

        txtStateName.setText(stateName);
        txtTotalHospital.setText(totalHospital);
        txtTotalBeds.setText(totalBeds);
        txtRuralHospital.setText(ruralHospital);
        txtUrbanHospital.setText(urbanHospital);
        txtRuralBeds.setText(ruralBeds);
        txtUrbanBeds.setText(urbanBeds);
        txtLastUpdated.setText(lastUpdated);

        builder.setCancelable(true);
        dialog=builder.create();
        dialog.show();

    }

    public void dismissDialog(){
        dialog.dismiss();
    }

}
