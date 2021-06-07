package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizgame.database.QuizLab;
import com.example.quizgame.schema.Pregunta;
import com.example.quizgame.schema.Respuesta;
import com.example.quizgame.schema.Usuario;
import com.example.quizgame.UserActivity;

import java.util.List;

public class QuizActivity extends AppCompatActivity {
    Button opc1,opc2,opc3,opc4;
    TextView temporizador,puntaje,enunciado;
    Contador counter;
    int seconds=60,minutes=1,ramdonselect=0,score=0,puntos=0, nQuestions =0;
    String idrandom="";

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



        /*pregunta=new Pregunta();
        pregunta.setPregunta("Cual es la flor nacional");
        pregunta.setValorPuntos(10);
        QuizLab.addPregunta(pregunta);*/

        /*pregunta=new Pregunta();
        pregunta.setPregunta("Eleija el nombre cientifico del Arbol Conacaste - Enterolobium cyclocarpum");
        pregunta.setValorPuntos(20);
        QuizLab.addPregunta(pregunta);*/

        /*pregunta=new Pregunta();
        pregunta.setPregunta("Eleija el nombre cientifico del Árbol siete camisas - Guapira witsbergeri");
        pregunta.setValorPuntos(10);
        QuizLab.addPregunta(pregunta);*/

        /*pregunta=new Pregunta();
        pregunta.setPregunta("Eleija el nombre cientifico Rana arborícola de ojos negros - Agalychnis moreletii");
        pregunta.setValorPuntos(5);
        QuizLab.addPregunta(pregunta);*/

        /*pregunta=preguntas.get(0);
        String q1=pregunta.getIdpregunta();

        respuesta=new Respuesta();
        respuesta.setEstado(1);
        respuesta.setRespuesta("Flor de Izote");
        respuesta.setIdpregunta(q1);
        QuizLab.addRespuesta(respuesta);

        respuesta=new Respuesta();
        respuesta.setEstado(0);
        respuesta.setRespuesta("Maquilishuat");
        respuesta.setIdpregunta(q1);
        QuizLab.addRespuesta(respuesta);

        respuesta=new Respuesta();
        respuesta.setEstado(0);
        respuesta.setRespuesta("Caña de Azúcar");
        respuesta.setIdpregunta(q1);
        QuizLab.addRespuesta(respuesta);

        respuesta=new Respuesta();
        respuesta.setEstado(0);
        respuesta.setRespuesta("Girasol");
        respuesta.setIdpregunta(q1);
        QuizLab.addRespuesta(respuesta);*/

