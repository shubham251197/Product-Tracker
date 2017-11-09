package com.example.shubham.minorproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created on 28-09-2017.
 */

public class TrackListAdapter extends RecyclerView.Adapter<TrackListAdapter.TrackingViewHolder> {


    Context mContext;
    ArrayList<TrackingProduct> trackingProducts;

    public TrackListAdapter(Context mContext, ArrayList<TrackingProduct> trackingProducts) {
        this.mContext = mContext;
        this.trackingProducts = trackingProducts;
    }

    @Override
    public TrackingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.tracking_product_list,parent,false);
        return new TrackingViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TrackingViewHolder holder, int position) {

        TrackingProduct p=trackingProducts.get(position);
        holder.price.setText("  PRICE : "+p.price);
        holder.title.setText("  "+p.title);
        Picasso.with(mContext).load(p.image).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return trackingProducts.size();
    }

    public static class TrackingViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title,price;

        public TrackingViewHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.tracking_image);
            title=itemView.findViewById(R.id.tracking_title);
            price=itemView.findViewById(R.id.tracking_price);
        }
    }

}
