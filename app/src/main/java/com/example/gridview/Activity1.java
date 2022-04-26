package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Activity1 extends AppCompatActivity {
    Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn1.setOnClickListener(view -> {
            Bundle b = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
            startActivity(new Intent(this, MainActivity.class), b);
        });
        btn2.setOnClickListener(view -> {
            Bundle c = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
            startActivity(new Intent(this, Activity2.class), c);
        });
    }
}