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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marvelapp.CharacterAdapter;
import com.example.marvelapp.CharacterDetailActivity;
import com.example.marvelapp.CharacterSearchAdapter;
import com.example.marvelapp.MarvelViewModel;
import com.example.marvelapp.MainActivity;
import com.example.marvelapp.R;
import com.example.marvelapp.character.CharacterResult;
import com.example.marvelapp.comics.ComicResult;
import com.example.marvelapp.database.CharacterObject;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

public class CharacterFragment extends Fragment {
    private MarvelViewModel marvelViewModel;
    RecyclerView recyclerView;
    Button searchButton;
    EditText searchInput;
    public static final int DETAIL_REQUEST = 1;
    public static int offset = 0;
    private final int PAGE = 20;
    private ArrayList<String> comicsFromCharacterTitles;
    private ArrayList<String> comicsFromCharacterImgUrl;
    private ArrayList<String> comicsFromCharacterDescription;
    private ArrayList<String> comicsFromCharacterBuyLink;
    private ArrayList<Integer> comicsFromCharacterId;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_character, container, false);
        recyclerView = v.findViewById(R.id.recycler_view_character);
        searchButton = v.findViewById(R.id.search_button_character);
        searchInput = v.findViewById(R.id.search_input_character);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setHasFixedSize(true);

        final CharacterAdapter characterAdapter = new CharacterAdapter(getContext());
        final CharacterSearchAdapter characterSearchAdapter = new CharacterSearchAdapter(getContext());
        recyclerView.setAdapter(characterAdapter);

        marvelViewModel = ViewModelProviders
                .of(getActivity())
                .get(MarvelViewModel.class);
        marvelViewModel.getCharacterObject(offset);
        offset = offset + PAGE;
        marvelViewModel.getCharacterResults().observe(getViewLifecycleOwner(), new Observer<List<CharacterResult>>() {
            @Override
            public void onChanged(@Nullable List<CharacterResult> characterResults) {
                characterAdapter.setCharacterResults(characterResults);
            }
        });
        marvelViewModel.getCharacterSearchResults().observe(getViewLifecycleOwner(), new Observer<List<CharacterResult>>() {
            @Override
            public void onChanged(@Nullable List<CharacterResult> characterResults) {
                characterSearchAdapter.setCharacterResults(characterResults);
                recyclerView.setAdapter(characterSearchAdapter);
            }
        });

