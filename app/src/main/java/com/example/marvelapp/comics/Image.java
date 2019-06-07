
package com.example.marvelapp.comics;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Image {

    @SerializedName("path")
    private String path;
    @SerializedName("extension")
    private String extension;

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }

}
