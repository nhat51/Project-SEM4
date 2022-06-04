package com.example.demo_project.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.demo_project.MainActivity;
import com.example.demo_project.R;
import com.example.demo_project.entity.Word;
import com.example.demo_project.entity.enums.WordCategory;
import com.example.demo_project.service.WordService;
import com.example.demo_project.util.RetrofitGenerator;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Response;

public class FragmentAddNewWordForm extends Fragment {
    private EditText etWord, etWordMeaning, etPartOfSpeech, etWordExample, etExampleTrans;
    private Button btnSubmit;
    private ImageView btn_back_add_form;
    private View view;
    private Context currentContext;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        currentContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_add_new_word, container, false);
        initData();
        initListener();
        initBackView();
        return view;
    }
    private void initData() {
        etWord = view.findViewById(R.id.etWord);
        etWordMeaning = view.findViewById(R.id.etWordMeaning);
        etPartOfSpeech = view.findViewById(R.id.etPartOfSpeech);
        etWordExample = view.findViewById(R.id.etWordExample);
        etExampleTrans = view.findViewById(R.id.etExampleTrans);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        btn_back_add_form = view.findViewById(R.id.btn_back_add_form);
    }
    private void initListener() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                String word = etWord.getText().toString();
                String meaningWord = etWordMeaning.getText().toString();
                String partOfSpeech = etPartOfSpeech.getText().toString();
                String example = etWordExample.getText().toString();
                String translated_example = etExampleTrans.getText().toString();

                Word newWord = new Word();
                newWord.setName(word);
                newWord.setContent(meaningWord);
                newWord.setPartOfSpeech(partOfSpeech);
                newWord.setExample(example);
                newWord.setTranslatedExample(translated_example);
                newWord.setCategoryType(WordCategory.ONCE_A_DAY);
                newWord.setUserId(1);

                WordService wordService = RetrofitGenerator.createService(WordService.class);
                Log.d("Success", new Gson().toJson(newWord));
                Response<Word> wordCall = null;
                try {
                    wordCall = wordService.addNewWord(newWord).execute();
                    if(wordCall.isSuccessful()){
                        CharSequence charSequence = "Tạo thành công";
                        Toast toast = Toast.makeText(currentContext.getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                        toast.show();

                        Bundle bundle = new Bundle();
                        bundle.putInt("wordId", wordCall.body().getId());

                        FragmentDetailWord fragmentDetailWord = new FragmentDetailWord();
                        fragmentDetailWord.setArguments(bundle);
                        ((FragmentActivity)currentContext).getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frameLayout, fragmentDetailWord)
                                .commit();

                        etWord.getText().clear();
                        etPartOfSpeech.getText().clear();
                        etWordMeaning.getText().clear();
                        etWordExample.getText().clear();
                        etExampleTrans.getText().clear();

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    CharSequence charSequence = e.getMessage();
                    Toast toast = Toast.makeText(currentContext.getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
    private void initBackView() {
        btn_back_add_form = view.findViewById(R.id.btn_back_add_form);
        btn_back_add_form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_back_add_form.setOnClickListener(view1 -> getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, MainActivity.fragmentHome, FragmentHome.class.getName())
                        .commit());
            }
        });
    }
}
