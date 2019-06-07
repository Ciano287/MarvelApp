
package com.example.marvelapp.comics;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Events {

    @SerializedName("available")
    private Integer available;
    @SerializedName("collectionURI")
    private String collectionURI;
    @SerializedName("items")
    private List<Object> items = null;
    @SerializedName("returned")
    private Integer returned;

    public Integer getAvailable() {
        return available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public List<Object> getItems() {
        return items;
    }

    public Integer getReturned() {
        return returned;
    }

}
