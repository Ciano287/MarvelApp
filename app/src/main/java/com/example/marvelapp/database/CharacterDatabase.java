package com.example.marvelapp.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;


@Database(entities = {CharacterObject.class, ComicObject.class}, version = 3)
public abstract class CharacterDatabase extends RoomDatabase {
    private static CharacterDatabase instance;

    public abstract CharacterDao characterDao();
    public abstract ComicDao comicDao();

    public static synchronized CharacterDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), CharacterDatabase.class,
                    "character_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }
    private static CharacterDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private CharacterDao characterDao;
        private ComicDao comicDao;

        private PopulateDbAsyncTask(CharacterDatabase db) {
            characterDao = db.characterDao();
            comicDao = db.comicDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {


            return null;
        }
    }

}
