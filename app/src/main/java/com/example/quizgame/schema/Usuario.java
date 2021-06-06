package com.example.quizgame.schema;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "usuarios")
public class Usuario {
    @PrimaryKey
    @NonNull
    private  String idusuario;
    @ColumnInfo(name="nombre")
    private String nombre;
    @ColumnInfo(name="puntaje")
    private int puntaje;
    @ColumnInfo(name="cantidadRespuestas")
    private int cantidadRespuestas;

    public Usuario(){
        idusuario= UUID.randomUUID().toString();
    }

    @NonNull
    public String getIdusuario(){
        return idusuario;
    }

    public void setIdusuario(@NonNull String id){
        idusuario=id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String name){
        nombre=name;
    }

    public int getPuntaje(){
        return puntaje;
    }

    public void setPuntaje(int score){
        puntaje=score;
    }

    public int getCantidadRespuestas(){
        return cantidadRespuestas;
    }

    public void setCantidadRespuestas(int nQuestions){
        cantidadRespuestas=nQuestions;
    }

}
