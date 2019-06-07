package com.example.marvelapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.marvelapp.character.CharacterResult;
import com.example.marvelapp.database.CharacterObject;

import java.util.ArrayList;
import java.util.List;

public class MyMarvelCharacterAdapter extends RecyclerView.Adapter<MyMarvelCharacterAdapter.MyMarvelCharacterHolder> {

    private Context context;
    private List<CharacterObject> characterObjects = new ArrayList<>();
    private OnItemClickListener listener;

    public MyMarvelCharacterAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyMarvelCharacterHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_recycler_view_item, parent, false);
        return new MyMarvelCharacterHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyMarvelCharacterHolder myMarvelCharacterHolder, int position) {
        CharacterObject currentCharacter = characterObjects.get(position);
        myMarvelCharacterHolder.characterNameTextView.setText(currentCharacter.getName());

        Glide.with(context)
                .load(currentCharacter.getImagePath())
                .into(myMarvelCharacterHolder.characterImageView);

    }

    public void setCharacterObjects(List<CharacterObject> characterObjects){
        this.characterObjects = characterObjects;
    }

    @Override
    public int getItemCount() {
        return characterObjects.size();
    }

    class MyMarvelCharacterHolder extends RecyclerView.ViewHolder{
        ImageView characterImageView;
        TextView characterNameTextView;

        public MyMarvelCharacterHolder(@NonNull View itemView) {
            super(itemView);

            characterImageView = itemView.findViewById(R.id.button_image_character);
            characterNameTextView = itemView.findViewById(R.id.text_view_character_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(characterObjects.get(position));
                    }
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(CharacterObject characterObject);
    }

    public  void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }}
