package com.example.cookingshocking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class oneRecipe extends AppCompatActivity {
    Button Edit,Delete,Cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_recipe);

        Edit = findViewById(R.id.edit);
        Delete = findViewById(R.id.delete);
        Cancel = findViewById(R.id.cancel1);

        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(oneRecipe.this,Edit.class);
                startActivity(intent);
            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(oneRecipe.this,Home.class);
                startActivity(intent);
            }
        });
    }
}