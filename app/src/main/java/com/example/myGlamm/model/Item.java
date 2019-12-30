package com.example.myGlamm.model;

public class Item {

    private String key;
    private Double value;

    public Item(String key, Double value)
    {
        this.key=key;
        this.value=value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
