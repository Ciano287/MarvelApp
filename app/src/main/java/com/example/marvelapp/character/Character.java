package com.example.marvelapp.character;

import com.google.gson.annotations.SerializedName;


public class Character {

    @SerializedName("code")
    private int code;
    @SerializedName("status")
    private String status;
    @SerializedName("copyright")
    private String copyright;
    @SerializedName("attributionText")
    private String attributionText;
    @SerializedName("attributionHTML")
    private String attributionHTML;
    @SerializedName("etag")
    private String etag;
    @SerializedName("data")
    private Data data;

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }


    public String getCopyright() {
        return copyright;
    }


    public String getAttributionText() {
        return attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public String getEtag() {
        return etag;
    }

    public Data getData() {
        return data;
    }


}