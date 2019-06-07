package com.example.marvelapp.character;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterResult {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("modified")
    private String modified;
    @SerializedName("thumbnail")
    private Thumbnail thumbnail;
    @SerializedName("resourceURI")
    private String resourceURI;
    @SerializedName("comics")
    private Comics comics;
    @SerializedName("series")
    private Series series;
    @SerializedName("stories")
    private Stories stories;
    @SerializedName("events")
    private Events events;
    @SerializedName("urls")
    private List<Url> urls = null;


    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }


    public String getModified() {
        return modified;
    }


    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public String getResourceURI() {
        return resourceURI;
    }



    public Comics getComics() {
        return comics;
    }



    public Stories getStories() {
        return stories;
    }


    public Events getEvents() {
        return events;
    }


    public List<Url> getUrls() {
        return urls;
    }


}