package com.example.marvelapp.character;

import com.example.marvelapp.character.EventItem;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Events {

    @SerializedName("available")
    private int available;
    @SerializedName("collectionURI")
    private String collectionURI;
    @SerializedName("items")
    private List<EventItem> items = null;
    @SerializedName("returned")
    private int returned;

    public int getAvailable() {
        return available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }


    public List<EventItem> getItems() {
        return items;
    }


    public int getReturned() {
        return returned;
    }

}