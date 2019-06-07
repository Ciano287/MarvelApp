
package com.example.marvelapp.comics;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class CreatorItem {

    @SerializedName("resourceURI")
    private String resourceURI;
    @SerializedName("name")
    private String name;
    @SerializedName("role")
    private String role;

    public String getResourceURI() {
        return resourceURI;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

}
