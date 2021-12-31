package com.example.helloworldplus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*
  A fragment subclass that controls the fragment responsible for displaying Hello message.
*/

public class DisplayFragment extends Fragment {
    private static final String TAG ="DisplayFragment";
    private static final String HELLO = "param1";
    private static final String NAME = "param2";

    private String str1;
    private String str2;

    public DisplayFragment() {
        // Required empty public constructor
        super(R.layout.fragment_display);
    }

    /*
      This static method takes two string parameters, initializes the fragment's arguments,
      and returns the new fragment to the client.
    */
    public static DisplayFragment newInstance(String param1, String param2) {
        Log.v(TAG,"newInstance: Getting string from Activity...");
        DisplayFragment fragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putString("HELLO", param1);
        args.putString("NAME", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            str1 = getArguments().getString("HELLO");
            str2 = getArguments().getString("NAME");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // Inflate the layout for this fragment and set text with strings from MainActivity
            Log.v(TAG,"onCreateView: Displaying hello message.");
            View view =  inflater.inflate(R.layout.fragment_display, container, false);
            TextView text = view.findViewById(R.id.helloText);
            text.setText(str1+" "+str2+"!");
            return view;
    }
}