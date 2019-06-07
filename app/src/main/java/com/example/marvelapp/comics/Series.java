
package com.example.marvelapp.comics;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Series {

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
