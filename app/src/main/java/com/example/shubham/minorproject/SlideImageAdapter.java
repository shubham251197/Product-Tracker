package com.example.shubham.minorproject;

import android.content.ContentValues;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by shubham on 28-09-2017.
 */

public class SlideImageAdapter extends RecyclerView.Adapter<SlideImageAdapter.slideImageViewHolder> {



    Context mContext;
    ArrayList<Product.Image> images;

    public SlideImageAdapter(Context mContext, ArrayList<Product.Image> images) {
        this.mContext = mContext;
        this.images = images;
    }

    @Override
    public slideImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.slide_image,parent,false);
            return new slideImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(slideImageViewHolder holder, int position) {

        Picasso.with(mContext).load(images.get(position).imageUrl).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public static class slideImageViewHolder extends RecyclerView.ViewHolder{


        ImageView imageView;

        public slideImageViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.slide_image);

        }
    }
}
