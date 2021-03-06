package com.example.exercise2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahBuku extends AppCompatActivity {
    private DatabaseReference database;

    private Button btOk;
    private EditText etKode;
    private EditText etNamaBuk;
    private EditText etTabuk;
    private EditText etGbuk;

    @Override //inisialisasi dan menset layout untuk kelas
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_buku);
        // set id pada layout
        etNamaBuk = (EditText) findViewById(R.id.nambuk);
        etKode = (EditText) findViewById(R.id.ekob);
        etTabuk = (EditText) findViewById(R.id.Tabuk);
        etGbuk = (EditText) findViewById(R.id.Gbuk);
        // set button layout
        btOk = (Button) findViewById(R.id.buttonOk);

        //inisialisasi dan mengmbil data pada firebase
        database = FirebaseDatabase.getInstance().getReference();
        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //methode untuk kondisi ketika telah mengsubmit data buku
                if (!(etNamaBuk.getText().toString().isEmpty()) || (etTabuk.getText().toString().isEmpty()) || (etGbuk.getText().toString().isEmpty()) || (etKode.getText().toString().isEmpty()))
                {
                    btOk(new Buku(etNamaBuk.getText().toString(), etTabuk.getText().toString(), etGbuk.getText().toString(), etKode.getText().toString()));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data buku telah ditambah", Toast.LENGTH_LONG).show();
                }//kondisi ini dibuat untuk kondisi ketika kita telah menambahkan data buku.
                InputMethodManager imn = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imn.hideSoftInputFromWindow(etKode.getWindowToken(), 0);
            }
        });
    }
    public void btOk(Buku bk) {
        //
        //kondisi dimana kita menginisialisasi dan mengambil data dari si "buku" pada firebase database.
        database.child("Buku").push().setValue(bk).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void bVoid) {
                etNamaBuk.setText(""); //kondisi meng set text.
                etTabuk.setText("");
                etGbuk.setText("");
                etKode.setText("");
            }
        });
    }
    public static Intent getActIntent(Activity activity) {
        //kode pengambilan intent
        return new Intent(activity, TambahBuku.class);
    }
}
