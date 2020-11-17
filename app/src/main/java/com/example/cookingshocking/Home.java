package com.example.cookingshocking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    Button add;
    DBHeplerRecipe helper;
    private ListView recipelist;

    private static final String TAG = "Home";


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

        recipelist.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();
                String description = adapterView.getItemAtPosition(i).toString();
                String ingredient = adapterView.getItemAtPosition(i).toString();
                String time = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG,"onItemClick: You clicked on " + name);

                Cursor data = helper.getId(name,description,ingredient,time);
                int Id = -1;
                while(data.moveToNext()){
                    Id = data.getInt(0);
                }
                if(Id > -1){
                    Intent intent = new Intent(Home.this,oneRecipe.class);
                    intent.putExtra("id",Id);
                    intent.putExtra("name",name);
                    intent.putExtra("description",description);
                    intent.putExtra("ingredient",ingredient);
                    intent.putExtra("time",time);
                }
                else{
                    Toast.makeText(getApplicationContext(), "No data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}