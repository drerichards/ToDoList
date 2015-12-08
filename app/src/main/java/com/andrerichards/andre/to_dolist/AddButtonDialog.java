package com.andrerichards.andre.to_dolist;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

/**
 * Created by Andre on 12/5/2015.
 */
public class AddButtonDialog implements AdapterView.OnItemLongClickListener {

    public void addButtonDialog(ImageButton addButton, final CustomAdapter adapter, final ListView listView, final Context mainContext){
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.addButton:
                        AlertDialog.Builder builder = new AlertDialog.Builder(mainContext);
                        builder.setTitle("Add a New Task");
                        builder.setMessage("What would you like to do?");
                        final EditText inputField = new EditText(mainContext);
                        builder.setView(inputField);
                        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String newItems = inputField.getText().toString();
                                listView.setAdapter(adapter);
                                adapter.getArrayList().add(newItems);
                                adapter.notifyDataSetChanged();
                            }
                        });
                        builder.setNegativeButton("Cancel", null);
                        builder.create().show();
                }
            }
        });
    }


    public boolean listEditDelete(final ListView listView, final CustomAdapter adapter, final Context mainContext) {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                Log.d("flow", "click");
                //create Dialog for edits
                AlertDialog.Builder builder = new AlertDialog.Builder(mainContext);
                builder.setTitle("Edit Task");
                builder.setMessage("Make a Change?");
                final EditText inputEditField = new EditText(mainContext);
                builder.setView(inputEditField);
                //converts index text to string
                String itemToEdit = String.valueOf(parent.getItemAtPosition(position));
                //sets input field to old text
                inputEditField.setText(itemToEdit);
                //moves cursor to end of text
                inputEditField.setSelection(itemToEdit.length());
                builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //intakes edit entry
                        String newEditItem = inputEditField.getText().toString();
                        //recalls the adapter that links to listview in xml
                        listView.setAdapter(adapter);
                        //takes the new edit and sets it to the existing parent position or index of array
                        adapter.getArrayList().set(position, newEditItem);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {//
                        //removes clicked item from its position or index in the array
                        adapter.getArrayList().remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNeutralButton("Cancel", null);
                builder.create().show();
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }
}
