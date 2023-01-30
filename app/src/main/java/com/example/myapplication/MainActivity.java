package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText rakat = findViewById(R.id.Rakat);
        RadioButton jamat = findViewById(R.id.jamat);
        RadioButton prayed = findViewById(R.id.prayed);
        RadioButton isha = findViewById(R.id.isha);
        RadioButton fajar = findViewById(R.id.fajar );
        RadioButton zuhar = findViewById(R.id.zuhar );
        RadioButton magrib = findViewById(R.id.magrib );
        RadioButton asar = findViewById(R.id.asar );
        RadioGroup radioGroup = findViewById(R.id.radioGroup);

//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//
//            }
//        });

        MydbHandler db = new MydbHandler(this);
        Model s1 = new Model("saliha","13","para 13", "para 12","para 2");
        db.insertStudent(s1);

    }
}