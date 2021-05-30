package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class CommandeActivity extends AppCompatActivity {

    public static final String EXTRA_COMMANDE_TO_MAIN_ITEMS = "com.example.restaurant.CommandeToMainItems";
    public static final String EXTRA_COMMANDE_TO_MAIN_ITEMS_NAME = "com.example.restaurant.CommandeToMainItemsName";
    private ListView listView;
    private ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande);
        listView = (ListView) findViewById(R.id.commandeListView);
        if ((items = getIntent().getParcelableArrayListExtra(MainActivity.EXTRA_MAIN_TO_COMMANDE)) == null)
            items = new ArrayList<>();
        CommandeViewAdapter adapter = new CommandeViewAdapter(this, R.layout.commande_item_view, items);
        listView.setAdapter(adapter);
    }

    public void onClicklValidate(View v) {
        ArrayList<String> dishes = new ArrayList<>();
        Intent intent = new Intent(this, MainActivity.class);
        for (Item item : items)
        {
            if (item.isChecked()) {
                dishes.add(item.getDishName());
            }
        }
        intent.putParcelableArrayListExtra(EXTRA_COMMANDE_TO_MAIN_ITEMS, items);
        intent.putStringArrayListExtra(EXTRA_COMMANDE_TO_MAIN_ITEMS_NAME, dishes);
        startActivity(intent);
    }

    public void onClicklCancel(View v) {
        finish();
    }
}