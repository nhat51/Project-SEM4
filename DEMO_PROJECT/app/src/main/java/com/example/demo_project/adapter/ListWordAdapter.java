package com.example.demo_project.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo_project.R;
import com.example.demo_project.entity.Word;
import com.example.demo_project.fragment.FragmentDetailWord;
import com.example.demo_project.fragment.FragmentHome;

import java.util.ArrayList;
import java.util.List;

public class ListWordAdapter extends RecyclerView.Adapter<ListWordAdapter.ViewHolder> {
    Context currentContext;
    List<Word> words;
    public ListWordAdapter(Context currentContext, List<Word> words){
        this.currentContext = currentContext;
        this.words = words;
    }
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(currentContext).inflate(R.layout.item_list_word, parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Word currentWord = words.get(position);
        holder.tvWord.setText(currentWord.getName());
        holder.tvMeaning.setText(currentWord.getContent());
        holder.tvPartOfSpeech.setText(currentWord.getPartOfSpeech());
        holder.wordWrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(currentContext, FragmentDetailWord.class);
//                intent.putExtra("words", (ArrayList<Word>) words);
//                int mLastPosition = holder.getAdapterPosition();
//                intent.putExtra("position", mLastPosition);
//                currentContext.startActivity(intent);
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
        CardView wordWrapper;
        TextView tvWord;
        TextView tvMeaning;
        TextView tvPartOfSpeech;
        public ViewHolder(View itemView){
            super(itemView);
            wordWrapper = itemView.findViewById(R.id.words_wrapper);
            tvWord = itemView.findViewById(R.id.tv_word);
            tvMeaning = itemView.findViewById(R.id.tv_meaning);
            tvPartOfSpeech = itemView.findViewById(R.id.tv_part_of_speech);
        }
    }
}
