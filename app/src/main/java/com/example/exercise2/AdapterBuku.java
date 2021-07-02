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
    public ArrayList<Buku> arrBuku;

    public AdapterBuku(ArrayList<Buku> arrBuku) {
        this.arrBuku = arrBuku;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_buku,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        vh.judul.setText(DaftarB.bukuArrayList.get(position).getNamabuku());
        vh.judul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("nm",DaftarB.bukuArrayList.get(position).getNamabuku());
                b.putString("au",DaftarB.bukuArrayList.get(position).getNamaauthor());
                b.putString("ge",DaftarB.bukuArrayList.get(position).getGenre());
                b.putString("kd",DaftarB.bukuArrayList.get(position).getEkode());
                Intent i = new Intent(v.getContext(),DetailBook.class);
                i.putExtras(b);
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrBuku.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judul;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.tv_namabuku);
        }
    }
}