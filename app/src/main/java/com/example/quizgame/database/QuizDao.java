package com.example.quizgame.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quizgame.schema.Pregunta;
import com.example.quizgame.schema.Respuesta;
import com.example.quizgame.schema.Usuario;

import java.util.List;

@Dao
public interface QuizDao {

    @Query("select * from usuarios")
    List<Usuario> getUsuarios();

    @Query("select * from usuarios ORDER BY puntaje ASC")
    List<Usuario> getUsuariosAscPuntaje();

    @Query("select * from usuarios ORDER BY puntaje DESC")
    List<Usuario> getUsuariosDesPuntaje();

    @Query("select * from usuarios where idusuario like:uuid")
    Usuario getUsuario(String uuid);

    @Query("SELECT COUNT(idusuario) FROM usuarios WHERE nombre like:usuario")
    int getCount(String usuario);

    @Query("select * from respuestas")
    List<Respuesta> getRespuestas();

    @Query("select * from respuestas where idrespuesta like:uuid")
    Respuesta getRespuesta(String uuid);

    @Query("select * from preguntas")
    List<Pregunta> getPreguntas();

    @Query("select * from preguntas where idpregunta like:uuid")
    Pregunta getPregunta(String uuid);

    @Query("select * from respuestas where idpregunta like:uuid")
    List<Respuesta> getOpciones(String uuid);

    @Insert
    void addUsuario(Usuario book);

    @Insert
    void addRespuesta(Respuesta book);

    @Insert
    void addPregunta(Pregunta book);

    @Delete
    void deleteUsuario(Usuario book);

    @Delete
    void deleteRespuesta(Respuesta book);

    @Delete
    void deletePregunta(Pregunta book);

    @Update
    void updateUsuario(Usuario book);

    @Update
    void updateRespuesta(Respuesta book);

    @Update
    void updatePregunta(Pregunta book);

}
