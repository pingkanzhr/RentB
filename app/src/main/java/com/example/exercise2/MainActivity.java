package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //mendefinisikan dan men-set layout si rvView nya
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//set button pada layout
        Button informasi = findViewById(R.id.btn_info_buku);
        Button sewa = findViewById(R.id.btn_sewa);

        informasi.setOnClickListener(new View.OnClickListener() { //kodisi saat mengklik btn actvity
            @Override
            public void onClick(View v) {
                startActivity (new Intent(getApplicationContext(), DaftarB.class));
            }
        });

        sewa.setOnClickListener(new View.OnClickListener() { //kodisi saat mengklik btn actvity
            @Override
            public void onClick(View v) {
                startActivity(SewaBukuAct.getActIntent(MainActivity.this));
            }
        });
    }

}