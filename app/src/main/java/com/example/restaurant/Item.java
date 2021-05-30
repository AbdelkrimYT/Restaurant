package com.example.restaurant;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {

    private int imageID;
    private String dishName;
    private String price;
    private String description;
    private boolean flag;

    public Item(int imageID, String dishName, String price, String description) {
        this.imageID = imageID;
        this.dishName = dishName;
        this.price = price;
        this.description = description;
        this.flag = false;
    }

    protected Item(Parcel in) {
        imageID = in.readInt();
        dishName = in.readString();
        price = in.readString();
        description = in.readString();
        flag = in.readByte() != 0;
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageID);
        dest.writeString(dishName);
        dest.writeString(price);
        dest.writeString(description);
        dest.writeByte((byte) (flag ? 1 : 0));
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isChecked() {
        return flag;
    }

    public void check(boolean flag) {
        this.flag = flag;
    }
}
