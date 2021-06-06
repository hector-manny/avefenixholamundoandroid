package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import com.example.quizgame.database.QuizLab;
import com.example.quizgame.schema.Pregunta;
import com.example.quizgame.schema.Respuesta;
import com.example.quizgame.schema.Usuario;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button opc1,opc2,opc3,opc4;
    TextView temporizador,puntaje,enunciado;
    Contador counter;
    int seconds=60,minutes=1;

    private QuizLab QuizLab;

    private Usuario usuario;
    private Pregunta pregunta;
    private Respuesta respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enunciado=findViewById(R.id.pregunta);
        puntaje=findViewById(R.id.puntaje);
        temporizador=findViewById(R.id.temporizador);

        opc1=findViewById(R.id.opcion1);
        opc2=findViewById(R.id.opcion2);
        opc3=findViewById(R.id.opcion3);
        opc4=findViewById(R.id.opcion4);

        QuizLab=QuizLab.get(this);

        pregunta=new Pregunta();

        /*pregunta.setPregunta("Cual es la flor nacional");
        pregunta.setValorPuntos(10);
        QuizLab.addPregunta(pregunta);*/


        List<Pregunta> preguntas=QuizLab.getPreguntas();
        if (preguntas.size()>0){
            pregunta= preguntas.get(0);
            enunciado.setText(pregunta.getPregunta());
        }
        if(preguntas.size()<=0){
            enunciado.setText("Lo sentimos no se han encontrado preguntas en la base de datos");
        }

        temporizador = (TextView) findViewById(R.id.temporizador);
        counter = new Contador(120000,1000);

        counter.start();
    }

    public void end(){
        temporizador.setText("Se acabo el tiempo");
    }


    public void timer(){

        if (seconds>9)
        {
            temporizador.setText("Tiempo restante 00:0"+minutes+":"+String.valueOf(seconds));
        }
        else {
            temporizador.setText("Tiempo restante 00:0"+minutes+":0"+String.valueOf(seconds));
        }
        if (seconds==0)
        {
            seconds=60;
            minutes--;
        }
        seconds--;
    }

    public class Contador extends CountDownTimer {

        public Contador(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            end();
        }

        @Override
        public void onTick(long millisUntilFinished) {
            timer();
        }

    }
}