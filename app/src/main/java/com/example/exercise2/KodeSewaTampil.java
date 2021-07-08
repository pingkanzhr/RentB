package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
  //kelas ini dibuat untuk kita mendapatkan kode random saat kita telah mengsubmit pendaftaran
public class KodeSewaTampil extends AppCompatActivity {
  TextView kdSewa; //deklarasi
  Button btBack;
  @Override // mendefinisikan dan men-set layout si rvView nya
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_kode_sewa_tampil);
//inisialisasi id pada layout
    kdSewa = findViewById(R.id.kdSewa);
    btBack = findViewById(R.id.btBack);
    kdSewa.setText(SewaBukuAct.kodesewa);

    btBack.setOnClickListener(new View.OnClickListener() { //set button pada layout
      @Override
      public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class)); //menjalankan activity.
        finish();
      }
    });
  }
}