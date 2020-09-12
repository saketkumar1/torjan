package com.example.torjan;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    private ArrayList<com.example.torjan.Notification_Advisiroy.notification> notifications;
    private Context context;

    public NotificationAdapter(Context context, ArrayList<com.example.torjan.Notification_Advisiroy.notification> notifications) {
        this.context = context;
        this.notifications=notifications;
    }

    @NonNull
    @Override
    public NotificationAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.list_item_notification,parent,false);
        return new NotificationAdapter.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.MyViewHolder holder, final int position) {
        String str=notifications.get(position).getTitle();
        if(str.length()>10 && str.charAt(1)!='.') {
            holder.txtTitle.setText(str.substring(10));
            holder.txtDate.setText(str.substring(0, 9));
        }else{
            holder.txtTitle.setText(str);
            holder.txtDate.setText("----------");
        }

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
       // holder.txtPDF.startAnimation(anim);

      holder.txtTitle.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              AlertDialog.Builder builder = new AlertDialog.Builder(context);
              builder.setTitle("Notifications:");
              builder.setMessage("Are you sure want to visit site,then press 'VISIT'.");
              builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {

                      Intent intent = new Intent();
                      intent.setAction(Intent.ACTION_VIEW);
                      intent.addCategory(Intent.CATEGORY_BROWSABLE);
                      intent.setData(Uri.parse(notifications.get(position).getLink()));
                      context.startActivity(intent);

                  }
              });

              builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {

                  }
              });
              builder.create().show();

          }
      });
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public void setNotifications(ArrayList<com.example.torjan.Notification_Advisiroy.notification> notifications) {
        this.notifications = notifications;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout parent;
        private TextView txtDate,txtTitle,txtPDF;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            parent=itemView.findViewById(R.id.NotificationParent);
            txtDate=itemView.findViewById(R.id.txtDate);
            txtTitle=itemView.findViewById(R.id.txtTitle);

        }
    }


}
