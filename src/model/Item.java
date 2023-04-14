package model;

import java.io.Serializable;

public class Item implements Serializable{
    private int itemId;
    private String name;
    private double totalWeight;
    private double price;

    public Item() {}

    public Item(int item,String name, double totalWeight, double price) {
        this.name = name;
        this.totalWeight = totalWeight;
        this.price = price;
        this.itemId = item;
    }


    public String getName() {
        return name;
    }
    public int getId(){
        return this.itemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
