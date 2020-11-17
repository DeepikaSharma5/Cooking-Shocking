package com.example.cookingshocking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRecipe extends AppCompatActivity {
    private Button cancel, next;
    DBHeplerRecipe helper;
    EditText Name,Desc,Time,Ing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        cancel = (Button) findViewById(R.id.cancel);
        next = (Button)findViewById(R.id.recipeadd);
        Name = findViewById(R.id.name);
        Desc = findViewById(R.id.des);
        Time = findViewById(R.id.time);
        Ing = findViewById(R.id.ing);

        helper = new DBHeplerRecipe(this);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddRecipe.this,Home.class);
                startActivity(intent);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Name.getText().toString();
                String description = Desc.getText().toString();
                String time = Time.getText().toString();
                String ingredient = Ing.getText().toString();

                if(Name.length() != 0 || Desc.length() != 0 || Time.length() != 0 || Ing.length() != 0){
                    addRecipe(name,description,time,ingredient);
                    Name.setText("");
                    Desc.setText("");
                    Time.setText("");
                    Ing.setText("");
                }else{
                    Toast.makeText(getApplicationContext(), "Can't add empty field(s).", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void addRecipe(String name, String description, String time, String ingredient){
        boolean  insertData = helper.addRecipe(name,description,time,ingredient);
        if (insertData){
            Toast.makeText(getApplicationContext(), "Recipe added successfully ", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}