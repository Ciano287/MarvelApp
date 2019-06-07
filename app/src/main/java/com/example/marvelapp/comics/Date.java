
package com.example.marvelapp.comics;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Date {

    @SerializedName("type")
    private String type;
    @SerializedName("date")
    private String date;

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

}
