package com.test.testapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.test.testapplication.R;
import com.test.testapplication.model.Contact;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Contact> contacts;

    public ListAdapter(Context context, ArrayList<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int location) {
        return contacts.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        TextView tv_contact;
        TextView tv_email;
        TextView tv_phone;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView==null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.adapter_list, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.tv_contact = (TextView) convertView.findViewById(R.id.tv_contact);
            viewHolder.tv_email = (TextView) convertView.findViewById(R.id.tv_email);
            viewHolder.tv_phone = (TextView) convertView.findViewById(R.id.tv_phone);

            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contact contact = contacts.get(position);

        if(contact != null) {
            viewHolder.tv_contact.setText(contact.getName());
            viewHolder.tv_email.setText(contact.getEmail());
            viewHolder.tv_phone.setText(contact.getPhone());
        }

        return convertView;
    }

}
