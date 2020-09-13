package com.example.torjan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycleadapter extends RecyclerView.Adapter<recycleadapter.ViewHolder> {

    private ArrayList<word> data;

    public recycleadapter(ArrayList<word> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sample_no, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sname.setText(data.get(position).getState_name().toString());
        holder.snumber.setText(data.get(position).getState_no().toString());

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView sname,snumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sname=(TextView) itemView.findViewById(R.id.state_name);
            snumber=(TextView) itemView.findViewById(R.id.phone_no);
        }
    }
}
