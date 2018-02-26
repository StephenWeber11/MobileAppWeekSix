package com.uncc.mobileappdev.mobileappweeksix;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by StephenWeber on 2/25/2018.
 */

public class EmailAdapter extends ArrayAdapter<Email> {

    public EmailAdapter(@NonNull Context context, int resource, @NonNull List<Email> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Email email = getItem(position);
        ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.email_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.body = convertView.findViewById(R.id.emailBody);
            viewHolder.subject = convertView.findViewById(R.id.emailSubject);
            viewHolder.sender = convertView.findViewById(R.id.emailSender);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.subject.setText(email.subject);
        viewHolder.body.setText(email.body);
        viewHolder.sender.setText(email.sender);

        return convertView;
    }

    public static class ViewHolder{
        TextView subject;
        TextView body;
        TextView sender;

    }
}