//        marvelViewModel.getComicsFromCharacterResults().observe(getViewLifecycleOwner(), new Observer<List<ComicResult>>() {
//            @Override
//            public void onChanged(@Nullable List<ComicResult> comicResults) {
//
//                if (comicResults.size() == 0) {
//                    comicsFromCharacterTitles = new ArrayList<>(comicResults.size());
//                    comicsFromCharacterImgUrl = new ArrayList<>(comicResults.size());
//                    comicsFromCharacterDescription = new ArrayList<>(comicResults.size());
//                    comicsFromCharacterId = new ArrayList<>(comicResults.size());
//                    comicsFromCharacterBuyLink = new ArrayList<>(comicResults.size());
//                    for (int i = 0; i < comicResults.size(); i++) {
//                        comicsFromCharacterTitles.set(i, comicResults.get(i).getTitle());
//                        comicsFromCharacterImgUrl.set(i, comicResults.get(i).getThumbnail().getPath() + MainActivity.PORTRAIT_SIZE + comicResults.get(i).getThumbnail().getExtension());
//                        comicsFromCharacterDescription.set(i, comicResults.get(i).getDescription());
//                        comicsFromCharacterId.set(i, comicResults.get(i).getId());
//                        for (int j = 0; j < comicResults.get(i).getUrls().size(); j++) {
//                            if (comicResults.get(i).getUrls().get(j).getType().equals("purchase")) {
//                                comicsFromCharacterBuyLink.set(i, comicResults.get(i).getUrls().get(j).getUrl());
//                            }
//
//
//                        }
//                    }
//
//
//                }
//            }
//        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {
                    marvelViewModel.getCharacterObject(offset);
                    offset = offset + PAGE;
                }
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marvelViewModel.getCharacterSearch(searchInput.getText().toString());

            }
        });


        characterAdapter.setOnItemClickListener(new CharacterAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(CharacterResult characterResult) {
//                marvelViewModel.getComicsFromCharacterObject(characterResult.getId());
//                if (comicsFromCharacterId == null) {
//
//                } else {
                    Intent intent = new Intent(getActivity(), CharacterDetailActivity.class);
                    intent.putExtra(CharacterDetailActivity.EXTRA_NAME, characterResult.getName());
                    intent.putExtra(CharacterDetailActivity.EXTRA_DESCRIPTION, characterResult.getDescription());
                    intent.putExtra(CharacterDetailActivity.EXTRA_IMAGE_PATH, characterResult.getThumbnail().getPath() + MainActivity.PORTRAIT_SIZE + characterResult.getThumbnail().getExtension());
                    intent.putExtra(CharacterDetailActivity.EXTRA_ID, characterResult.getId());
//                    intent.putStringArrayListExtra(CharacterDetailActivity.EXTRA_CHAR_COMIC_TITLE, comicsFromCharacterTitles);
//                    intent.putStringArrayListExtra(CharacterDetailActivity.EXTRA_CHAR_COMIC_IMG_URL, comicsFromCharacterImgUrl);
//                    intent.putStringArrayListExtra(CharacterDetailActivity.EXTRA_CHAR_COMIC_DESCRIPTION, comicsFromCharacterDescription);
//                    intent.putStringArrayListExtra(CharacterDetailActivity.EXTRA_CHAR_COMIC_BUY_LINK, comicsFromCharacterBuyLink);
//                    intent.putIntegerArrayListExtra(CharacterDetailActivity.EXTRA_CHAR_COMIC_ID, comicsFromCharacterId);
//                    System.out.println(comicsFromCharacterId.size() + " dit zijn de ids");
                    startActivityForResult(intent, DETAIL_REQUEST);
//                }
            }
        });

        characterSearchAdapter.setOnItemClickListener(new CharacterSearchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(CharacterResult characterResult) {
                Intent intent = new Intent(getActivity(), CharacterDetailActivity.class);
                intent.putExtra(CharacterDetailActivity.EXTRA_NAME, characterResult.getName());
                intent.putExtra(CharacterDetailActivity.EXTRA_DESCRIPTION, characterResult.getDescription());
                intent.putExtra(CharacterDetailActivity.EXTRA_IMAGE_PATH, characterResult.getThumbnail().getPath() + MainActivity.PORTRAIT_SIZE + characterResult.getThumbnail().getExtension());
                intent.putExtra(CharacterDetailActivity.EXTRA_ID, characterResult.getId());
//                intent.putStringArrayListExtra(CharacterDetailActivity.EXTRA_CHAR_COMIC_TITLE, comicsFromCharacterTitles);
//                intent.putStringArrayListExtra(CharacterDetailActivity.EXTRA_CHAR_COMIC_IMG_URL, comicsFromCharacterImgUrl);
//                intent.putStringArrayListExtra(CharacterDetailActivity.EXTRA_CHAR_COMIC_DESCRIPTION, comicsFromCharacterDescription);
//                intent.putStringArrayListExtra(CharacterDetailActivity.EXTRA_CHAR_COMIC_BUY_LINK, comicsFromCharacterBuyLink);
//                intent.putIntegerArrayListExtra(CharacterDetailActivity.EXTRA_CHAR_COMIC_ID, comicsFromCharacterId);
//                System.out.println(comicsFromCharacterId.size() + " dit zijn de ids");
                startActivityForResult(intent, DETAIL_REQUEST);

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == DETAIL_REQUEST && resultCode == RESULT_OK) {
            int id = data.getIntExtra(CharacterDetailActivity.EXTRA_ID, 1);
            String imagepath = data.getStringExtra(CharacterDetailActivity.EXTRA_IMAGE_PATH);
            String description = data.getStringExtra(CharacterDetailActivity.EXTRA_DESCRIPTION);
            String name = data.getStringExtra(CharacterDetailActivity.EXTRA_NAME);
            CharacterObject characterObject = new CharacterObject(id, name, imagepath, description);
            marvelViewModel.insert(characterObject);
            Toast.makeText(getContext(), "Added!", Toast.LENGTH_LONG).show();
        }
    }

}
