package com.example.demo_project.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo_project.R;
import com.example.demo_project.entity.Word;
import com.example.demo_project.fragment.FragmentDetailWord;
import com.example.demo_project.fragment.FragmentHome;

import java.util.ArrayList;
import java.util.List;

public class ListWordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context currentContext;
    List<Word> words;
    private boolean isLoadingAdd;
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;

    public ListWordAdapter(Context currentContext, List<Word> words) {
        this.currentContext = currentContext;
        this.words = words;
    }

    public void setData(List<Word> data) {
        this.words = data;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        currentContext = parent.getContext();
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(currentContext).inflate(R.layout.item_list_word, parent, false);
            return new WordViewHolder(view);
        } else {
            View view = LayoutInflater.from(currentContext).inflate(R.layout.item_load_more, parent, false);
            return new LoadingViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder rawHolder, int position) {
        if (rawHolder.getItemViewType() == VIEW_TYPE_ITEM) {
            Word currentWord = words.get(position);
            WordViewHolder holder = (WordViewHolder) rawHolder;
            holder.tvWord.setText(currentWord.getName());
            holder.tvMeaning.setText(currentWord.getContent());
            holder.tvPartOfSpeech.setText(currentWord.getPartOfSpeech());
            holder.wordWrapper.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("wordId", currentWord.getId());
                    FragmentDetailWord fragmentDetailWord = new FragmentDetailWord();
                    fragmentDetailWord.setArguments(bundle);
                    ((FragmentActivity) currentContext).getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frameLayout, fragmentDetailWord)
                            .commit();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (words != null && words.size() - 1 == position && isLoadingAdd) {
            return VIEW_TYPE_LOADING;
        }
        return VIEW_TYPE_ITEM;
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {

        CardView wordWrapper;
        TextView tvWord;
        TextView tvMeaning;
        TextView tvPartOfSpeech;

        public WordViewHolder(View itemView) {
            super(itemView);
            wordWrapper = itemView.findViewById(R.id.words_wrapper);
            tvWord = itemView.findViewById(R.id.tv_word);
            tvMeaning = itemView.findViewById(R.id.tv_meaning);
            tvPartOfSpeech = itemView.findViewById(R.id.tv_part_of_speech);
        }
    }

    public class LoadingViewHolder extends RecyclerView.ViewHolder {

        ProgressBar progressBar;

        public LoadingViewHolder(View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }

    public void addFooterLoading() {
        isLoadingAdd = true;
        words.add(new Word());
    }

    public void removeFooterLoading() {
        isLoadingAdd = false;
        int position = words.size() - 1;
        Word p = words.get(position);
        if (p != null) {
            words.remove(position);
            notifyItemRemoved(position);
        }
    }
}

