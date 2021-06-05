package com.example.quizgame.database;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;

public class QuizLab {
    @SuppressLint("StaticFieldLeak")
    private static QuizLab staticQuizLab;

    private QuizDao QuizLab;

    private QuizLab(Context context){
        Context appContext = context.getApplicationContext();
        database database = Room.databaseBuilder(appContext, database.class, "quiz")
                .allowMainThreadQueries().build();
        QuizLab = database.getUsuarioDao();
    }

    public static QuizLab get(Context context){
        if (staticQuizLab==null){
            staticQuizLab= new QuizLab(context);
        }
        return staticQuizLab;
    }

    


}
