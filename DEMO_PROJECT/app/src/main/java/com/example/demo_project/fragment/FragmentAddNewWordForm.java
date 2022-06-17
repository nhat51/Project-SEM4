package com.example.demo_project.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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
    private String token = null;
    CheckBox cb_noun, cb_verb, cb_adj;
    private WordService wordService;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_add_new_word, container, false);
        // first config
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        // check login information.
        SharedPreferences settings = getActivity().getSharedPreferences("ACCESS_TOKEN", Context.MODE_PRIVATE);
        token = settings.getString("token", "");
        Log.d("AddNewFormToken", token);
        wordService = RetrofitGenerator.createService(WordService.class, token);
        initData();
        initListener();
        initBackView();
        return view;
    }

    private void initData() {
        etWord = view.findViewById(R.id.etWord);
        etWordMeaning = view.findViewById(R.id.etWordMeaning);
        etWordExample = view.findViewById(R.id.etWordExample);
        etExampleTrans = view.findViewById(R.id.etExampleTrans);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        btn_back_add_form = view.findViewById(R.id.btn_back_add_form);
        cb_noun = view.findViewById(R.id.cb_noun);
        cb_verb = view.findViewById(R.id.cb_verb);
        cb_adj = view.findViewById(R.id.cb_adjective);
    }

    private void initListener() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = etWord.getText().toString();
                String meaningWord = etWordMeaning.getText().toString();
                String example = etWordExample.getText().toString();
                String translated_example = etExampleTrans.getText().toString();

                Word newWord = new Word();
                newWord.setName(word);
                newWord.setContent(meaningWord);
                newWord.setExample(example);
                newWord.setTranslatedExample(translated_example);
                newWord.setCategoryType(WordCategory.ONCE_A_DAY);

                //check box
                if (cb_noun.isChecked()) {
                    newWord.setPartOfSpeech("Danh từ");
                }
                if (cb_adj.isChecked()) {
                    newWord.setPartOfSpeech("Tính từ");
                }
                if (cb_verb.isChecked()) {
                    newWord.setPartOfSpeech("Động từ");
                }
                Log.d("Success", new Gson().toJson(newWord));
                try {
                    Response<Word> wordCall = wordService.addNewWord(newWord).execute();
                    Log.d("Add New Word: ", wordCall.message());
                    if (wordCall.isSuccessful()) {
                        CharSequence charSequence = "Tạo thành công";
                        Toast toast = Toast.makeText(currentContext.getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                        toast.show();

                        Bundle bundle = new Bundle();
                        bundle.putInt("wordId", wordCall.body().getId());

                        FragmentDetailWord fragmentDetailWord = new FragmentDetailWord();
                        fragmentDetailWord.setArguments(bundle);
                        ((FragmentActivity) currentContext).getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frameLayout, fragmentDetailWord)
                                .commit();

                        etWord.getText().clear();
                        etWordMeaning.getText().clear();
                        etWordExample.getText().clear();
                        etExampleTrans.getText().clear();

                    } else {
                        Log.d("Error", wordCall.code() + "");
                        Log.d("Error", wordCall.errorBody() + "");
                        Log.d("Error", wordCall.message() + "");
                        Log.d("Error", wordCall.isSuccessful() + "");
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
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, MainActivity.fragmentHome, FragmentHome.class.getName())
                        .commit();
            }
        });
    }
}
