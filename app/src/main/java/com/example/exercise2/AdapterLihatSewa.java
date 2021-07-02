package com.example.exercise2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterLihatSewa extends RecyclerView.Adapter<AdapterLihatSewa.ViewHolder> {

    private ArrayList<Buku> daftardata;
    private Context context;
    public AdapterLihatSewa(ArrayList<Buku> data, Context ctx){
        daftardata = data;
        context = ctx;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitleB;

        public ViewHolder(View v) {
            super(v);
            tvTitleB = (TextView) v.findViewById(R.id.tv_namasewa);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sewa, parent, false);
        ViewHolder vw = new ViewHolder(v);
        return vw;
    }

    @Override
    public void onBindViewHolder(AdapterLihatSewa.ViewHolder holder, int position) {
        final String name = daftardata.get(position).getNamabuku();
        holder.tvTitleB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
        holder.tvTitleB.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
        holder.tvTitleB.setText(name);
    }

    @Override
    public int getItemCount() {
        return daftardata.size();
    }
}
