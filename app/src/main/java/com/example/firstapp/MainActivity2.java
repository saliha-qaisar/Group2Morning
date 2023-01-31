package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    ListView listView;
    mydbHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        db=new mydbHandler(this);
        listView=findViewById(R.id.list_view);
        List<Model> students = db.getAllData();
        List<Model> l1;
        l1 = db.getAllData();
        for (Model empty:l1){
            Log.d("SelectionModeinAnother", ""+empty );
        }


        ArrayAdapter arrayAdapter = new ArrayAdapter<Model>(MainActivity2.this, android.R.layout.simple_list_item_1,students);
        listView.setAdapter(arrayAdapter);
    }
}