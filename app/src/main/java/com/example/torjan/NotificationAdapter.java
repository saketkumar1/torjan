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
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private ArrayList<com.example.torjan.Notification_Advisiroy.notification> notifications;
    private Context context;

    public NotificationAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.list_item_notification,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

      holder.txtTitle.setText("wadaswdasdas");
      //holder.txtDate.setText(notifications.get(position).getDate());

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        holder.txtPDF.startAnimation(anim);

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
                      //intent.setData(Uri.parse(notifications.get(position).getLink()));
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

      holder.txtPDF.setOnClickListener(new View.OnClickListener() {
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

    public class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout parent;
        private TextView txtDate,txtTitle,txtPDF;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parent=itemView.findViewById(R.id.NotificationParent);
            txtDate=itemView.findViewById(R.id.txtDate);
            txtTitle=itemView.findViewById(R.id.txtTitle);
            txtPDF=itemView.findViewById(R.id.txtPDF);

        }
    }


}
