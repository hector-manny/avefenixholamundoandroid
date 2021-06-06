package com.example.quizgame.schema;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "preguntas")
public class Pregunta {
    @PrimaryKey
    @NonNull
    private  String idpregunta;
    @ColumnInfo(name="pregunta")
    private String pregunta;
    @ColumnInfo(name="valorPuntos")
    private int valorPuntos;




    public Pregunta(){
        idpregunta= UUID.randomUUID().toString();
    }

    public Pregunta(String pregunta, int valorPuntos) {
        idpregunta= UUID.randomUUID().toString();
        this.pregunta = pregunta;
        this.valorPuntos = valorPuntos;
    }

    @NonNull
    public String getIdpregunta(){
        return idpregunta;
    }

    public void setIdpregunta(@NonNull String id){
        idpregunta=id;
    }

    public String getPregunta(){
        return pregunta;
    }

    public void setPregunta(String question){
        pregunta=question;
    }

    public int getValorPuntos(){
        return valorPuntos;
    }

    public void setValorPuntos(int pointValue) {
        valorPuntos = pointValue;
    }

}
