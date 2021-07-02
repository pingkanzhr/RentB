package com.example.exercise2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.cert.PolicyNode;
import java.util.ArrayList;

public class DaftarB extends AppCompatActivity {
    public static final String TAG = "TAG";
    private DatabaseReference database;
    RecyclerView rvView;
    AdapterBuku adapter;
    public static ArrayList<Buku> bukuArrayList = new ArrayList<>();
    String namabuku,author,genre,kodebuku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_daftar_bu);
        rvView = findViewById(R.id.dafbuku);
        rvView.setLayoutManager(new LinearLayoutManager(this));

        database = FirebaseDatabase.getInstance().getReference();
        database.child("Buku")
                .orderByChild("namabuku")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        Log.i(TAG, "DATA DITEMUKAN : " + snapshot.getChildrenCount());
                        for (DataSnapshot ds : snapshot.getChildren()) {
                            Buku buku = ds.getValue(Buku.class);
                            buku.setKode(ds.getKey());
                            bukuArrayList.add(buku);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        System.out.println(error.getDetails() + "" + error.getMessage());
                    }
                });
                AdapterBuku ab = new AdapterBuku(bukuArrayList);
                rvView.setAdapter(ab);
    }

}
