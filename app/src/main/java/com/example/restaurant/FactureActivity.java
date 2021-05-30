package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.UTFDataFormatException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;

public class FactureActivity extends AppCompatActivity {

    private ListView factureListView;
    ArrayList<String> dishs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facture);
        factureListView = (ListView) findViewById(R.id.factureListView);
        if ((dishs = getIntent().getStringArrayListExtra(MainActivity.EXTRA_MAIN_TO_FACTURE)) == null)
                dishs = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dishs);
        factureListView.setAdapter(adapter);
    }
}