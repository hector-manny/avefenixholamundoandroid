package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;

public class WelcolmeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void BotonCrearTrivia (View vista){
        Intent intent= new Intent (this, FormquestionActivity.class);
        startActivity(intent);
    }
}