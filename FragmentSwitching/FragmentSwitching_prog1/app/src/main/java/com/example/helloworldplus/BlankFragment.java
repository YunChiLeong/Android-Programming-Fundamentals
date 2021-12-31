package com.example.helloworldplus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*
  A simple fragment subclass that controls the blank fragment.
*/

public class BlankFragment extends Fragment {
    private static final String TAG ="BlankFragment";
    View view;

    public BlankFragment(){
        //Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v(TAG,"onCreateView");
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_blank, container, false);
        return view;
    }
}