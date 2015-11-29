package com.andrerichards.andre.to_dolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Andre on 11/29/2015.
 */
class CustomAdapter extends ArrayAdapter {


    public CustomAdapter(Context context, ArrayList<String> toDoItems) {
        super(context, R.layout.custom_row, toDoItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater listInflater = LayoutInflater.from(getContext());
        View customView = listInflater.inflate(R.layout.custom_row, parent, false);

        String singleListItem = (String) getItem(position);
        TextView rowText = (TextView) customView.findViewById(R.id.rowText);
        ImageView checkIcon = (ImageView) customView.findViewById(R.id.checkIcon);

        rowText.setText(singleListItem);
        checkIcon.setImageResource(R.drawable.check);

        return customView;
    }
}
