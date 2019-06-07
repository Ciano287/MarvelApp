
package com.example.marvelapp.character;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Stories {

    @SerializedName("available")
    private Integer available;
    @SerializedName("collectionURI")
    private String collectionURI;
    @SerializedName("items")
    private List<StoryItem> items = null;
    @SerializedName("returned")
    private Integer returned;

    public Integer getAvailable() {
        return available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }


    public List<StoryItem> getItems() {
        return items;
    }


    public Integer getReturned() {
        return returned;
    }


}