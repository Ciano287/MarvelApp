package com.example.marvelapp.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "comic_table")
public class ComicObject {

    @PrimaryKey
    private int id;
    private String name;
    private String description;
    private String buyUrl;
    private String imagePath;

    public ComicObject(int id, String name, String description, String buyUrl, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.buyUrl = buyUrl;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBuyUrl() {
        return buyUrl;
    }

    public void setBuyUrl(String buyUrl) {
        this.buyUrl = buyUrl;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
