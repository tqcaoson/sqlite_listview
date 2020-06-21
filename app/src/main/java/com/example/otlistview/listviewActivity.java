package com.example.otlistview;


import android.view.View;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class listviewActivity extends AppCompatActivity {
    ListView listView;
    //BHDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_bh);
        anhxa();
        ArrayList<BHModel> arrayList = new ArrayList<>();
//        ArrayList<BHModel> arrayList = new ArrayList<BHModel>();
        arrayList = (ArrayList<BHModel>) getIntent().getSerializableExtra("array");
        BHAdapter adapter = new BHAdapter(listviewActivity.this, arrayList);
        //adapter.GetDL();
        listView.setAdapter(adapter);
    }
    void anhxa() {
        listView = findViewById(R.id.listview);
        //database new BHDatabase(listviewActivity.this);
    }
}
