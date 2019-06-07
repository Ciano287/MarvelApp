package com.example.marvelapp.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "character_table")
public class CharacterObject {

    @PrimaryKey
    private int id;
    private String name;
    private String imagePath;
    private String description;

    public CharacterObject(int id, String name, String imagePath, String description) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.description = description;

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
