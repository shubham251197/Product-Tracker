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
    final String accessToken="Bearer v^1.1#i^1#f^0#p^1#r^0#I^3#t^H4sIAAAAAAAAAOVXa2wUVRTu9qUFVyQxLcFitgMmBp3ZO7O73Z0Ju2ShPNZAu7DbBkqgzuMOHTo7s8y9Q1kxodSkqYomgAn4qBYVIo0xFSLEV0RTNVEUQwgPCegfldj4h2g0QY13ZpeyrYRnERL3z+aee+653/edc+6dC7oqq2b2LOz53eu5o7S/C3SVejzsRFBVWfHQ3WWlUytKQJGDp79rRld5d9nZWUjM6FlhKURZ00DQtz6jG0hwjVHKtgzBFJGGBEPMQCRgWUjFFy8SOAYIWcvEpmzqlC/REKXYsCwBwElAqQ8qfLieWI0LMdNmlAryLB+GYQVGIlKIjzjzCNkwYSAsGjhKcYCN0CBAs8E04IVAUAixDMcHWylfC7SQZhrEhQFUzIUruGutIqyXhyoiBC1MglCxRHx+qimeaJjXmJ7lL4oVK+iQwiK20ejRXFOBvhZRt+Hlt0Gut5CyZRkiRPlj+R1GBxXiF8BcB3xX6ojMiawII7IaDnFqiBsXKeebVkbEl8fhWDSFVl1XARpYw7krKUrUkNZAGRdGjSREosHn/C2xRV1TNWhFqXlz4svjySQVQ+221C5mEJ20TMWWcZpOLm2gYUgJg5AUUGheVSSgsrCwUT5aQeYxO801DUVzREO+RhPPgQQ1HKsNV6QNcWoymqy4ih1ERX4se0HDCNfqJDWfRRu3G05eYYYI4XOHV87AyGqMLU2yMRyJMHbClShKidmsplBjJ91aLJTPehSl2jHOCn5/Z2cn0xlgTGu1nwOA9S9bvCglt8OMSBFfp9fz/tqVF9CaS0WGZCXSBJzLEizrSa0SAMZqKsaFguEgKOg+GlZsrPVfhiLO/tEdMV4dEuYBx7MBUQqGeDks8uPRIbFCkfodHFASc3RGtDogzuqiDGmZ1JmdgZamCIGQygUiKqSVel6lg7yq0lJIqadZFUIAoSTJfOT/1ChXW+op2czCpKlrcm5cCn7cij1gKUnRwrkU1HViuNqqvyRJ5JC86fScXr8mik4MRIKIWY1xapuRzYzfFMmh5pjaXNQ3xFsj9+FtlVRCMM9UU/IXGePSZdA6mbEgMm2L3OFMk3Oup80OaJAuwZap69BqYW9IifE70W/RaX5JVrKuERnbbjdm13hMXmdti/gWsi7v9qy4BHM2xLGALONvrFrnunlN5/6DQ+uaErvQRBgqN+EDxD/6ORQrcX9st+cd0O15m7yogB88wE4HdZVlzeVld01FGoaMJqoM0lYb5CvfgkwHzGVFzSqt9KyoHdzTVvQA618Jpow8warK2IlF7zFQe3Gmgp1U42UjIMAGAR8IhthWMP3ibDlbXX7vqrXUX9lHhw+fuG/Wrp9+SfRHPh3uAN4RJ4+nooRURsnB2TNPPzlNOKdv3rf98zN/D256echY8Nq5V3u+7kjUnO9dsPBgg7luT9OSlb163cnv3uqvfH6gx/vNi5P6Kj/5YFJuS+2Sj4eHpv4w+/hHbQNDBxYczRxZtWqzv6Jm55stcrzu/g2Pt/765bQZ506w3pJpzxzb+P3JPw7v39Gc7Htpzr7Z3m+XVQeSg+/+mZq+aebPy6v6Fn91qr/xkZ0lzdvYLU//+PCJKVurthvHmia8t2lXNP3sPQ9S+zdWf2jvPnPqi0Pemlcmv+5f23d8wpHHmKNvHI/3lO0dWFN659LgodoZA8179WFt2VMvnD57YF3dE2ekDdWTe5O/dQztnrhx8LO15ydvK217v3frDv1g1XP59P0D2ddmuxoPAAA=";

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
