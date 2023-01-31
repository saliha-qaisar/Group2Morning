package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    mydbHandler db;


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
        Button insert=findViewById(R.id.submit);
        Button show=findViewById(R.id.show);
        Button commit=findViewById(R.id.commit);



        db = new mydbHandler(this);
       /* Model s1 = new Model("Ghzala","12","para 13", "para 12","zuhar");
         db.insertNamaz(s1);*/
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        List<Model> l1;
        l1 = db.getAllData();
        for (Model empty:l1){
            Log.d("SelectionMode", ""+empty );
        }


        insert.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Model m1=new Model();
                 m1.setDate(date);
                 m1.setPrayed(new Boolean(prayed.isChecked()).toString());
                 m1.setRakat(rakat.getText().toString());
                 boolean jmt=jamat.isChecked();
                 m1.setJamat(new Boolean(jmt).toString());
                int radioId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedNamaz;
                selectedNamaz = findViewById(radioId);
                m1.setPrayer(selectedNamaz.getText().toString());

                db.insertNamaz(m1);

                prayed.setChecked(false);
                jamat.setChecked(false);
                rakat.setText("");
                radioGroup.clearCheck();
             }
         });

         show.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent;
                 intent = new Intent(MainActivity.this, MainActivity2.class);
                 startActivity(intent);

             }
         });
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("https://github.com/saliha-qaisar/Group2Morning");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);

            }
        });

//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//
//            }
//        });


//

    }
}