package com.example.otlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button nhaplieu, xemds;
    EditText ten, anh, casi, like;
    //BHDatabase database;
    ArrayList<BHModel> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        //database.themBH(new BHModel(1, 1, "hihi", "haha"));
        nhaplieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //database.themBH(new BHModel(Integer.valueOf(anh.getText().toString()), Integer.valueOf(like.getText().toString()), ten.getText().toString(), casi.getText().toString()));
                arrayList.add(new BHModel(Integer.valueOf(anh.getText().toString()), Integer.valueOf(like.getText().toString()), ten.getText().toString(), casi.getText().toString()));
            }
        });
        xemds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, listviewActivity.class);
                intent.putExtra("array", arrayList);
                startActivity(intent);
            }
        });
    }
    void anhxa() {
        nhaplieu = findViewById(R.id.nhaplieu);
        xemds = findViewById(R.id.xemds);
        ten = findViewById(R.id.tenbh);
        anh = findViewById(R.id.anh);
        casi = findViewById(R.id.casi);
        like = findViewById(R.id.like);
        arrayList = new ArrayList<>();
        //database = new BHDatabase(MainActivity.this);
    }
}
