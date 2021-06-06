package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;
import androidx.room.Room;

import com.example.quizgame.database.QuizLab;
import com.example.quizgame.database.database;
import com.example.quizgame.schema.Pregunta;
import com.example.quizgame.schema.Respuesta;

import java.util.List;

public class formulariopreguntas extends AppCompatActivity {

    EditText etPregunta, etCantidadPun, etOp1, etOp2, etOp3, etOp4, est1, est2, est3, est4;
    Button btnGuardar;
    private QuizLab QuizLab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulariopreguntas);
        etPregunta = findViewById(R.id.txtpregunta);
        etCantidadPun = findViewById(R.id.txtcantpuntos);
        est1 = findViewById(R.id.Est1);
        est2 = findViewById(R.id.Est2);
        est3 = findViewById(R.id.Est3);
        est4 = findViewById(R.id.Est4);
        etOp1 = findViewById(R.id.txtop1);
        etOp2 = findViewById(R.id.txtop2);
        etOp3 = findViewById(R.id.txtop3);
        etOp4 = findViewById(R.id.txtop4);
        btnGuardar = findViewById(R.id.btnguardarpreg);
        QuizLab=QuizLab.get(this);



        btnGuardar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /*validacion de los campos */
                if(etPregunta.getText().toString().trim().isEmpty() || etPregunta.getText().toString().trim().length() == 0){
                    Toast.makeText(getApplicationContext(),"El campo pregunta esta vacio",Toast.LENGTH_LONG).show();
                }
                if(etCantidadPun.getText().toString().trim().isEmpty() || etCantidadPun.getText().toString().trim().length() == 0){
                    Toast.makeText(getApplicationContext(),"El campo cantidad puntos esta vacio",Toast.LENGTH_LONG).show();
                }
                if(etOp1.getText().toString().trim().isEmpty() || etOp1.getText().toString().trim().length() == 0
                        || etOp2.getText().toString().trim().isEmpty() || etOp2.getText().toString().trim().length() == 0
                        || etOp3.getText().toString().trim().isEmpty() || etOp3.getText().toString().trim().length() == 0
                        || etOp4.getText().toString().trim().isEmpty() || etOp4.getText().toString().trim().length() == 0){
                    Toast.makeText(getApplicationContext(),"Un campo Opción esta vacio",Toast.LENGTH_LONG).show();
                }
                if(est1.getText().toString().trim().isEmpty() || est1.getText().toString().trim().length() == 0
                        || est2.getText().toString().trim().isEmpty() || est2.getText().toString().trim().length() == 0
                        || est3.getText().toString().trim().isEmpty() || est3.getText().toString().trim().length() == 0
                        || est4.getText().toString().trim().isEmpty() || est4.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), "El campo verdadero ó falso esta vacio", Toast.LENGTH_LONG).show();
                }
                else{
                    int sum = Integer.parseInt(est1.getText().toString()) + Integer.parseInt(est2.getText().toString()) + Integer.parseInt(est3.getText().toString()) + Integer.parseInt(est4.getText().toString());
                    if (sum == 1) {
                        // insertar pregunta
                        Pregunta pregunta = new Pregunta(etPregunta.getText().toString(), Integer.parseInt(etCantidadPun.getText().toString()));
                        QuizLab.addPregunta(pregunta);
                        //insertar opciones de respuesta
                        List<Pregunta> preguntas = QuizLab.getPreguntas();
                        Respuesta respuesta = new Respuesta(pregunta.getIdpregunta(), etOp1.getText().toString(), Integer.parseInt(est1.getText().toString()));
                        QuizLab.addRespuesta(respuesta);
                        respuesta = new Respuesta(pregunta.getIdpregunta(), etOp2.getText().toString(), Integer.parseInt(est2.getText().toString()));
                        QuizLab.addRespuesta(respuesta);
                        respuesta = new Respuesta(pregunta.getIdpregunta(), etOp3.getText().toString(), Integer.parseInt(est3.getText().toString()));
                        QuizLab.addRespuesta(respuesta);
                        respuesta = new Respuesta(pregunta.getIdpregunta(), etOp4.getText().toString(), Integer.parseInt(est4.getText().toString()));
                        QuizLab.addRespuesta(respuesta);
                        List<Respuesta> respuestas = QuizLab.getRespuestas();
                        /*limpiamos los valores */
                        etPregunta.setText("");
                        etCantidadPun.setText("");
                        etOp1.setText("");
                        etOp2.setText("");
                        etOp3.setText("");
                        etOp4.setText("");
                        est1.setText("");
                        est2.setText("");
                        est3.setText("");
                        est4.setText("");
                        Toast.makeText(getApplicationContext(), "Pregunta Guardada Correctamente", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Error solo puede haber un valor verdadero.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    public void BotonIrAtras(View vista){
        Intent intent= new Intent (this, pantallabienvenida.class);
        startActivity(intent);
    }


}