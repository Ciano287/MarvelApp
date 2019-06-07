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

import com.example.marvelapp.MarvelViewModel;
import com.example.marvelapp.ComicAdapter;
import com.example.marvelapp.ComicDetailActivity;
import com.example.marvelapp.ComicSearchAdapter;
import com.example.marvelapp.MainActivity;
import com.example.marvelapp.R;
import com.example.marvelapp.comics.ComicResult;
import com.example.marvelapp.database.ComicObject;

import java.util.List;

import static android.app.Activity.RESULT_OK;

public class ComicFragment extends Fragment {
    private MarvelViewModel marvelViewModel;
    RecyclerView recyclerView;
    Button searchButton;
    EditText searchInput;
    public static int offset = 0;
    private final int PAGE = 20;
    static final int DETAIL_REQUEST = 1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_comic, container, false);
        recyclerView = v.findViewById(R.id.recycler_view_comic);
        searchButton = v.findViewById(R.id.search_button_comic);
        searchInput = v.findViewById(R.id.search_input_comic);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setHasFixedSize(true);


        final ComicAdapter comicAdapter = new ComicAdapter(getContext());
        final ComicSearchAdapter comicSearchAdapter = new ComicSearchAdapter(getContext());
        recyclerView.setAdapter(comicAdapter);

        marvelViewModel = ViewModelProviders
                .of(getActivity())
                .get(MarvelViewModel.class);
        marvelViewModel.getComicObject(0);
        offset = offset + PAGE;
        marvelViewModel.getComicResults().observe(getViewLifecycleOwner(), new Observer<List<ComicResult>>() {
            @Override
            public void onChanged(@Nullable List<ComicResult> comicResults) {
                comicAdapter.setComicResults(comicResults);
                recyclerView.setAdapter(comicAdapter);
            }
        });

        marvelViewModel.getComicSearchResults().observe(getViewLifecycleOwner(), new Observer<List<ComicResult>>() {
            @Override
            public void onChanged(@Nullable List<ComicResult> comicResults) {
                comicSearchAdapter.setComicResults(comicResults);
                recyclerView.setAdapter(comicSearchAdapter);

            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!recyclerView.canScrollVertically(1)) {
                    marvelViewModel.getComicObject(offset);
                    offset = offset + PAGE;
                }
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marvelViewModel.getComicSearch(searchInput.getText().toString());
            }
        });


        comicAdapter.setOnItemClickListener(new ComicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ComicResult comicResult) {
                Intent intent = new Intent(getActivity(), ComicDetailActivity.class);
                intent.putExtra(ComicDetailActivity.EXTRA_ID, comicResult.getId());
                intent.putExtra(ComicDetailActivity.EXTRA_NAME, comicResult.getTitle());
                intent.putExtra(ComicDetailActivity.EXTRA_DESCRIPTION, comicResult.getDescription());

                for (int i = 0; i < comicResult.getUrls().size(); i++) {
                    if (comicResult.getUrls().get(i).getType().equals("purchase")) {
                        intent.putExtra(ComicDetailActivity.EXTRA_BUY_LINK, comicResult.getUrls().get(i).getUrl());
                    }

                }

                intent.putExtra(ComicDetailActivity.EXTRA_IMAGE_PATH, comicResult.getThumbnail().getPath() + MainActivity.PORTRAIT_SIZE + comicResult.getThumbnail().getExtension());
                startActivityForResult(intent, DETAIL_REQUEST);
            }
        });

        comicSearchAdapter.setOnItemClickListener(new ComicSearchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ComicResult comicResult) {
                Intent intent = new Intent(getActivity(), ComicDetailActivity.class);
                intent.putExtra(ComicDetailActivity.EXTRA_ID, comicResult.getId());
                intent.putExtra(ComicDetailActivity.EXTRA_NAME, comicResult.getTitle());
                intent.putExtra(ComicDetailActivity.EXTRA_DESCRIPTION, comicResult.getDescription());


                for (int i = 0; i < comicResult.getUrls().size(); i++) {
                    if (comicResult.getUrls().get(i).getType().equals("purchase")) {
                        intent.putExtra(ComicDetailActivity.EXTRA_BUY_LINK, comicResult.getUrls().get(i).getUrl());
                    }

                }

                intent.putExtra(ComicDetailActivity.EXTRA_IMAGE_PATH, comicResult.getThumbnail().getPath() + MainActivity.PORTRAIT_SIZE + comicResult.getThumbnail().getExtension());
                startActivityForResult(intent, DETAIL_REQUEST);
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == DETAIL_REQUEST && resultCode == RESULT_OK) {

            ComicObject comicObject = new ComicObject(
                    data.getIntExtra(ComicDetailActivity.EXTRA_ID, 0),
                    data.getStringExtra(ComicDetailActivity.EXTRA_NAME),
                    data.getStringExtra(ComicDetailActivity.EXTRA_DESCRIPTION),
                    data.getStringExtra(ComicDetailActivity.EXTRA_BUY_LINK),
                    data.getStringExtra(ComicDetailActivity.EXTRA_IMAGE_PATH));

            marvelViewModel.insert(comicObject);
        }

    }
}
