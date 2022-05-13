package com.example.demo_project.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo_project.R;
import com.example.demo_project.entity.Word;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
    private Activity activity;
    private List<Word> listWord;
    public WordAdapter(Activity activity, List<Word> listWord){
        this.activity = activity;
        this.listWord = listWord;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(activity).inflate(R.layout.item_list_word, parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Word word = listWord.get(position);
        holder.tvWord.setText(word.getName());
        holder.tvMeaning.setText(word.getContent());
        holder.tvPartOfSpeech.setText(word.getPart_of_speech());
    }

    @Override
    public int getItemCount() {
        return listWord.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvWord;
        TextView tvMeaning;
        TextView tvPartOfSpeech;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvWord = itemView.findViewById(R.id.tv_word);
            tvMeaning = itemView.findViewById(R.id.tv_meaning);
            tvPartOfSpeech = itemView.findViewById(R.id.tv_part_of_speech);
        }
    }
}
