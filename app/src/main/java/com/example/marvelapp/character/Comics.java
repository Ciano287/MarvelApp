package com.example.marvelapp.character;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Comics {

    @SerializedName("available")
    private int available;
    @SerializedName("collectionURI")
    private String collectionURI;
    @SerializedName("items")
    private List<ComicItem> items = null;
    @SerializedName("returned")
    private int returned;

    public int getAvailable() {
        return available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public List<ComicItem> getItems() {
        return items;
    }

    public int getReturned() {
        return returned;
    }

}