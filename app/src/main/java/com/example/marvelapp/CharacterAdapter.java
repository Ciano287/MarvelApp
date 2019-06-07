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


import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterHolder> {

    private Context context;
    private List<CharacterResult> characterResults = new ArrayList<>();
    private OnItemClickListener listener;

    public CharacterAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public CharacterHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_recycler_view_item, parent, false);
        return new CharacterHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterHolder characterHolder, int position) {
        CharacterResult currentCharacterResult = characterResults.get(position);
        String portraitSize = "/portrait_xlarge.";
        characterHolder.characterNameTextView.setText(currentCharacterResult.getName());

        Glide.with(context)
                .load(currentCharacterResult
                        .getThumbnail()
                        .getPath() + portraitSize+
                        currentCharacterResult
                                .getThumbnail()
                                .getExtension())
                .into(characterHolder.characterImageView);


    }

    public void setCharacterResults(List<CharacterResult> characterResults) {
        this.characterResults.addAll(characterResults);
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return characterResults.size();
    }

    class CharacterHolder extends RecyclerView.ViewHolder {
        ImageView characterImageView;
        TextView characterNameTextView;

        public CharacterHolder(@NonNull final View itemView) {
            super(itemView);
            characterImageView = itemView.findViewById(R.id.button_image_character);
            characterNameTextView = itemView.findViewById(R.id.text_view_character_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(characterResults.get(position));
                    }
                }
            });


        }
    }
    public interface OnItemClickListener{
        void onItemClick(CharacterResult characterResult);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}

