
package com.example.marvelapp.comics;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class TextObject {

    @SerializedName("type")
    private String type;
    @SerializedName("language")
    private String language;
    @SerializedName("text")
    private String text;

    public String getType() {
        return type;
    }

    public String getLanguage() {
        return language;
    }

    public String getText() {
        return text;
    }

}
