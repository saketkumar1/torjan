package com.example.torjan;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.torjan.Hospitals_Dashboards.regional;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.ViewHolder>{

    private ArrayList<regional> listStateWise;
    private Context context;

    public HospitalAdapter(Context context) {

        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_states,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.txtstates.setText(listStateWise.get(position).getState());

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

             CustomDialog customDialog=new CustomDialog((Activity) context,listStateWise.get(position).getState(),listStateWise.get(position).getTotalHospitals()
                     ,listStateWise.get(position).getTotalBeds(), listStateWise.get(position).getRuralHospitals(),listStateWise.get(position).getUrbanHospitals()
             ,listStateWise.get(position).getRuralBeds(),listStateWise.get(position).getUrbanBeds(),listStateWise.get(position).getAsOn());

             customDialog.startLoading();

            }
        });

    }

    @Override
    public int getItemCount() {
        return listStateWise.size();
    }

    public void setListStateWise(ArrayList<regional> listStateWise) {
        this.listStateWise = listStateWise;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private MaterialCardView parent;
        private TextView txtstates;
        private RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parent=itemView.findViewById(R.id.parent);
            txtstates=itemView.findViewById(R.id.txtStates);
            relativeLayout=itemView.findViewById(R.id.relLayoutStates);
        }
    }

}
