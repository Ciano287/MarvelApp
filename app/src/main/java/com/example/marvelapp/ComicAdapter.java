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
import com.example.marvelapp.comics.ComicResult;

import java.util.ArrayList;
import java.util.List;

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ComicHolder> {
    private Context context;
    private List<ComicResult> comicResults = new ArrayList<>();
    private OnItemClickListener listener;

    public ComicAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public ComicHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_recycler_view_item, parent, false);
        return new ComicHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ComicHolder comicHolder, int position) {
        ComicResult currentComicResult = comicResults.get(position);
        String portraitSize = "/portrait_xlarge.";
        comicHolder.comicNameTextView.setText(currentComicResult.getTitle());
        Glide.with(context).load(currentComicResult.getThumbnail().getPath() +portraitSize + currentComicResult.getThumbnail().getExtension()).into(comicHolder.comicImageView);
        System.out.println(currentComicResult.getThumbnail().getPath() +portraitSize+ currentComicResult.getThumbnail().getExtension());

    }

    @Override
    public int getItemCount() {
        return comicResults.size();
    }

    public void setComicResults(List<ComicResult> comicResults){
        this.comicResults.addAll(comicResults);
        notifyDataSetChanged();
    }


    class ComicHolder extends RecyclerView.ViewHolder {
        ImageView comicImageView;
        TextView comicNameTextView;

        public ComicHolder(@NonNull View itemView) {
            super(itemView);
            comicImageView = itemView.findViewById(R.id.button_image_character);
            comicNameTextView = itemView.findViewById(R.id.text_view_character_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(comicResults.get(position));
                    }
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(ComicResult comicResult);
    }

    public  void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
