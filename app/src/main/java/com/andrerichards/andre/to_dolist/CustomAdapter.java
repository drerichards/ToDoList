package com.andrerichards.andre.to_dolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Andre on 11/29/2015.
 */
class CustomAdapter extends BaseAdapter {

    private ArrayList<String> toDoItems = new ArrayList();
    private LayoutInflater listInflater;

    public CustomAdapter(Context context){
        listInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return toDoItems.size();

    }

    @Override
    public Object getItem(int position) {
        return toDoItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView = listInflater.inflate(R.layout.custom_row, parent, false);

        String singleListItem = (String) getItem(position);
        TextView rowText = (TextView) customView.findViewById(R.id.rowText);
        ImageView checkIcon = (ImageView) customView.findViewById(R.id.checkIcon);

        rowText.setText(singleListItem);
        checkIcon.setImageResource(R.drawable.check);

        return customView;
    }

    public ArrayList getArrayList(){
        return toDoItems;
    }
}
