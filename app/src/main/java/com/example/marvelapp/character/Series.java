package com.example.marvelapp.character;

import com.example.marvelapp.character.SerieItem;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Series {

    @SerializedName("available")
    private Integer available;
    @SerializedName("collectionURI")
    private String collectionURI;
    @SerializedName("items")
    private List<SerieItem> items = null;
    @SerializedName("returned")
    private Integer returned;

    public Integer getAvailable() {
        return available;
    }


    public String getCollectionURI() {
        return collectionURI;
    }

    public List<SerieItem> getItems() {
        return items;
    }



    public Integer getReturned() {
        return returned;
    }


}