        /*pregunta=preguntas.get(1);
        String q2=pregunta.getIdpregunta();

        respuesta=new Respuesta();
        respuesta.setEstado(0);
        respuesta.setRespuesta("Zea mays");
        respuesta.setIdpregunta(q2);
        QuizLab.addRespuesta(respuesta);

        respuesta=new Respuesta();
        respuesta.setEstado(1);
        respuesta.setRespuesta("Enterolobium cyclocarpum");
        respuesta.setIdpregunta(q2);
        QuizLab.addRespuesta(respuesta);

        respuesta=new Respuesta();
        respuesta.setEstado(0);
        respuesta.setRespuesta("Quercus");
        respuesta.setIdpregunta(q2);
        QuizLab.addRespuesta(respuesta);

        respuesta=new Respuesta();
        respuesta.setEstado(0);
        respuesta.setRespuesta("Tabebuia rosea");
        respuesta.setIdpregunta(q2);
        QuizLab.addRespuesta(respuesta);

        pregunta=preguntas.get(2);
        String q3 =pregunta.getIdpregunta();

        respuesta=new Respuesta();
        respuesta.setEstado(0);
        respuesta.setRespuesta("Phaseolus vulgaris");
        respuesta.setIdpregunta(q3);
        QuizLab.addRespuesta(respuesta);

        respuesta=new Respuesta();
        respuesta.setEstado(0);
        respuesta.setRespuesta("Spondias");
        respuesta.setIdpregunta(q3);
        QuizLab.addRespuesta(respuesta);

        respuesta=new Respuesta();
        respuesta.setEstado(0);
        respuesta.setRespuesta("Mangifera indica");
        respuesta.setIdpregunta(q3);
        QuizLab.addRespuesta(respuesta);

        respuesta=new Respuesta();
        respuesta.setEstado(1);
        respuesta.setRespuesta("Guapira witsbergeri");
        respuesta.setIdpregunta(q3);
        QuizLab.addRespuesta(respuesta);

        pregunta=preguntas.get(3);
        String q4 =pregunta.getIdpregunta();

        respuesta=new Respuesta();
        respuesta.setEstado(0);
        respuesta.setRespuesta("Persea americana");
        respuesta.setIdpregunta(q4);
        QuizLab.addRespuesta(respuesta);

        respuesta=new Respuesta();
        respuesta.setEstado(1);
        respuesta.setRespuesta("Agalychnis moreletii");
        respuesta.setIdpregunta(q4);
        QuizLab.addRespuesta(respuesta);

        respuesta=new Respuesta();
        respuesta.setEstado(0);
        respuesta.setRespuesta("Malus domestica");
        respuesta.setIdpregunta(q4);
        QuizLab.addRespuesta(respuesta);

        respuesta=new Respuesta();
        respuesta.setEstado(0);
        respuesta.setRespuesta("Cucumis melo");
        respuesta.setIdpregunta(q4);
        QuizLab.addRespuesta(respuesta);*/


        List<Pregunta> preguntas=QuizLab.getPreguntas();
        List<Respuesta> respuestas=QuizLab.getRespuestas();

