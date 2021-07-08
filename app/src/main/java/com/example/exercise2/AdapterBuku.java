package com.example.exercise2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterBuku extends RecyclerView.Adapter{
    public ArrayList<Buku> arrBuku; // deklarasi array

    // konstruktor
    public AdapterBuku(ArrayList<Buku> arrBuku) {
        this.arrBuku = arrBuku;
    }

    @NonNull
    @Override // set layout atau untuk mengambil layout dan menampilkan layout
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_buku,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override //menghubungkan data dengan ViewHolder
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        vh.judul.setText(DaftarB.bukuArrayList.get(position).getNamabuku()); // code ini dibuat untuk mengambil array kelas si daftarb
        vh.judul.setOnClickListener(new View.OnClickListener() { // untuk memanggil atau menerjemahkan button
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle(); // untuk mengirim data
                b.putString("nm",DaftarB.bukuArrayList.get(position).getNamabuku()); // mengambil data string dari arraylist
                b.putString("au",DaftarB.bukuArrayList.get(position).getNamaauthor());
                b.putString("ge",DaftarB.bukuArrayList.get(position).getGenre());
                b.putString("kd",DaftarB.bukuArrayList.get(position).getEkode());
                Intent i = new Intent(v.getContext(),DetailBook.class); //Intent ini dapat membawa dan mengirimkan data ke activity yang lain (ngirim ke detail book)
                i.putExtras(b); //membawa data
                v.getContext().startActivity(i); // menjalankan perintah
            }
        });
    }

    @Override
    public int getItemCount() { //mengembalikan jumlah data yang ingin ditampilkan pada RecyclerView
        return arrBuku.size();
    }
    //class ini berfungsi sebagai pembuat view pada class ini dibuat variabel yang menghubungkan id pada layout
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judul; //deklarasi
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.tv_namabuku);
        }
    }
}