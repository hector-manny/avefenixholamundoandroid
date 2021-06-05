package com.example.quizgame.schema;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class PreguntaRespuesta {
        @Embedded
        public Pregunta pregunta;
        @Relation(
                parentColumn = "idpregunta",
                entityColumn = "idpregunta"
        )
        public List<Respuesta> respuestaList;
}
