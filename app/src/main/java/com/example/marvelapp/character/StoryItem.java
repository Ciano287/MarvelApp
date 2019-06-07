package com.example.marvelapp.character;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;


public class StoryItem {

    @SerializedName("resourceURI")
    private String resourceURI;
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private String type;

    public String getResourceURI() {
        return resourceURI;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }


}