package com.example.marvelapp;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.marvelapp.character.Character;
import com.example.marvelapp.comics.Comic;
import com.example.marvelapp.database.CharacterDao;
import com.example.marvelapp.database.CharacterDatabase;
import com.example.marvelapp.database.CharacterObject;
import com.example.marvelapp.database.ComicDao;
import com.example.marvelapp.database.ComicObject;

import java.util.List;

import retrofit2.Call;

public class MarvelRepository {

    private MarvelService marvelService = MarvelApi.create();
    private CharacterDao characterDao;
    private ComicDao comicDao;
    private LiveData<List<CharacterObject>> allCharacters;
    private LiveData<List<ComicObject>> allComics;

    public MarvelRepository(Application application) {
        CharacterDatabase database = CharacterDatabase.getInstance(application);
        characterDao = database.characterDao();
        comicDao = database.comicDao();
        allCharacters = characterDao.getAllCharacters();
        allComics = comicDao.getAllComics();
    }

    public void insert(CharacterObject characterObject) {
        new InsertCharacterAsyncTask(characterDao).execute(characterObject);
    }

    public void update(CharacterObject characterObject) {
        new UpdateCharacterAsyncTask(characterDao).execute(characterObject);
    }

    public void delete(CharacterObject characterObject) {
        new DeleteCharacterAsyncTask(characterDao).execute(characterObject);
    }

    public void deleteAllCharacters() {
        new DeleteAllCharactersAsyncTask(characterDao).execute();
    }

    public LiveData<List<CharacterObject>> getAllCharacters() {
        return allCharacters;
    }

    public LiveData<List<ComicObject>> getAllComics() {
        return allComics;
    }


    public void insert(ComicObject comicObject) {
        new InsertComicAsyncTask(comicDao).execute(comicObject);
    }

    public void update(ComicObject comicObject) {
        new UpdateComicAsyncTask(comicDao).execute(comicObject);
    }

    public void delete(ComicObject comicObject) {
        new DeleteComicAsyncTask(comicDao).execute(comicObject);
    }

    public void deleteAllComics() {
        new DeleteAllComicsAsyncTask(comicDao).execute();
    }


    private static class InsertCharacterAsyncTask extends AsyncTask<CharacterObject, Void, Void> {
        private CharacterDao characterDao;

        private InsertCharacterAsyncTask(CharacterDao characterDao) {
            this.characterDao = characterDao;
        }

        @Override
        protected Void doInBackground(CharacterObject... characterObjects) {
            characterDao.insert(characterObjects[0]);
            return null;
        }
    }


    private static class UpdateCharacterAsyncTask extends AsyncTask<CharacterObject, Void, Void> {
        private CharacterDao characterDao;

        private UpdateCharacterAsyncTask(CharacterDao characterDao) {
            this.characterDao = characterDao;
        }

        @Override
        protected Void doInBackground(CharacterObject... characterObjects) {
            characterDao.update(characterObjects[0]);
            return null;
        }
    }

    private static class DeleteCharacterAsyncTask extends AsyncTask<CharacterObject, Void, Void> {
        private CharacterDao characterDao;

        private DeleteCharacterAsyncTask(CharacterDao characterDao) {
            this.characterDao = characterDao;
        }

        @Override
        protected Void doInBackground(CharacterObject... characterObjects) {
            characterDao.delete(characterObjects[0]);
            return null;
        }
    }

    private static class DeleteAllCharactersAsyncTask extends AsyncTask<CharacterObject, Void, Void> {
        private CharacterDao characterDao;

        private DeleteAllCharactersAsyncTask(CharacterDao characterDao) {
            this.characterDao = characterDao;
        }

        @Override
        protected Void doInBackground(CharacterObject... characterObjects) {
            characterDao.deleteAllCharacters();
            return null;
        }
    }

    public Call<Character> getCharacter(String apikey, String timestamp, String hash, int offset) {
        return marvelService.getCharacter(apikey, timestamp, hash, offset);
    }

    public Call<Comic> getComic(String apikey, String timestamp, String hash, int offset) {
        return marvelService.getComic(apikey, timestamp, hash, offset);
    }

    public Call<Character> getCharacterSearch(String apikey, String timestamp, String hash, String name) {
        return marvelService.getCharacterSearch(apikey, timestamp, hash, name);
    }

    public Call<Comic> getComicSearch(String apikey, String timestamp, String hash, String title) {
        return marvelService.getComicSearch(apikey, timestamp, hash, title);
    }

    private static class InsertComicAsyncTask extends AsyncTask<ComicObject, Void, Void> {
        private ComicDao comicDao;

        private InsertComicAsyncTask(ComicDao comicDao) {
            this.comicDao = comicDao;
        }

        @Override
        protected Void doInBackground(ComicObject... comicObjects) {
            comicDao.insert(comicObjects[0]);
            return null;
        }
    }

    private static class UpdateComicAsyncTask extends AsyncTask<ComicObject, Void, Void> {
        private ComicDao comicDao;

        private UpdateComicAsyncTask(ComicDao comicDao) {
            this.comicDao = comicDao;
        }

        @Override
        protected Void doInBackground(ComicObject... comicObjects) {
            comicDao.update(comicObjects[0]);
            return null;
        }
    }

    private static class DeleteComicAsyncTask extends AsyncTask<ComicObject, Void, Void> {
        private ComicDao comicDao;

        private DeleteComicAsyncTask(ComicDao comicDao) {
            this.comicDao = comicDao;
        }

        @Override
        protected Void doInBackground(ComicObject... comicObjects) {
            comicDao.delete(comicObjects[0]);
            return null;
        }
    }

    private static class DeleteAllComicsAsyncTask extends AsyncTask<ComicObject, Void, Void> {
        private ComicDao comicDao;

        private DeleteAllComicsAsyncTask(ComicDao comicDao) {
            this.comicDao = comicDao;
        }

        @Override
        protected Void doInBackground(ComicObject... comicObjects) {
            comicDao.deleteAllComics();
            return null;
        }
    }

}