        if (preguntas.size()>0){
            ramdonselect=(int)(Math.random()*preguntas.size()+1);
            while(ramdonselect>=preguntas.size()){
                ramdonselect=(int)(Math.random());
            }
            pregunta= preguntas.get(ramdonselect);
            enunciado.setText(pregunta.getPregunta());
            idrandom=pregunta.getIdpregunta();

            List<Respuesta> opciones=QuizLab.getOpciones(idrandom);
            opc1.setText(opciones.get(0).getRespuesta());
            opc2.setText(opciones.get(1).getRespuesta());
            opc3.setText(opciones.get(2).getRespuesta());
            opc4.setText(opciones.get(3).getRespuesta());

            nQuestions =1;

            opc1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    List<Respuesta> opciones=QuizLab.getOpciones(idrandom);
                    puntos=CheckAnswer(opciones.get(0).getEstado());
                    score=score+puntos;
                    puntaje.setText("Puntaje: "+score+" pts");

                    ramdonselect=(int)(Math.random()*preguntas.size()+1);
                    while(ramdonselect>=preguntas.size()){
                        ramdonselect=(int)(Math.random());
                    }
                    pregunta= preguntas.get(ramdonselect);
                    enunciado.setText(pregunta.getPregunta());
                    idrandom=pregunta.getIdpregunta();

                    opciones=QuizLab.getOpciones(idrandom);
                    opc1.setText(opciones.get(0).getRespuesta());
                    opc2.setText(opciones.get(1).getRespuesta());
                    opc3.setText(opciones.get(2).getRespuesta());
                    opc4.setText(opciones.get(3).getRespuesta());

                    nQuestions++;
                }
            });

            opc2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    List<Respuesta> opciones=QuizLab.getOpciones(idrandom);
                    puntos=CheckAnswer(opciones.get(1).getEstado());
                    score=score+puntos;
                    puntaje.setText("Puntaje: "+score+" pts");

                    ramdonselect=(int)(Math.random()*preguntas.size()+1);
                    while(ramdonselect>=preguntas.size()){
                        ramdonselect=(int)(Math.random());
                    }
                    pregunta= preguntas.get(ramdonselect);
                    enunciado.setText(pregunta.getPregunta());
                    idrandom=pregunta.getIdpregunta();

                    opciones=QuizLab.getOpciones(idrandom);
                    opc1.setText(opciones.get(0).getRespuesta());
                    opc2.setText(opciones.get(1).getRespuesta());
                    opc3.setText(opciones.get(2).getRespuesta());
                    opc4.setText(opciones.get(3).getRespuesta());

                    nQuestions++;
                }
            });

            opc3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    List<Respuesta> opciones=QuizLab.getOpciones(idrandom);
                    puntos=CheckAnswer(opciones.get(2).getEstado());
                    score=score+puntos;
                    puntaje.setText("Puntaje: "+score+" pts");

                    ramdonselect=(int)(Math.random()*preguntas.size()+1);
                    while(ramdonselect>=preguntas.size()){
                        ramdonselect=(int)(Math.random());
                    }
                    pregunta= preguntas.get(ramdonselect);
                    enunciado.setText(pregunta.getPregunta());
                    idrandom=pregunta.getIdpregunta();

                    opciones=QuizLab.getOpciones(idrandom);
                    opc1.setText(opciones.get(0).getRespuesta());
                    opc2.setText(opciones.get(1).getRespuesta());
                    opc3.setText(opciones.get(2).getRespuesta());
                    opc4.setText(opciones.get(3).getRespuesta());

                    nQuestions++;
                }
            });

            opc4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    List<Respuesta> opciones=QuizLab.getOpciones(idrandom);
                    puntos=CheckAnswer(opciones.get(3).getEstado());
                    score=score+puntos;
                    puntaje.setText("Puntaje: "+score+" pts");

                    ramdonselect=(int)(Math.random()*preguntas.size()+1);
                    while(ramdonselect>=preguntas.size()){
                        ramdonselect=(int)(Math.random());
                    }
                    pregunta= preguntas.get(ramdonselect);
                    enunciado.setText(pregunta.getPregunta());
                    idrandom=pregunta.getIdpregunta();

                    opciones=QuizLab.getOpciones(idrandom);
                    opc1.setText(opciones.get(0).getRespuesta());
                    opc2.setText(opciones.get(1).getRespuesta());
                    opc3.setText(opciones.get(2).getRespuesta());
                    opc4.setText(opciones.get(3).getRespuesta());

                    nQuestions++;
                }
            });

        }
        if(preguntas.size()<=0){
            enunciado.setText("Lo sentimos no se han encontrado preguntas en la base de datos");
        }

        temporizador = (TextView) findViewById(R.id.temporizador);
        counter = new Contador(120000,1000);

        counter.start();

    }//fin onCreate

    public int CheckAnswer(int estado){
        int puntos=0;

        if(estado ==1){
            puntos=pregunta.getValorPuntos();
        }
        if (estado ==0){
            puntos=0;
        }
        return puntos;
    }//Función para validar respuesta


    public void BotonTerminar(){
        Toast.makeText(getApplicationContext(),"Boton Terminar : " + usuario.getNombre(),Toast.LENGTH_LONG).show();
        Intent intent= new Intent (this, EndgameActivity.class);
        startActivity(intent);
    }

    public void end(int contador){
        temporizador.setText("Se acabó el tiempo\nPudiste responder "+contador+" preguntas.");
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

    public void guardarPuntaje(){
        Usuario usario = new Usuario();
        usuario.setIdusuario(UserActivity.idusuario);
        usuario.setNombre(UserActivity.nombre);
        usuario.setCantidadRespuestas(nQuestions);
        usuario.setPuntaje(score);
        QuizLab.updateUsuario(usuario);
    }

    public class Contador extends CountDownTimer {


        public Contador(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            end(nQuestions);
            guardarPuntaje();
        }

        @Override
        public void onTick(long millisUntilFinished) {
            timer();
        }

    }
}