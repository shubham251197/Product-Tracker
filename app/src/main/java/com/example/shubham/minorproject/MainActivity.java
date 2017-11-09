package com.example.shubham.minorproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<TrackingProduct> TrackingProducts;
    TrackListAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,SearchLinkActivity.class);
                startActivity(i);
            }
        });

        recyclerView=(RecyclerView) findViewById(R.id.tracking_list);

        TrackingProducts=new ArrayList<>();

        adapter=new TrackListAdapter(this,TrackingProducts);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        GetTrackingProduct();
    }


    @Override
    protected void onResume() {
        super.onResume();
        GetTrackingProduct();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.refresh,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.refresh){

            Toast.makeText(this, "REFRESHED !!", Toast.LENGTH_SHORT).show();
        }

        return true;
    }






    private void GetTrackingProduct() {
        TrackingProducts.clear();
      AppOpenHelper openHelper=new AppOpenHelper(this);
      SQLiteDatabase database= openHelper.getReadableDatabase();
      Cursor cursor= database.query(AppOpenHelper.DB_TABLENAME,null,null,null,null,null,null);
        while(cursor.moveToNext()){

            String title=cursor.getString(cursor.getColumnIndex(openHelper.DB_TITLE));
            String price=cursor.getString(cursor.getColumnIndex(openHelper.DB_PRICE));
            String image=cursor.getString(cursor.getColumnIndex(openHelper.DB_IMAGE));

            TrackingProduct p=new TrackingProduct(title,price,image);
            TrackingProducts.add(p);
            adapter.notifyItemInserted(TrackingProducts.indexOf(p));

        }
    }


}
