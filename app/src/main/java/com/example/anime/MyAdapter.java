package com.example.anime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {

    Context context ;
    String s1[];String s2[];
    int images[];

    public MyAdapter(Context context, String[] s1, String[] s2, int[] images) {
        this.context = context;
        this.s1 = s1;
        this.s2 = s2;
        this.images = images;
    }

    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
     View view=   inflater.inflate(R.layout.row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  MyAdapter.MyViewHolder holder, int position) {
holder.t1.setText(s1[position]);
holder.t2.setText(s2[position]);
holder.imageView.setImageResource(images[position]);


    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView t1;
        TextView t2;
        ImageView imageView;
        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
            imageView  = imageView.findViewById(R.id.imageView);
        }
    }
}
