package com.andrerichards.andre.to_dolist;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 11/29/2015.
 */
class CustomAdapter extends BaseAdapter {

    private ArrayList<String> toDoItems = new ArrayList();
    private LayoutInflater listInflater;
    private ImageButton pencilButton;
    private Context context;

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

        String listItem = (String) getItem(position);
        TextView rowText = (TextView) customView.findViewById(R.id.rowText);
        pencilButton = (ImageButton) customView.findViewById(R.id.pencilButton);
        rowText.setText(listItem);
        pencilButton.setImageResource(R.drawable.pencil);

        PencilButton btnPencil = new PencilButton();
        btnPencil.pencilButton(pencilButton, parent);
        return customView;
    }

    public ArrayList getArrayList(){
        return toDoItems;
    }
}