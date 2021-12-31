package com.example.helloworldplus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/*
  This is a very basic Android app that takes user input and display it on a fragment.
*/

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //if this is not new, add a blank fragment to the framelayout.
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frameLayout, BlankFragment.class, null)
                    .commit();
        }
        //find the send button and setup listener.
        Button send_button = (Button)findViewById(R.id.sendbutton);
        send_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.v(TAG,"onClick: Send button was clicked.");
                //get the string entered by the user in EditText.
                EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
                String Hello = "Hello";
                String message = editText.getText().toString();
                Log.v(TAG, message+" was entered.");
                //pass the strings as arguments to the fragment.
                DisplayFragment fragment = DisplayFragment.newInstance(Hello, message);
                //blank fragment is showing, replace fragment with Hello display.
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, fragment)
                        .commit();
            }
        });
    }
}