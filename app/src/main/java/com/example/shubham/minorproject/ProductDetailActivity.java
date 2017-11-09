package com.example.shubham.minorproject;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.MessagePattern;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductDetailActivity extends AppCompatActivity {



    Product product;
    String ItemID;
    String AccessToken="Bearer v^1.1#i^1#f^0#I^3#p^1#r^0#t^H4sIAAAAAAAAAOVXbWwURRju9Xqt5TMaRCQ1ngt+obs3u3t3e7f2Llw/CCWFnr0DgUbL7O5su/Zu97IzR3s/wKYGJJiQ8INENJAaMGgQKH5BiDEYAxh/EIiogJIgfkRJRBJAYyTB2btruVbCZxES789l3nnnned53ved2QG9ldUzVs5e+ed4V1V5fy/oLXe5+LGgutLz1AR3+VRPGShxcPX3Tu+t6HP/UothOpWRWxHOWCZG3p50ysRy3hhhsrYpWxAbWDZhGmGZqHIiNrdZFjggZ2yLWKqVYrxNDRGGh4IgijzUkBaGoipSqzkYM2lFGM3vV3hNUKRgEICQotB5jLOoycQEmiTCCICXWBBmBSnJSzIfkAXAhYTwYsa7ANnYsEzqwgEmmocr59faJVivDhVijGxCgzDRptisREusqaFxXrLWVxIrWtQhQSDJ4uGjektD3gUwlUVX3wbnveVEVlURxowvWthheFA5NgjmJuAXpFYDiiYhKOlBIKpQHxUpZ1l2GpKr43AshsbqeVcZmcQguWspStVQXkQqKY7m0RBNDV7n79ksTBm6gewI01gXWxSLx5ko7swqnTCN2bhtaVmVJNl4awOLApoEAoqosWFdU4DOo+JGhWhFmUfsVG+ZmuGIhr3zLFKHKGo0UhtQog11ajFb7JhOHESlfuFBDXnq5xvMYpZ0mk5eUZoK4c0Pr52BodWE2IaSJWgowsiJvEQRBmYyhsaMnMzXYrF8enCE6SQkI/t83d3dXLfIWXaHTwCA9y2c25xQO1EaMtTX6fWCv3HtBayRp6IiuhIbMsllKJYeWqsUgNnBRIWAX/KDou7DYUVHWv9lKOHsG94Ro9UhftEfgpoqhpGqhsSgNhodEi0Wqc/BgRSYY9PQ7kIkk4IqYlVaZ9k0sg1NFgO6IIZ0xGrBsM76w7rOKgEtyPI6QgAhRVHDof9To1xvqSdUK4PiVspQc6NS8KNW7KKtxaFNcgmUSlHD9Vb9FUlih+Rtp+f0+g1RdGJgGgRmDM6pbU610j4L0kPNMbXnUd8Sb4Peh3dVUinBAlNDK1xkXJ4uh5eqnI2wlbXpHc61OOd60upCJu0SYlupFLIX8LekxOid6HfoNL8iKzVlUBnb7zZmN3hM3mRtQ3IHWVf0udquwJwPgGBAFALCreW1Pp/XZO4/OLRuKLGzLUyQdhs+QHzDn0PRsvyP73N9CPpcO+mLCvjAo/w08Eile36Fe9xUbBDEGVDnsNFh0q98G3FdKJeBhl1e6WqrGXinveQB1v88mDL0BKt282NL3mOg5vKMh5/4wHheAmFB4iWe5nAxmHZ5toKfXDFp35HwkWV//NU256Vy6fGX538+pWUvA8YPOblcnjJaGWXeM+ceihyr6l6/uva3LZMuXFBmSEcZOPn40W3uvwOHjk6cvqHS/eqpjW97Qz2byRiP/9KuihPpcefJsjHBs6+dPLRz4WM/tt63+Q03Tp6c0Wg/vLxx3ZLNZ7gHv3zv9MDGxl78Az9h+Y7nqpTm3fd6THFXz0ernjkc3c4uf4JHpy8GeM/+uhVPf/P9wRVfn4j9fLBx7/Hjq+bcs3HPng/OLKqbsmP/J1vOMdurXvduOjbQfPpUjfHT2gNb5+w6+dm3zP4DS5e1nn3rwrmO2qbpaz5ejy/W/z4bvMlWt707sKGr/Yvzi05sT323beqamYff75u15JWa+z89uDou181kt+5b++sLm55Uv7IGLvW37C6k7x/NRBdeGg8AAA==";
    RecyclerView slideImageRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent i=getIntent();
        String json=i.getStringExtra("product");
        Gson gson=new Gson();
        product=gson.fromJson(json,Product.class);

//        Retrofit retro=new Retrofit.Builder().baseUrl("https://api.ebay.com/").addConverterFactory(GsonConverterFactory.create()).build();
//        ApiInterface api= retro.create(ApiInterface.class);
//        Call<ProductDetails> call=api.getProductDetail(ItemID,AccessToken);
//
//        call.enqueue(new Callback<ProductDetails>() {
//            @Override
//            public void onResponse(Call<ProductDetails> call, Response<ProductDetails> response) {
//                    if(response.body()!=null){
//                    product=response.body();
//                    setDetails();
//                    }
//            }
//
//            @Override
//            public void onFailure(Call<ProductDetails> call, Throwable t) {
//                Toast.makeText(ProductDetailActivity.this, "CONNECTION FAILURE", Toast.LENGTH_SHORT).show();
//            }
//        });

        setDetails();

    }

    private void setDetails() {


        TextView title=(TextView) findViewById(R.id.product_detail_title);
        TextView price=(TextView) findViewById(R.id.product_detail_price);
        TextView rating=(TextView) findViewById(R.id.rating);
        TextView stock_status=(TextView) findViewById(R.id.stock_status);
        ImageView thumbnail=(ImageView) findViewById(R.id.thumbnail);
        TextView description=(TextView) findViewById(R.id.description);
        TextView seller=(TextView) findViewById(R.id.seller);

        Button webview=(Button) findViewById(R.id.button);
        Button track=(Button) findViewById(R.id.track_button);

        if(product.additionalImages!=null) {
            slideImageRecycler = (RecyclerView) findViewById(R.id.product_detail_image);
            SlideImageAdapter adapter = new SlideImageAdapter(this, product.additionalImages);

            slideImageRecycler.setAdapter(adapter);
            slideImageRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
            slideImageRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
            slideImageRecycler.setItemAnimator(new DefaultItemAnimator());
        }
       // rating.setText(product.getPrimaryProductReviewRating().averageRating);
       // stock_status.setText(product.getEstimatedAvailabilities().estimatedAvailabilityStatus);

       // description.setText(product.getShortDescription());

       // seller.setText(product.getSeller().username+" \n"+
               //         product.getItemLocation().city+", "+product.getItemLocation().stateOrProvince +"\n"+product.getItemLocation().country);
        title.setText(product.getTitle());
        price.setText("PRICE : "+ product.getPrice().getValue()+" "+ product.getPrice().getCurrency());

        Picasso.with(this).load(product.image.imageUrl).into(thumbnail);

        webview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent();
                i.setAction(Intent.ACTION_VIEW);
                Uri uri=Uri.parse(product.itemWebUrl);
                i.setData(uri);
                startActivity(i);
            }
        });

        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AppOpenHelper openHelper=new AppOpenHelper(ProductDetailActivity.this);
                SQLiteDatabase database= openHelper.getWritableDatabase();
                ContentValues cv=new ContentValues();


                cv.put(openHelper.DB_TITLE,product.getTitle());
                cv.put(openHelper.DB_PRICE,product.getPrice().getValue());
                cv.put(openHelper.DB_REFID,product.itemHref);
                cv.put(openHelper.DB_IMAGE,product.image.imageUrl);

                database.insert(openHelper.DB_TABLENAME,null,cv);

                Toast.makeText(ProductDetailActivity.this, "PRODUCT ADDED TO TRACKING LIST", Toast.LENGTH_SHORT).show();

            }
        });

    }


}
