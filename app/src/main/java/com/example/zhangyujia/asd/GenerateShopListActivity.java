package com.example.zhangyujia.asd;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.util.Log;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class GenerateShopListActivity extends AppCompatActivity {
    private static final String TAG = "NewShopListActivity";

    DatabaseHelper mDatabaseHelper;

    private ListView mListView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_shop_list);
        mListView = (ListView) findViewById(R.id.new_shoppingList);
        mDatabaseHelper =  new DatabaseHelper(this);
        getSupportActionBar().setTitle("Shopping List");
        populateListView();
    }

    private void populateListView(){
        Log.d(TAG, "populateListView : Displaying data in the ListView.");

        //get data and append to the list
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get the value from database in column 1
            //add it to the ArrayList
            listData.add(data.getString(2));
            listData.add(data.getString(3));
            listData.add(data.getString(4));
        }
        //create the list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);
    }
}
