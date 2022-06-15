package com.example.demo_project.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo_project.R;
import com.example.demo_project.entity.Word;
import com.example.demo_project.fragment.FragmentDetailWord;

import java.util.List;

public class ListWordRemindAdapter extends RecyclerView.Adapter<ListWordRemindAdapter.ViewHolder> {
    Context currentContext;
    List<Word> words;
    public ListWordRemindAdapter(Context currentContext, List<Word> words){
        this.currentContext = currentContext;
        this.words = words;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(currentContext).inflate(R.layout.item_list_word, parent,false);
        return new ListWordRemindAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Word currentWord = words.get(position);
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
                ((FragmentActivity)currentContext).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, fragmentDetailWord)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView wordWrapper;
        TextView tvWord;
        TextView tvMeaning;
        TextView tvPartOfSpeech;
        public ViewHolder(View itemView){
            super(itemView);
            wordWrapper = itemView.findViewById(R.id.word_remembered_wrapper);
            tvWord = itemView.findViewById(R.id.tv_word_remembered);
            tvMeaning = itemView.findViewById(R.id.tv_meaning_remembered);
            tvPartOfSpeech = itemView.findViewById(R.id.tv_part_of_speech_remembered);
        }
    }
}
