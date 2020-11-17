package com.example.cookingshocking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    Button add;
    DBHeplerRecipe helper;
    private ListView recipelist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        add = findViewById(R.id.button2);
        recipelist = findViewById(R.id.listrecipe);

        helper = new DBHeplerRecipe(this);

        populateListView();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,AddRecipe.class);
                startActivity(intent);
            }
        });
    }

    public void populateListView(){
        Cursor data = helper.getRecipe();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,listData);
        recipelist.setAdapter(adapter);
    }
}