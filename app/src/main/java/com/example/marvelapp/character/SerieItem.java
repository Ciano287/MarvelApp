package com.example.marvelapp.character;

import com.google.gson.annotations.SerializedName;

public class SerieItem {

    @SerializedName("resourceURI")
    private String resourceURI;
    @SerializedName("name")
    private String name;

    public String getResourceURI() {
        return resourceURI;
    }


    public String getName() {
        return name;
    }


}