package com.example.demo_project.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.demo_project.MainActivity;
import com.example.demo_project.R;
import com.example.demo_project.fragment.FragmentAccount;

public class FragmentHome extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView txtRememberViewMore = view.findViewById(R.id.remember_view_more);
        txtRememberViewMore.setOnClickListener(view1 -> getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, MainActivity.fragmentListWordRemember, FragmentListWordRemember.class.getName())
                .commit());
//        CardView listRememberHomePage = view.findViewById(R.id.list_remember_home_page);
//        listRememberHomePage.setOnClickListener(view1 -> getActivity().getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.frameLayout, MainActivity.fragmentListWordRemember, FragmentListWordRemember.class.getName())
//                .commit());

        TextView txtAllViewMore = view.findViewById(R.id.all_view_more);
        txtAllViewMore.setOnClickListener(view1 -> getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, MainActivity.fragmentListWord, FragmentListWord.class.getName())
                .commit());

        TextView txtRemidViewMore = view.findViewById(R.id.remind_view_more);
        txtRemidViewMore.setOnClickListener(view1 -> getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, MainActivity.fragmentListWordRemind, FragmentListWordRemind.class.getName())
                .commit());
        return view;
    }
}
