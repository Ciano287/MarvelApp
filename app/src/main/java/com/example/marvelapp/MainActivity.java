package com.example.marvelapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.marvelapp.fragment.CharacterFragment;
import com.example.marvelapp.fragment.ComicFragment;
import com.example.marvelapp.fragment.MyMarvelFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private MarvelViewModel marvelViewModel;
    private TextView testView;
    RecyclerView recyclerView;
    ComicAdapter comicAdapter;
    public final static String PORTRAIT_SIZE = "/portrait_xlarge.";


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.nav_character:
                    selectedFragment = new CharacterFragment();
                    break;
                case R.id.nav_comic:
                    selectedFragment = new ComicFragment();
                    break;
                case R.id.nav_my_marvel:
                    selectedFragment = new MyMarvelFragment();
                    break;
                default :
                    selectedFragment = new CharacterFragment();
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CharacterFragment()).commit();

//        recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
//        recyclerView.setHasFixedSize(true);
//        final CharacterAdapter characterAdapter = new CharacterAdapter(this);
//
//        recyclerView.setAdapter(characterAdapter);
//
//        characterAdapter.setOnItemClickListener(new CharacterAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(CharacterResult characterResult) {
//
//            }
//        });
//
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        marvelViewModel = ViewModelProviders
//                .of(this)
//                .get(MarvelViewModel.class);
//        marvelViewModel.getCharacterObject(0);
//        marvelViewModel.getCharacterResults().observe(this, new Observer<List<CharacterResult>>() {
//            @Override
//            public void onChanged(@Nullable List<CharacterResult> characterResults) {
//                characterAdapter.setComicResults(characterResults);
//            }
//        });
////        marvelViewModel.getComicResults().observe(this, new Observer<List<ComicResult>>() {
////            @Override
////            public void onChanged(@Nullable List<ComicResult> comicResults) {
////                comicAdapter.setComicResults(comicResults);
////            }
////        });
////        comicAdapter = new ComicAdapter(this);
//
////        marvelViewModel.getComicObject(0);
//
//        marvelViewModel.getError().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
//            }
//        });
//
    }

}
