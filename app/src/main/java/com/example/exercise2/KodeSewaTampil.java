package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class KodeSewaTampil extends AppCompatActivity {
  TextView kdSewa;
  Button btBack;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_kode_sewa_tampil);

    kdSewa = findViewById(R.id.kdSewa);
    btBack = findViewById(R.id.btBack);
    kdSewa.setText(SewaBukuAct.kodesewa);

    btBack.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
      }
    });
  }
}