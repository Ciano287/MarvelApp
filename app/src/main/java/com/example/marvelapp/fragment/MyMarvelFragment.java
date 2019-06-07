package com.example.marvelapp.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marvelapp.CharacterDetailActivity;
import com.example.marvelapp.ComicDetailActivity;
import com.example.marvelapp.MainActivity;
import com.example.marvelapp.MarvelViewModel;
import com.example.marvelapp.MyMarvelCharacterAdapter;
import com.example.marvelapp.MyMarvelComicAdapter;
import com.example.marvelapp.R;
import com.example.marvelapp.database.CharacterObject;
import com.example.marvelapp.database.ComicObject;

import java.util.List;

public class MyMarvelFragment extends Fragment {

    RecyclerView characterRecyclerView;
    RecyclerView comicRecyclerView;
    private MarvelViewModel marvelViewModel;
    final int DETAIL_REQUEST = 1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_marvel, container, false);
        characterRecyclerView = v.findViewById(R.id.my_marvel_recycler_view_character);
        comicRecyclerView = v.findViewById(R.id.my_marvel_recycler_view_comics);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final MyMarvelCharacterAdapter myMarvelCharacterAdapter = new MyMarvelCharacterAdapter(getContext());
        final MyMarvelComicAdapter myMarvelComicAdapter = new MyMarvelComicAdapter(getContext());
        characterRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, 0, false));
        comicRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, 0, false));
        characterRecyclerView.setHasFixedSize(true);
        comicRecyclerView.setHasFixedSize(true);
        characterRecyclerView.setAdapter(myMarvelCharacterAdapter);
        comicRecyclerView.setAdapter(myMarvelComicAdapter);


        marvelViewModel = ViewModelProviders
                .of(getActivity())
                .get(MarvelViewModel.class);
        marvelViewModel.getAllCharacters().observe(getViewLifecycleOwner(), new Observer<List<CharacterObject>>() {
            @Override
            public void onChanged(@Nullable List<CharacterObject> characterObjects) {
                myMarvelCharacterAdapter.setCharacterObjects(characterObjects);
            }
        });
        marvelViewModel.getAllComics().observe(getViewLifecycleOwner(), new Observer<List<ComicObject>>() {
            @Override
            public void onChanged(@Nullable List<ComicObject> comicObjects) {
                myMarvelComicAdapter.setComicObjects(comicObjects);
            }
        });

        myMarvelCharacterAdapter.setOnItemClickListener(new MyMarvelCharacterAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(CharacterObject characterObject) {
                Intent intent = new Intent(getActivity(), CharacterDetailActivity.class);
                intent.putExtra(CharacterDetailActivity.EXTRA_ID, characterObject.getId());
                intent.putExtra(CharacterDetailActivity.EXTRA_DESCRIPTION, characterObject.getDescription());
                intent.putExtra(CharacterDetailActivity.EXTRA_NAME, characterObject.getName());
                intent.putExtra(CharacterDetailActivity.EXTRA_IMAGE_PATH, characterObject.getImagePath());
                startActivityForResult(intent, DETAIL_REQUEST);

            }
        });

        myMarvelComicAdapter.setOnItemClickListener(new MyMarvelComicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ComicObject comicObject) {
                Intent intent = new Intent(getActivity(), ComicDetailActivity.class);
                intent.putExtra(CharacterDetailActivity.EXTRA_ID, comicObject.getId());
                intent.putExtra(CharacterDetailActivity.EXTRA_DESCRIPTION, comicObject.getDescription());
                intent.putExtra(CharacterDetailActivity.EXTRA_NAME, comicObject.getName());
                intent.putExtra(CharacterDetailActivity.EXTRA_IMAGE_PATH, comicObject.getImagePath());
                startActivityForResult(intent, DETAIL_REQUEST);
            }
        });



    }
}
