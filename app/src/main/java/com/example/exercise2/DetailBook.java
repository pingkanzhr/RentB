package com.example.exercise2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class DetailBook extends AppCompatActivity {
  TextView nama,author,genre,kode;
  String nm,au,ge,kd;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.detail_data_buku);
    nama = findViewById(R.id.judul);
    author = findViewById(R.id.author);
    genre = findViewById(R.id.genr);
    kode = findViewById(R.id.coden);

    Bundle b = getIntent().getExtras();
    nm = b.getString("nm");
    au = b.getString("au");
    ge = b.getString("ge");
    kd = b.getString("kd");

    nama.setText(nm);
    author.setText(au);
    genre.setText(ge);
    kode.setText(kd);
  }
}
