package com.example.marvelapp;

import com.example.marvelapp.character.Character;
import com.example.marvelapp.comics.Comic;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MarvelService {

    @GET("/v1/public/characters")
    Call<Character> getCharacter(@Query("apikey") String apikey, @Query("ts") String timestamp,
                                 @Query("hash") String hash, @Query("offset") int offset);

    @GET("/v1/public/characters")
    Call<Character> getCharacterSearch(@Query("apikey") String apikey, @Query("ts") String timestamp,
                                       @Query("hash") String hash,  @Query("name") String name);

    @GET("/v1/public/comics")
    Call<Comic> getComicSearch(@Query("apikey") String apikey, @Query("ts") String timestamp,
                                   @Query("hash") String hash, @Query("title") String title);

    @GET("/v1/public/comics")
    Call<Comic> getComic(@Query("apikey") String apikey, @Query("ts") String timestamp,
                         @Query("hash") String hash, @Query("offset") int offset);

    @GET("/v1/public/characters/{characterId}/comics")
    Call<Comic> getComicsFromCharacter( @Path("characterId") int characterId, @Query("apikey") String apikey, @Query("ts") String timestamp,
                                       @Query("hash") String hash);

    @GET("/v1/public/comics/{comicId}/characters")
    Call<Character> getCharactersFromComic(@Path("comicId") int comicId, @Query("apikey") String apikey, @Query("ts") String timestamp,
                                           @Query("hash") String hash);
}
