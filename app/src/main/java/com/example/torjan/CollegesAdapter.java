package com.example.torjan;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.torjan.Hospitals_Dashboards.medicalColleges;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class CollegesAdapter extends RecyclerView.Adapter<CollegesAdapter.ViewHolder>{

    private ArrayList<medicalColleges> listCollegeWise;
    private Context context;

    public CollegesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_colleges,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.txtCollegeName.setText(listCollegeWise.get(position).getName());

        switch (position%5){

            case 0:
                holder.relativeLayout.setBackgroundColor(Color.parseColor("#FFFAE41F"));
                break;

            case 1:
                holder.relativeLayout.setBackgroundColor(Color.parseColor("#FF28F6E2"));
                break;

            case 2:
                holder.relativeLayout.setBackgroundColor(Color.parseColor("#FFF62B1C"));
                break;

            case 3:
                holder.relativeLayout.setBackgroundColor(Color.parseColor("#FF1D7EF4"));
                break;

            case 4:
                holder.relativeLayout.setBackgroundColor(Color.parseColor("#FFBB30F6"));
                break;


            default: break;

        }

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomDialogColleges customDialog=new CustomDialogColleges((Activity) context,listCollegeWise.get(position).getState(),listCollegeWise.get(position).getName(),listCollegeWise.get(position).getCity()
                ,listCollegeWise.get(position).getOwnership(),listCollegeWise.get(position).getAdmissionCapacity(),listCollegeWise.get(position).getHospitalBeds());

                customDialog.startLoading();

            }
        });

    }

    @Override
    public int getItemCount() {
        return listCollegeWise.size();
    }

    public void setListCollegeWise(ArrayList<medicalColleges> listCollegeWise) {
        this.listCollegeWise = listCollegeWise;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        private MaterialCardView parent;
        private TextView txtCollegeName;
        private RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parent=itemView.findViewById(R.id.parentColleges);
            txtCollegeName=itemView.findViewById(R.id.txtMedicalCollegeName);
            relativeLayout=itemView.findViewById(R.id.relLayoutColleges);

        }
    }

}
