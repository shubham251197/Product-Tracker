package com.example.shubham.minorproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created on 24-09-2017.
 */

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.SearchViewHolder> {



    Context mContext;
    ArrayList<Product> mProducts;
    SearchListClickListener mListener;

    public interface SearchListClickListener{
        void onItemClickListener(View v,int position);
    }

    public SearchListAdapter(Context mContext, ArrayList<Product> mProducts, SearchListClickListener mListener) {
        this.mContext = mContext;
        this.mProducts = mProducts;
        this.mListener = mListener;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.search_list_item,parent,false);
            return new SearchViewHolder(v,mListener);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {

        Product p=mProducts.get(position);
        holder.productTitle.setText(p.getTitle());
        holder.productPrice.setText(p.getPrice().getValue()+" "+p.getPrice().getCurrency());
        String url=p.image.imageUrl;

        Picasso.with(mContext).load(url).into(holder.productImage);

    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


    TextView productTitle,productPrice;
    ImageView productImage;
    SearchListClickListener SearchListener;

    public SearchViewHolder(View itemView,SearchListClickListener listener) {
        super(itemView);
        itemView.setOnClickListener(this);
        productImage=(ImageView) itemView.findViewById(R.id.imageView);
        productPrice=(TextView) itemView.findViewById(R.id.price);
        productTitle=(TextView) itemView.findViewById(R.id.name);
        SearchListener=listener;
    }


        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();

            SearchListener.onItemClickListener(view,position);
        }
    }

}
