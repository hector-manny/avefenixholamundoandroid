package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class WelcolmeActivity extends AppCompatActivity {

    Button btn_Iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btn_Iniciar=findViewById(R.id.button2);

        btn_Iniciar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                BotonIniciarTrivia();
            }
        });
    }
    public void BotonIniciarTrivia (){
        Intent intent= new Intent (this, QuizActivity.class);
        startActivity(intent);
    }

    public void BotonCrearTrivia (View vista){
        Intent intent= new Intent (this, FormquestionActivity.class);
        startActivity(intent);
    }
}