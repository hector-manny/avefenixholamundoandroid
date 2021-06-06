package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quizgame.database.QuizLab;
import com.example.quizgame.schema.Pregunta;
import com.example.quizgame.schema.Usuario;
import java.util.List;

public class UserActivity extends AppCompatActivity {
    private QuizLab QuizLab;
    EditText txtusuario;
    Button btncontinuar;
    Usuario usuario;
    static int point = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        txtusuario= findViewById(R.id.txtusuario);
        btncontinuar = findViewById(R.id.btncontinuar);
        QuizLab=QuizLab.get(this);
        List<Usuario> usuarios =QuizLab.getUsuarios();

        btncontinuar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int a;
                if(txtusuario.getText().toString().trim().isEmpty() || txtusuario.getText().toString().trim().length() == 0){
                    Toast.makeText(getApplicationContext(),"El campo usuario esta vacio",Toast.LENGTH_LONG).show();
                }else{
                    point = point + 10;
                    usuario = new Usuario();
                    usuario.setNombre(txtusuario.getText().toString().trim().toLowerCase());
                    usuario.setCantidadRespuestas(0);
                    usuario.setPuntaje(point);
                    int count = QuizLab.getCount(usuario.getNombre());
                    if(count == 0){
                        QuizLab.addUsuario(usuario);
                        List<Usuario> usuarios=QuizLab.getUsuarios();
                        Toast.makeText(getApplicationContext(),"Usuario Guardado Correctamente",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"Error el usuario ya existe : " + usuario.getNombre(),Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}