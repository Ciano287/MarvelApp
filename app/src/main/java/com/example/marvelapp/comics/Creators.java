
package com.example.marvelapp.comics;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Creators {

    @SerializedName("available")
    private Integer available;
    @SerializedName("collectionURI")
    private String collectionURI;
    @SerializedName("creatorItems")
    private List<CreatorItem> creatorItems = null;
    @SerializedName("returned")
    private Integer returned;

    public Integer getAvailable() {
        return available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public List<CreatorItem> getCreatorItems() {
        return creatorItems;
    }

    public Integer getReturned() {
        return returned;
    }

}
