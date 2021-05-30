package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListeActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        listView = (ListView) findViewById(R.id.menuListView);
        if ((items = getIntent().getParcelableArrayListExtra(MainActivity.EXTRA_MAIN_TO_LIST)) == null)
            items = new ArrayList<>();
        MenuViewAdapter adapter = new MenuViewAdapter(this, R.layout.liste_item_view, items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String description = items.get(position).getDescription();
                Toast.makeText(getApplicationContext(), description, Toast.LENGTH_LONG).show();
            }
        });
    }
}