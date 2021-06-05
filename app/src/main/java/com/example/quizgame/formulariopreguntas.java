package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;
import androidx.room.Room;

public class formulariopreguntas extends AppCompatActivity {

    EditText etPregunta, etCantidadPun, etOp1, etOp2, etOp3, etOp4;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulariopreguntas);
        etPregunta = findViewById(R.id.txtpregunta);
        etCantidadPun = findViewById(R.id.txtcantpuntos);
        etOp1 = findViewById(R.id.txtop1);
        etOp2 = findViewById(R.id.txtop2);
        etOp3 = findViewById(R.id.txtop3);
        etOp4 = findViewById(R.id.txtop4);
        btnGuardar = findViewById(R.id.btnguardarpreg);

        btnGuardar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                
                Toast.makeText(getApplicationContext(),"Pregunta Guardada Correctamente",Toast.LENGTH_LONG).show();
            }
        });
    }


}