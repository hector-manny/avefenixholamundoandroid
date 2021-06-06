package com.example.quizgame.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.speech.SpeechRecognizer;

import androidx.room.Query;
import androidx.room.Room;

import com.example.quizgame.schema.Pregunta;
import com.example.quizgame.schema.Respuesta;
import com.example.quizgame.schema.Usuario;

import java.util.List;

public class QuizLab {
    @SuppressLint("StaticFieldLeak")
    private static QuizLab staticQuizLab;

    private static QuizDao QuizLab;

    private QuizLab(Context context){
        Context appContext = context.getApplicationContext();
        database database = Room.databaseBuilder(appContext, database.class, "quiz").allowMainThreadQueries().build();
        QuizLab = database.getUsuarioDao();
    }

    public static QuizLab get(Context context){
        if (staticQuizLab==null){
            staticQuizLab= new QuizLab(context);
        }
        return staticQuizLab;
    }

    public List<Usuario> getUsuarios(){return QuizLab.getUsuarios();}

    public List<Usuario> getUsuariosAscPuntaje(){return QuizLab.getUsuariosAscPuntaje();}

    public List<Usuario> getUsuariosDesPuntaje(){return QuizLab.getUsuariosDesPuntaje();}

    public int getCount(String usuario){return QuizLab.getCount(usuario);}

    public static List<Pregunta> getPreguntas(){return QuizLab.getPreguntas();}

    public List<Respuesta> getRespuestas(){return QuizLab.getRespuestas();}

    public Usuario getUsuario(String id){return QuizLab.getUsuario(id);}

    public Pregunta getPregunta(String id){return QuizLab.getPregunta(id);}

    public Respuesta getRespuesta(String id){return QuizLab.getRespuesta(id);}

    public void addUsuario(Usuario usuario){QuizLab.addUsuario(usuario);}

    public void addPregunta(Pregunta pregunta){QuizLab.addPregunta(pregunta);}

    public void addRespuesta(Respuesta respuesta){QuizLab.addRespuesta(respuesta);}

    public void updateUsuario(Usuario usuario){QuizLab.updateUsuario(usuario);}

    public void updatePregunta(Pregunta pregunta){QuizLab.updatePregunta(pregunta);}

    public void updateRespuesta(Respuesta respuesta){QuizLab.updateRespuesta(respuesta);}

    public void deleteUsuario(Usuario usuario){QuizLab.deleteUsuario(usuario);}

    public void deletePregunta(Pregunta pregunta){QuizLab.deletePregunta(pregunta);}

    public void deleteRespuesta(Respuesta respuesta){QuizLab.deleteRespuesta(respuesta);}

    public List<Respuesta> getOpciones(String idrandom){return QuizLab.getOpciones(idrandom);}

}
