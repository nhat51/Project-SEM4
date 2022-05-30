package com.example.demo_project.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo_project.R;
import com.example.demo_project.entity.Article;


import java.util.List;

public class ListArticleAdapter extends RecyclerView.Adapter<ListArticleAdapter.ViewHolder>{
    Context currentContext;
    List<Article> articles;
    public ListArticleAdapter(Context currentContext, List<Article> articles){
        this.currentContext = currentContext;
        this.articles = articles;
    }
    @Override
    public ListArticleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(currentContext).inflate(R.layout.item_list_article, parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ListArticleAdapter.ViewHolder holder, int position) {
        Article currentArticle = articles.get(position);
        holder.tvTitleArticle.setText(currentArticle.getTitle());
        holder.tvDescriptionArticle.setText(currentArticle.getDescription());
//        holder.imBannerArticle.setText(currentArticle.getImages());
//        holder.wrapperArticle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Bundle bundle = new Bundle();
//                bundle.putInt("wordId", currentArticle.getId());
//
//                FragmentDetailWord fragmentDetailWord = new FragmentDetailWord();
//                fragmentDetailWord.setArguments(bundle);
//                ((FragmentActivity)currentContext).getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.frameLayout, fragmentDetailWord)
//                        .commit();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView wrapperArticle;
        TextView tvTitleArticle;
        TextView tvDescriptionArticle;
        ImageView imBannerArticle;
        public ViewHolder(View itemView){
            super(itemView);
            wrapperArticle = itemView.findViewById(R.id.article_wrapper);
            imBannerArticle = itemView.findViewById(R.id.banner_article);
            tvTitleArticle = itemView.findViewById(R.id.title_article);
            tvDescriptionArticle = itemView.findViewById(R.id.description_article);
        }
    }
}
