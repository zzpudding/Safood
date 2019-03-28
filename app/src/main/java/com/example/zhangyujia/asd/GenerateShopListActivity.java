package com.example.zhangyujia.asd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class GenerateShopListActivity extends AppCompatActivity {
    private List mlist=new ArrayList() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_shop_list);
        mlist.add("sadad");
        mlist.add("weqwe");
        String daan=mlist.get(0).toString();
    }
}
