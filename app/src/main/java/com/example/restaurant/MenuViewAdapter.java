package com.example.restaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuViewAdapter extends ArrayAdapter<Item> {

    private Context context;
    private int resource;

    public MenuViewAdapter(Context context, int resource, ArrayList<Item> objects) {
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
        image.setImageResource(getItem(position).getImageID());
        dishName.setText(getItem(position).getDishName());
        price.setText(getItem(position).getPrice());
        return convertView;
    }
}
