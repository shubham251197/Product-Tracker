package com.example.shubham.minorproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity {



    ArrayList<Product> products;
    SearchListAdapter productSearchAdapter;
    RecyclerView RecyclerSearchView;



  //  Authorization:Bearer v^1.1#i^1#r^0#p^1#f^0#I^3#t^H4sIAAAAAAAAAOVXbWwURRju9eNIUwvxI3xJ8LKihDa7N3t3u3u3cIdXykel0JYrJ5QA7sdsu3K3e+7M2l5EvJQAGiVCDCYGjQWkkUCMQdQYQKPxh4QQSRoNaBBFSJSgkWAgEiLO7l3LtRKoUCKJdz82M/POu8/zzPPO7ICct7Jm/bz1l6o9o0p7ciBX6vGwVaDSW1E7uqx0YkUJKArw9OSm5Mq7y36egaR0KiMugihjGgj6utIpA4luZ5SyLUM0JaQj0ZDSEIlYERPxBY1igAFixjKxqZgpytdQH6VCAaAGuVBI4EBEkJUw6TX6c7aaUQqCCJADICJzKidIYY6MI2TDBgNhycBRKgBYgQYRmhVaWUFkgyLHM4Dj2ihfElpINw0SwgAq5sIV3blWEdYbQ5UQghYmSahYQ3xOoineUD97YesMf1GuWEGHBJawjQa3Zpkq9CWllA1v/BrkRosJW1EgQpQ/ln/D4KRivB/MLcB3pZYjQgTyPK/wCqcpgjAiUs4xrbSEb4zD6dFVWnNDRWhgHWdvpihRQ34KKrjQWkhSNNT7nEeLLaV0TYdWlJpdF18ab26mYqjDljukNKKbLVO1FdxKJ+qW0GFOJbYKKSFa4YMaFwgECi/KZyvIPORNs0xD1R3RkG+hiesgQQ2HagOKtCFBTUaTFdewg6g4LtKvYYDE+ftX0cYdhrOuME2E8LnNm6/AwGyMLV22MRzIMHTAlShKSZmMrlJDB10vFuzThaJUB8YZ0e/v7OxkOoOMabX7AwCw/iULGhNKB0xLFIl1aj0fr998Aq27VBRIZiJdxNkMwdJFvEoAGO1ULBAOBkGooPtgWLGhvf/oKOLsH1wRI1UhrKxCGIaSyisCz8ojUiGxgkn9Dg4oS1k6LVmrIM6kJAXSCvGZnYaWropBTgsEwxqkVT6i0aGIptFk0+NpVoMQQCjLSiT8fyqU4Vo9oZgZ2GymdCU7IoYfMbMHLbVZsnC2zs6SdgKmUuQxXO9flypyqN5Bkk6t3wJRJwciSaSMzjgOZxQz7TclsrU5XStd1L7hBPllO8u02xBhgkIlp8uwJ+nEIgwpFHX4U/JleLtLopMD+65yHaGb562r+ZOWcckz6BmFsSAybYt8ZDBNzsHTaq6CBiljbJmpFLSS7G0pMXJHzn903FyXlZLSiYwr7zZm/3Ifvw738m7PleH4W8J3F3OWAxzPh0NB/rbWdZa7rq3ZO7qf3gK9eSbCUL0DX0j+wfe1WIn7Y7s9B0G352Ny5QMCoNlaMM1btri87B4KkS2VQZKhymYXo0sag/R2g1xHLMisgtmMpFulXs+yB8/OvFJ0U+xZDsYP3BUry9iqoosjmHRtpIIdM66aFUCEFcg/yPFt4OFro+Xs2PIH/vQ+PVeb+NJfaML4HTt73vhw+o/e0aB6IMjjqSghFi559MKxRb99c27f8blfn77yyrMzj8Ym3P/ZL+qMaZev7p58ENczL5c8tG2esvzTyZe+Wj/to5odz+3trK09dfL1zm0zI5vHHoCjfnr+8d/5yvsOH3tr0plPNp2cPvX0q5c3/xCz1vTu2bT0g/fmv3u0rnHZpGU1+MSXT06ZsmHPvajP3nFxTXnynX2VL64df6Fl7+HvT0/+ruVNqqmyb/XW7WVnpPfXVfXl9nt6P1+8//zWXed22d7VO+u/faEFv20cHxd47YkTOTj3VPWKXHLM7EuNJW2GukU/cGg7vjp/Xd0RcOZ878nzG+GRQ8lH1j5GX8Thmj9WXEhO2LLx16kHJu7eMOqLnt6tx5rFg8fPtvVVV+WX8W9XXwUJww8AAA==


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        RecyclerSearchView= (RecyclerView) findViewById(R.id.search_list);

        products=new ArrayList<>();

        productSearchAdapter=new SearchListAdapter(this, products, new SearchListAdapter.SearchListClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                Gson gson=new Gson();
                String json=gson.toJson(products.get(position));
                            Intent i=new Intent(SearchActivity.this,ProductDetailActivity.class);
                            i.putExtra("product",json);
                            startActivity(i);
                String AccessToken="Bearer v^1.1#i^1#r^0#I^3#f^0#p^1#t^H4sIAAAAAAAAAOVXW2wUVRjudNvVghUjKAhtXIb6QpmZMzs7exnpxoVyWYS2dEvBFtzMzpyhA7Mzy5yztBsurk0kYkiK0mCMF9aYGGrQgMoDaAIPGh9I5PKiiZiAJEqEGGMkGMXgmdmlbCvhWoTEfdmc//znP//3/d9/zhyQ99bM3LJwy8Va6oHKQh7kKymKHw9qvNWND3sqp1ZXgDIHqpBvyFf1e87ORnLayEjtEGUsE0FfX9owkeQam+isbUqWjHQkmXIaIgkrUiK2ZLHkZ4GUsS1sKZZB++LNTbQshAVe03gxoPj9ClCJ1bwSs8NqogUl6A9FBAVEQuGwKohkHqEsjJsIyyZuov2ADzEgwvgjHSAsiQEJBNlwJNxF+zqhjXTLJC4soKNuupK71i7L9fqpyghBG5MgdDQem59ojcWb57V0zObKYkVLPCSwjLNo5GiupUJfp2xk4fW3Qa63lMgqCkSI5qLFHUYGlWJXkrmN9F2qhWDIn0qFRUVWRE0Oy2NC5XzLTsv4+nk4Fl1lNNdVgibWce5GjBI2UmuggkujFhIi3uxz/pZmZUPXdGg30fPmxJ6LtbXRUdSTTfXIacS02ZaaVXAH09bezEBRDQExJahMRFNTQONhaaNitBLNo3aaa5mq7pCGfC0WngNJ1nA0N4EybohTq9lqxzTsZFTmx4NhDkGXU9RiFbO4x3TqCtOECJ87vHEFhldjbOupLIbDEUZPuBSRtspkdJUePelqsSSfPtRE92CckTiut7eX7RVYy17N+QHguRVLFieUHpgmCulLO71e9NdvvIDRXSgKJCuRLuFchuTSR7RKEjBX01G/GAgFQIn3kWlFR1v/ZSjDzI3siLHqEA0oIX8AgADQlCCfSo1Fh0RLIuWcPGBKzjFp2V4LccaQFcgoRGfZNLR1VRJEzS+ENciowYjGBCKaxqRENcjwGoQAwlRKiYT/T41ys1JPKFYGtlmGruTGRPBjJnbBVttkG+cS0DCI4WZVf02QyAF51+E5vX5LEJ0YiASRMzrraJtVrDRnyeRQc0xJN+s7wq2T+/C+KioBWESqq8WLjHXhsmi9wtoQWVmb3OFsq3Oud1hroUm6BNuWYUC7k78jJsbuRL9Hp/k1USmGTmhM3m/IbvGYvE1ty/geoq7qp7qvgZwXQTAYEv2B4B1hm+vWtSP3Hxxat1TYhRbCUL0LHyDcyOdQtML98f3UftBP7SMvKsCBp/gZYLrXs6zK89BUpGPI6rLGIn21Sb7ybciuhbmMrNuVXqq7bu9QsuwBVlgFpgw/wWo8/Piy9xiouzpTzU+YXMuHQMQfAWExAIJdYMbV2Sr+8apJh8yTn7w75IHeF6Z0x+FAFP0Cz4PaYSeKqq4gyqhoPnDqyDi+0Xv4+OATmy+/zT36ysezNjyykbG55+u20hcn7t11rn7nslXM9zNeXb6zcPzZY5M+b+xc+lXNF4vEDZ5MQ1fjmfMHE/aL753Y+FHy9y+T2zYfP/CGufLchWNPT1aMuuWLBu1fh/LLjNf0P1jvyh2vb3hywe6Bb15edTrfcjlZKMgfFFbUrjsz1DWun/p02o/nFhhnja1/7tnEqcZnMyMDg8GJ9X+179o103hfmPr3ugcb9v389cCE0/HYqfDJPZvOhl76bTvVv7tv46X6bx9786eaWecPUvPeeWv7iR0Nxy4kzSPrp3irAoNH6w+BZ4YKjRcOH/2u/ZLdveaHzcyHp6etONAp7F8+vVi+fwAwMWudGg8AAA==";


//                Retrofit retro=new Retrofit.Builder().baseUrl("https://api.ebay.com/").addConverterFactory(GsonConverterFactory.create()).build();
//                ApiInterface api= retro.create(ApiInterface.class);
//                Call<ProductDetails> call=api.getProductDetail(products.get(position).itemId,AccessToken);
//
//                call.enqueue(new Callback<ProductDetails>() {
//                    @Override
//                    public void onResponse(Call<ProductDetails> call, Response<ProductDetails> response) {
//                        if(response.body()!=null){
//                           ProductDetails productDetails=response.body();
//                            Gson gson=new Gson();
//                            String json=gson.toJson(productDetails);
//                            Intent i=new Intent(SearchActivity.this,ProductDetailActivity.class);
//                            i.putExtra("product",json);
//                            startActivity(i);
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ProductDetails> call, Throwable t) {
//                        Toast.makeText(SearchActivity.this, "CONNECTION FAILURE", Toast.LENGTH_SHORT).show();
//                    }
//                });




            }
        });

        RecyclerSearchView.setAdapter(productSearchAdapter);
        RecyclerSearchView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        RecyclerSearchView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerSearchView.setItemAnimator(new DefaultItemAnimator());


        AlertDialog.Builder  builder=new AlertDialog.Builder(this);
        builder.setTitle("Search");
        final View v= getLayoutInflater().inflate(R.layout.search_dialogue,null);
        builder.setView(v);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText query=(EditText) v.findViewById(R.id.search_dialog_text);
                searchProduct(query.getText().toString());
                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog=builder.create();
        dialog.show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.refresh,menu);
    return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.refresh){

            AlertDialog.Builder  builder=new AlertDialog.Builder(this);
            builder.setTitle("Search");
            final View v= getLayoutInflater().inflate(R.layout.search_dialogue,null);
            builder.setView(v);
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    EditText query=(EditText) v.findViewById(R.id.search_dialog_text);
                    searchProduct(query.getText().toString());
                    dialogInterface.dismiss();
                }
            });

            AlertDialog dialog=builder.create();
            dialog.show();
        }

        return true;
    }





    public void searchProduct(String keyword){

        final String accessToken="Bearer v^1.1#i^1#f^0#p^1#r^0#I^3#t^H4sIAAAAAAAAAOVXa2wUVRTu9qUFVyQxLcFitgMmBp3ZO7O73Z0Ju2ShPNZAu7DbBkqgzuMOHTo7s8y9Q1kxodSkqYomgAn4qBYVIo0xFSLEV0RTNVEUQwgPCegfldj4h2g0QY13ZpeyrYRnERL3z+aee+653/edc+6dC7oqq2b2LOz53eu5o7S/C3SVejzsRFBVWfHQ3WWlUytKQJGDp79rRld5d9nZWUjM6FlhKURZ00DQtz6jG0hwjVHKtgzBFJGGBEPMQCRgWUjFFy8SOAYIWcvEpmzqlC/REKXYsCwBwElAqQ8qfLieWI0LMdNmlAryLB+GYQVGIlKIjzjzCNkwYSAsGjhKcYCN0CBAs8E04IVAUAixDMcHWylfC7SQZhrEhQFUzIUruGutIqyXhyoiBC1MglCxRHx+qimeaJjXmJ7lL4oVK+iQwiK20ejRXFOBvhZRt+Hlt0Gut5CyZRkiRPlj+R1GBxXiF8BcB3xX6ojMiawII7IaDnFqiBsXKeebVkbEl8fhWDSFVl1XARpYw7krKUrUkNZAGRdGjSREosHn/C2xRV1TNWhFqXlz4svjySQVQ+221C5mEJ20TMWWcZpOLm2gYUgJg5AUUGheVSSgsrCwUT5aQeYxO801DUVzREO+RhPPgQQ1HKsNV6QNcWoymqy4ih1ERX4se0HDCNfqJDWfRRu3G05eYYYI4XOHV87AyGqMLU2yMRyJMHbClShKidmsplBjJ91aLJTPehSl2jHOCn5/Z2cn0xlgTGu1nwOA9S9bvCglt8OMSBFfp9fz/tqVF9CaS0WGZCXSBJzLEizrSa0SAMZqKsaFguEgKOg+GlZsrPVfhiLO/tEdMV4dEuYBx7MBUQqGeDks8uPRIbFCkfodHFASc3RGtDogzuqiDGmZ1JmdgZamCIGQygUiKqSVel6lg7yq0lJIqadZFUIAoSTJfOT/1ChXW+op2czCpKlrcm5cCn7cij1gKUnRwrkU1HViuNqqvyRJ5JC86fScXr8mik4MRIKIWY1xapuRzYzfFMmh5pjaXNQ3xFsj9+FtlVRCMM9UU/IXGePSZdA6mbEgMm2L3OFMk3Oup80OaJAuwZap69BqYW9IifE70W/RaX5JVrKuERnbbjdm13hMXmdti/gWsi7v9qy4BHM2xLGALONvrFrnunlN5/6DQ+uaErvQRBgqN+EDxD/6ORQrcX9st+cd0O15m7yogB88wE4HdZVlzeVld01FGoaMJqoM0lYb5CvfgkwHzGVFzSqt9KyoHdzTVvQA618Jpow8warK2IlF7zFQe3Gmgp1U42UjIMAGAR8IhthWMP3ibDlbXX7vqrXUX9lHhw+fuG/Wrp9+SfRHPh3uAN4RJ4+nooRURsnB2TNPPzlNOKdv3rf98zN/D256echY8Nq5V3u+7kjUnO9dsPBgg7luT9OSlb163cnv3uqvfH6gx/vNi5P6Kj/5YFJuS+2Sj4eHpv4w+/hHbQNDBxYczRxZtWqzv6Jm55stcrzu/g2Pt/765bQZ506w3pJpzxzb+P3JPw7v39Gc7Htpzr7Z3m+XVQeSg+/+mZq+aebPy6v6Fn91qr/xkZ0lzdvYLU//+PCJKVurthvHmia8t2lXNP3sPQ9S+zdWf2jvPnPqi0Pemlcmv+5f23d8wpHHmKNvHI/3lO0dWFN659LgodoZA8179WFt2VMvnD57YF3dE2ekDdWTe5O/dQztnrhx8LO15ydvK217v3frDv1g1XP59P0D2ddmuxoPAAA=";
        final String contentType="application/json";
        Retrofit retro=new Retrofit.Builder().baseUrl("https://api.ebay.com/")
                            .addConverterFactory(GsonConverterFactory.create())
//                            .client(new OkHttpClient.Builder().addInterceptor(new Interceptor() {
//                                @Override
//                                public Response intercept(Chain chain) throws IOException {
//                                    Request original=chain.request();
//                                    Request newRequest;
//                                    // adding header
//
//                                    newRequest= original.newBuilder()
//                                                                    .addHeader("Authorization:",accessToken)
//                                                                    .addHeader("Content-Type:",contentType)
//                                                                    .build();
//
//
//                                    return chain.proceed(newRequest);
//
//                                }
//                            }).build())
                .build();


        ApiInterface apiInterface= retro.create(ApiInterface.class);
        Call<SearchResponse> call=apiInterface.getSearchList(accessToken,keyword);
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, retrofit2.Response<SearchResponse> response) {

                if(response!=null && response.body()!=null ){
                    setlist(response.body().getItemSummaries());
                }
                else
                Toast.makeText(SearchActivity.this,"Error : "+response.code()+" "+response.message(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {

                Toast.makeText(SearchActivity.this, "Connection Error", Toast.LENGTH_SHORT).show();

            }
        });

    }





    public void setlist(ArrayList<Product> pList){

        products.clear();
        for(Product p : pList){

            products.add(p);
            productSearchAdapter.notifyItemInserted(products.indexOf(p));
        }
    }


}
