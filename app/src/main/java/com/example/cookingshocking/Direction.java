package com.example.cookingshocking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Direction extends AppCompatActivity {
    Button finish;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction);

        finish = findViewById(R.id.button9);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Direction.this,Home.class);
                Toast.makeText(getApplicationContext(), "Recipe successfully added.", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}