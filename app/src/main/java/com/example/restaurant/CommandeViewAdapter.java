package com.example.restaurant;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CommandeViewAdapter extends ArrayAdapter<Item> {

    private final Context context;
    private final int resource;

    public CommandeViewAdapter(Context context, int resource, ArrayList<Item> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource, parent, false);
        ImageView image = convertView.findViewById(R.id.itemImage);
        TextView dishName = convertView.findViewById(R.id.dishName);
        TextView price = convertView.findViewById(R.id.price);
        CheckBox checkBox = convertView.findViewById(R.id.checkBox);
        image.setImageResource(getItem(position).getImageID());
        dishName.setText(getItem(position).getDishName());
        price.setText(getItem(position).getPrice());
        checkBox.setChecked(getItem(position).isChecked());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getItem(position).check(isChecked);
            }
        });
        return convertView;
    }
}
