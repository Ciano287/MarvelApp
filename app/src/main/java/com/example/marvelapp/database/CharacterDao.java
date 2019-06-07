package com.example.marvelapp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.marvelapp.database.CharacterObject;

import java.util.List;

@Dao
public interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CharacterObject characterObject);

    @Delete
    void delete(CharacterObject characterObject);

    @Update
    void update(CharacterObject characterObject);

    @Query("DELETE FROM character_table")
    void deleteAllCharacters();

    @Query("SELECT * FROM character_table")
    LiveData<List<CharacterObject>> getAllCharacters();

}
