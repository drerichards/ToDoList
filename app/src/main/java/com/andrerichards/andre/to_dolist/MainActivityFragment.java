package com.andrerichards.andre.to_dolist;

import android.app.AlertDialog;
import android.app.ListFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    ArrayList<String> toDoItems = new ArrayList<>();
    ArrayAdapter<String> adapter;
    Button addButton;
    Context context;
    ListView listView;

    public MainActivityFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,
                toDoItems);
        listView = (ListView) container.findViewById(android.R.id.list);
        setListAdapter(adapter);
        addButton = (Button) container.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.addButton:
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setTitle("Add a New Task");
                        builder.setMessage("What would you like to do?");
                        final EditText inputField = new EditText(context);
                        builder.setView(inputField);
                        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String newItemToList = inputField.getText().toString();
                                toDoItems.add(newItemToList);
                            }
                        });
                        builder.setNegativeButton("Cancel", null);
                        builder.create().show();
                }
            }
        });
        return view;
    }


}
