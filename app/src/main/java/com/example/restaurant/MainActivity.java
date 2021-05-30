package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openListActivity(View view) {
        startActivity(new Intent(this, ListeActivity.class));
    }

    public void openCommandeActivity(View view) {
        startActivity(new Intent(this, CommandeActivity.class));
    }

    public void openFactureActivity(View view) {
        Intent intent = new Intent(this, FactureActivity.class);
        ArrayList<String> data = getIntent().getStringArrayListExtra("CommandeToMain");
        intent.putStringArrayListExtra("MainToFacture", data);
        startActivity(intent);
    }
}