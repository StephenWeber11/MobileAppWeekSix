package com.uncc.mobileappdev.mobileappweeksix;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by StephenWeber on 2/26/2018.
 */

public class EmailRecyclerAdapter extends RecyclerView.Adapter<EmailRecyclerAdapter.ViewHolder> {
    ArrayList<Email> mData;

    public EmailRecyclerAdapter(ArrayList<Email> mData) {
        this.mData = mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Email email = mData.get(position);

        holder.subject.setText(email.subject);
        holder.body.setText(email.body);
        holder.sender.setText(email.sender);
        holder.email = email;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView subject;
        TextView body;
        TextView sender;
        Email email;

        public ViewHolder(View itemView) {
            super(itemView);
            subject = itemView.findViewById(R.id.emailSubject);
            body = itemView.findViewById(R.id.emailBody);
            sender = itemView.findViewById(R.id.emailSender);

//            itemView.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.d("Demo", "Clicked the button " + email.sender);
//                }
//            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Demo","CLICKED: " + email.sender);
                }
            });
        }
    }
}
