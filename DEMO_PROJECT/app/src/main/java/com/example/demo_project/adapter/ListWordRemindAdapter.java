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
        holder.tvWord1.setText(currentWord.getName());
        holder.tvPartOfSpeech1.setText(currentWord.getPartOfSpeech());
        holder.tvMeaning1.setText(currentWord.getContent());
        holder.wordWrapper1.setOnClickListener(new View.OnClickListener() {
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
        return words.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView wordWrapper1;
        TextView tvWord1;
        TextView tvMeaning1;
        TextView tvPartOfSpeech1;
        public ViewHolder(View itemView){
            super(itemView);
            wordWrapper1 = itemView.findViewById(R.id.word_remind_wrapper);
            tvWord1 = itemView.findViewById(R.id.tv_word_remind);
            tvMeaning1 = itemView.findViewById(R.id.tv_meaning_remind);
            tvPartOfSpeech1 = itemView.findViewById(R.id.tv_part_of_speech_remind);
        }
    }
}
