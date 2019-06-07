package com.example.marvelapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.marvelapp.character.Character;
import com.example.marvelapp.character.CharacterResult;
import com.example.marvelapp.comics.Comic;
import com.example.marvelapp.comics.ComicResult;
import com.example.marvelapp.database.CharacterObject;
import com.example.marvelapp.database.ComicObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarvelViewModel extends AndroidViewModel {
    private MarvelRepository marvelRepository;
    private MutableLiveData<List<CharacterResult>> characterResults;
    private MutableLiveData<List<CharacterResult>> charactersFromComicResults;
    private MutableLiveData<List<CharacterResult>> characterSearchResults;
    private LiveData<List<CharacterObject>> savedCharacterResults;
    private LiveData<List<ComicObject>> savedComicResults;
    private MutableLiveData<List<ComicResult>> comicResults;
    private MutableLiveData<List<ComicResult>> comicsFromCharacterResults;
    private MutableLiveData<List<ComicResult>> comicSearchResults;
    private MutableLiveData<String> error;
    private String apikey = "f8d4794a7f5de8fdf45075a1730dc8e0";
    private String hash = "ce77bc09a12766b1e20535678c78ff9c";
    private String ts = "123456789";

    public MarvelViewModel(@NonNull Application application) {
        super(application);

        marvelRepository = new MarvelRepository(application);
        characterResults = new MutableLiveData<>();
        characterSearchResults = new MutableLiveData<>();
        charactersFromComicResults = new MutableLiveData<>();
        comicsFromCharacterResults = new MutableLiveData<>();
        comicResults = new MutableLiveData<>();
        comicSearchResults = new MutableLiveData<>();

        error = new MutableLiveData<>();
        savedCharacterResults = marvelRepository.getAllCharacters();
        savedComicResults = marvelRepository.getAllComics();
    }

    public void insert(CharacterObject characterObject) {
        marvelRepository.insert(characterObject);
    }

    public void update(CharacterObject characterObject) {
        marvelRepository.update(characterObject);
    }

    public void delete(CharacterObject characterObject) {
        marvelRepository.delete(characterObject);
    }

    public void deleteAllCharacters() {
        marvelRepository.deleteAllCharacters();
    }

    public void insert(ComicObject comicObject) {
        marvelRepository.insert(comicObject);
    }

    public void update(ComicObject comicObject) {
        marvelRepository.update(comicObject);
    }

    public void delete(ComicObject comicObject) {
        marvelRepository.delete(comicObject);
    }

    public void deleteAllComics() {
        marvelRepository.deleteAllComics();
    }

    public LiveData<List<CharacterObject>> getAllCharacters() {
        return savedCharacterResults;
    }

    public LiveData<List<ComicObject>> getAllComics() {
        return savedComicResults;
    }


    public MutableLiveData<String> getError() {

        return error;

    }


    public MutableLiveData<List<CharacterResult>> getCharacterResults() {

        return characterResults;

    }

    public MutableLiveData<List<ComicResult>> getComicResults() {
        return comicResults;
    }


    public MutableLiveData<List<CharacterResult>> getCharacterSearchResults() {
        return characterSearchResults;
    }


    public MutableLiveData<List<ComicResult>> getComicSearchResults() {
        return comicSearchResults;
    }


    public void getCharacterObject(int offset) {


        marvelRepository
                .getCharacter(apikey, ts, hash, offset)
                .enqueue(new Callback<Character>() {

                    @Override
                    public void onResponse(@NonNull Call<Character> call, @NonNull Response<Character> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            characterResults.setValue(response.body().getData().getCharacterResults());
                        } else {
                            error.setValue("Api Error: " + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<Character> call, Throwable t) {
                        error.setValue("Api Error: " + t.getMessage());

                    }
                });
    }


    public void getComicObject(int offset) {
        marvelRepository.getComic(apikey, ts, hash, offset).enqueue(new Callback<Comic>() {
            @Override
            public void onResponse(Call<Comic> call, Response<Comic> response) {
                if (response.isSuccessful() && response.body() != null) {
                    comicResults.setValue(response.body().getData().getComicResults());
                } else {
                    error.setValue("Api Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Comic> call, Throwable t) {
                error.setValue("Api Error: " + t.getMessage());
            }
        });
    }

    public void getCharacterSearch(String name) {
        marvelRepository.getCharacterSearch(apikey, ts, hash, name).enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                if (response.isSuccessful() && response.body() != null) {
                    characterSearchResults.setValue(response.body().getData().getCharacterResults());
                } else {
                    error.setValue("Api Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                error.setValue("Api Error: " + t.getMessage());

            }
        });
    }

    public void getComicSearch(String title) {
        marvelRepository.getComicSearch(apikey, ts, hash, title).enqueue(new Callback<Comic>() {
            @Override
            public void onResponse(Call<Comic> call, Response<Comic> response) {
                if (response.isSuccessful() && response.body() != null) {
                    comicSearchResults.setValue(response.body().getData().getComicResults());
                } else {
                    error.setValue("Api Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Comic> call, Throwable t) {
                error.setValue("Api Error: " + t.getMessage());

            }
        });
    }
}
