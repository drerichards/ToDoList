package com.andrerichards.andre.to_dolist;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton addButton;
    protected ArrayList<String> toDoItems = new ArrayList<>();
    protected ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        adapter = new CustomAdapter(this, toDoItems);
        final ListView listView = (ListView) findViewById(android.R.id.list);//call to xml


        addButton = (ImageButton) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.addButton:
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Add a New Task");
                        builder.setMessage("What would you like to do?");
                        final EditText inputField = new EditText(getBaseContext());
                        builder.setView(inputField);
                        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String newItems = inputField.getText().toString();
                                listView.setAdapter(adapter);
                                toDoItems.add(newItems);
                                adapter.notifyDataSetChanged();
                            }
                        });
                        builder.setNegativeButton("Cancel", null);
                        builder.create().show();
                }
            }
        });
        listView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view,
                                                   final int position, long id) {
                        //create Dialog for edits
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Edit Task");
                        builder.setMessage("Make a Change?");
                        final EditText inputEditField = new EditText(getBaseContext());
                        builder.setView(inputEditField);
                        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //intakes edit entry
                                String newEditItem = inputEditField.getText().toString();
                                //recalls the adapter that links to listview in xml
                                listView.setAdapter(adapter);
                                //takes the new edit and sets it to the existing parent position or index of array
                                toDoItems.set(position, newEditItem);
                                adapter.notifyDataSetChanged();
                            }
                        });
                        builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {//
                                //removes clicked item from its position or index in the array
                                toDoItems.remove(position);
                                adapter.notifyDataSetChanged();
                            }
                        });
                        builder.setNeutralButton("Cancel", null);
                        builder.create().show();
                        return false;
                    }
                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
