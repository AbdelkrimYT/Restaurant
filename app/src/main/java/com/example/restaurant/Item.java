package com.example.restaurant;

public class Item {

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
