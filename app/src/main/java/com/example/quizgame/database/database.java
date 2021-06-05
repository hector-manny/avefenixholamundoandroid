package com.example.quizgame.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.quizgame.schema.Pregunta;
import com.example.quizgame.schema.Respuesta;
import com.example.quizgame.schema.Usuario;

@Database(entities = {Usuario.class, Pregunta.class, Respuesta.class}, version = 1)
public abstract class database extends RoomDatabase {
    public abstract QuizDao getUsuarioDao();
}
