package com.example.marvelapp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ComicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ComicObject comicObject);

    @Delete
    void delete(ComicObject comicObject);

    @Update
    void update(ComicObject comicObject);

    @Query("DELETE FROM comic_table")
    void deleteAllComics();

    @Query("SELECT * FROM comic_table")
    LiveData<List<ComicObject>> getAllComics();
}
