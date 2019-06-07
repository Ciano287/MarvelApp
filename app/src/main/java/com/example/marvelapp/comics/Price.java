
package com.example.marvelapp.comics;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Price {

    @SerializedName("type")
    private String type;
    @SerializedName("price")
    private Double price;

    public String getType() {
        return type;
    }

    public Double getPrice() {
        return price;
    }

}
