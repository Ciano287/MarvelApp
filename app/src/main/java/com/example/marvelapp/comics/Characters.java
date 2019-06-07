
package com.example.marvelapp.comics;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Characters {

    @SerializedName("available")
    private Integer available;
    @SerializedName("collectionURI")
    private String collectionURI;
    @SerializedName("items")
    private List<CharacterItem> items = null;
    @SerializedName("returned")
    private Integer returned;

    public Integer getAvailable() {
        return available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public List<CharacterItem> getItems() {
        return items;
    }

    public Integer getReturned() {
        return returned;
    }

}
