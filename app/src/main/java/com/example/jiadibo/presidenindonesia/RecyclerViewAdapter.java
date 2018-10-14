package com.example.jiadibo.presidenindonesia;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


//adapter, mengatur bagaimana data akan di tampilkan.
class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>{

    private ArrayList<President> arrayList;

    public RecyclerViewAdapter(ArrayList<President> arrayList){
        this.arrayList = arrayList;
    }

    //vieholder, digunakan untuk menyimpan refrensi dari view-view
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView tvName, tvRemaks;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.photoPres);
            tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvRemaks = (TextView)itemView.findViewById(R.id.tv_item_remarks);


        }

        protected void bindItem(final President p){
            Glide.with(itemView.getContext()).load(p.getPhoto()).into(imageView);
            tvName.setText(p.getName());
            tvRemaks.setText(p.getRemarks());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("PRESIDENT_OBJ", p );

                    Intent intent = new Intent(view.getContext(), DetailActivity.class);
                    intent.putExtras(bundle);
                    view.getContext().startActivity(intent);
                }
            });

        }
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //membuat view  utnuk menyimpan dan memasang layout yang akan digunakan  pada recyclerview
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_row_president,parent,false);

        return new RecyclerViewHolder(itemView);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        //memasukkan nilai/value pada view-view yang telah di buat
        final President p = arrayList.get(position);
        holder.bindItem(p);

    }

    @Override
    public int getItemCount() {
        //menghitung ukuran/jumlah data yang akan di tampilkan di recycler view secara keseluruhan
        return arrayList.size();
    }
}
