package com.example.quizgame.schema;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "respuestas")
public class Respuesta {
    @PrimaryKey
    @NonNull
    private String idrespuesta;
    @ColumnInfo(name="idpregunta")
    @NonNull
    private String idpregunta;
    @ColumnInfo(name="respuesta")
    private String respuesta;
    @ColumnInfo(name="estado")
    private int estado;

    public Respuesta(){
        idrespuesta= UUID.randomUUID().toString();
    }

    public Respuesta(@NonNull String idpregunta, String respuesta, int estado) {
        idrespuesta= UUID.randomUUID().toString();
        this.idpregunta = idpregunta;
        this.respuesta = respuesta;
        this.estado = estado;
    }

    @NonNull
    public String getIdrespuesta(){
        return idrespuesta;
    }

    public void setIdrespuesta(@NonNull String id){
        idrespuesta=id;
    }

    @NonNull
    public String getIdpregunta(){
        return idpregunta;
    }

    public void setIdpregunta(@NonNull String id){
        idpregunta=id;
    }

    public String getRespuesta(){
        return respuesta;
    }

    public void setRespuesta(String answer) {
        respuesta = answer;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int state) {
        estado = state;
    }

}
