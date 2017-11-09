package com.example.shubham.minorproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
/**
 * Created on 18-09-2017.
 */

public interface ApiInterface {

    @GET("buy/browse/v1/item_summary/search")

        Call<SearchResponse> getSearchList(@Header("Authorization") String token,@Query("q") String q);

    @GET("buy/browse/v1/item/{item_id}")
        Call<ProductDetails> getProductDetail(@Path("item_id") String id,@Header("Authorization") String token);
}
