package com.example.shubham.minorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchLinkActivity extends AppCompatActivity {


    ArrayList<Product> result;
    String keyword;
    EditText ProductLink;
    Button Submit;
    Button ToSearchActivity;
    final String accessToken="Bearer v^1.1#i^1#r^0#I^3#f^0#p^1#t^H4sIAAAAAAAAAOVXW2wUVRjudNvVghUjKAhtXIb6QpmZMzs7exnpxoVyWYS2dEvBFtzMzpyhA7Mzy5yztBsurk0kYkiK0mCMF9aYGGrQgMoDaAIPGh9I5PKiiZiAJEqEGGMkGMXgmdmlbCvhWoTEfdmc//znP//3/d9/zhyQ99bM3LJwy8Va6oHKQh7kKymKHw9qvNWND3sqp1ZXgDIHqpBvyFf1e87ORnLayEjtEGUsE0FfX9owkeQam+isbUqWjHQkmXIaIgkrUiK2ZLHkZ4GUsS1sKZZB++LNTbQshAVe03gxoPj9ClCJ1bwSs8NqogUl6A9FBAVEQuGwKohkHqEsjJsIyyZuov2ADzEgwvgjHSAsiQEJBNlwJNxF+zqhjXTLJC4soKNuupK71i7L9fqpyghBG5MgdDQem59ojcWb57V0zObKYkVLPCSwjLNo5GiupUJfp2xk4fW3Qa63lMgqCkSI5qLFHUYGlWJXkrmN9F2qhWDIn0qFRUVWRE0Oy2NC5XzLTsv4+nk4Fl1lNNdVgibWce5GjBI2UmuggkujFhIi3uxz/pZmZUPXdGg30fPmxJ6LtbXRUdSTTfXIacS02ZaaVXAH09bezEBRDQExJahMRFNTQONhaaNitBLNo3aaa5mq7pCGfC0WngNJ1nA0N4EybohTq9lqxzTsZFTmx4NhDkGXU9RiFbO4x3TqCtOECJ87vHEFhldjbOupLIbDEUZPuBSRtspkdJUePelqsSSfPtRE92CckTiut7eX7RVYy17N+QHguRVLFieUHpgmCulLO71e9NdvvIDRXSgKJCuRLuFchuTSR7RKEjBX01G/GAgFQIn3kWlFR1v/ZSjDzI3siLHqEA0oIX8AgADQlCCfSo1Fh0RLIuWcPGBKzjFp2V4LccaQFcgoRGfZNLR1VRJEzS+ENciowYjGBCKaxqRENcjwGoQAwlRKiYT/T41ys1JPKFYGtlmGruTGRPBjJnbBVttkG+cS0DCI4WZVf02QyAF51+E5vX5LEJ0YiASRMzrraJtVrDRnyeRQc0xJN+s7wq2T+/C+KioBWESqq8WLjHXhsmi9wtoQWVmb3OFsq3Oud1hroUm6BNuWYUC7k78jJsbuRL9Hp/k1USmGTmhM3m/IbvGYvE1ty/geoq7qp7qvgZwXQTAYEv2B4B1hm+vWtSP3Hxxat1TYhRbCUL0LHyDcyOdQtML98f3UftBP7SMvKsCBp/gZYLrXs6zK89BUpGPI6rLGIn21Sb7ybciuhbmMrNuVXqq7bu9QsuwBVlgFpgw/wWo8/Piy9xiouzpTzU+YXMuHQMQfAWExAIJdYMbV2Sr+8apJh8yTn7w75IHeF6Z0x+FAFP0Cz4PaYSeKqq4gyqhoPnDqyDi+0Xv4+OATmy+/zT36ysezNjyykbG55+u20hcn7t11rn7nslXM9zNeXb6zcPzZY5M+b+xc+lXNF4vEDZ5MQ1fjmfMHE/aL753Y+FHy9y+T2zYfP/CGufLchWNPT1aMuuWLBu1fh/LLjNf0P1jvyh2vb3hywe6Bb15edTrfcjlZKMgfFFbUrjsz1DWun/p02o/nFhhnja1/7tnEqcZnMyMDg8GJ9X+179o103hfmPr3ugcb9v389cCE0/HYqfDJPZvOhl76bTvVv7tv46X6bx9786eaWecPUvPeeWv7iR0Nxy4kzSPrp3irAoNH6w+BZ4YKjRcOH/2u/ZLdveaHzcyHp6etONAp7F8+vVi+fwAwMWudGg8AAA==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_link);


        ProductLink=(EditText) findViewById(R.id.link);
        Submit=(Button) findViewById(R.id.submit);
        ToSearchActivity=(Button) findViewById(R.id.searchKeyword);



        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


// http://www.sandbox.ebay.com/itm/Eachine-Racer-180-Tilt-Rotor-FPV-Drone-F3-350mW-5-8G-40CH-VTX-w-I6-RTF-20-off-/110198777511?var=&hash=item19a85be6a7:i:110198777511

                String link[]=ProductLink.getText().toString().split("/");
                keyword=link[4];
                Retrofit retro=new Retrofit.Builder().baseUrl("https://api.ebay.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                ApiInterface apiInterface= retro.create(ApiInterface.class);
                Call<SearchResponse> call=apiInterface.getSearchList(accessToken,keyword);
                call.enqueue(new Callback<SearchResponse>() {
                    @Override
                    public void onResponse(Call<SearchResponse> call, retrofit2.Response<SearchResponse> response) {

                        if(response!=null && response.body()!=null ){

                                result=response.body().getItemSummaries();
                                searchListForProduct();
                        }
                        else
                            Toast.makeText(SearchLinkActivity.this,"Error : "+response.code()+" "+response.message(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<SearchResponse> call, Throwable t) {

                        Toast.makeText(SearchLinkActivity.this, "Connection Error", Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });


        ToSearchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SearchLinkActivity.this,SearchActivity.class);
                startActivity(i);
                finish();
            }
        });



    }

    private void searchListForProduct() {

        boolean found=false;
        int position=0;
        for(int i=0;i<result.size();i++){

            String ResultLink[]=result.get(i).itemWebUrl.split("/");
            if(ResultLink[4].equals(keyword)){
                Log.i("TAG","FOUND");
                found=true;
                position=i;
                break;
            }

        }

        if(found==false)
            Toast.makeText(this, "PRODUCT NOT FOUND. ERROR OCCURED", Toast.LENGTH_SHORT).show();
        else
        {
            Toast.makeText(this, "PRODUCT FOUND", Toast.LENGTH_SHORT).show();
            Product p=result.get(position);
            Gson gson=new Gson();
            String json=gson.toJson(p);

            Intent i=new Intent(SearchLinkActivity.this,ProductDetailActivity.class);
            i.putExtra("product",json);
            startActivity(i);
        }
    }
}
