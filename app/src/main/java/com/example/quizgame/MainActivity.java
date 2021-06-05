package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Contador counter;
    TextView texto;
    int seconds=60,minutes=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView) findViewById(R.id.temporizador);
        counter = new Contador(120000,1000);

        counter.start();
    }

    public void end(){
        texto.setText("Se acabo el tiempo");
    }


    public void timer(){

        if (seconds>9)
        {
            texto.setText("Tiempo restante 00:0"+minutes+":"+String.valueOf(seconds));
        }
        else {
            texto.setText("Tiempo restante 00:0"+minutes+":0"+String.valueOf(seconds));
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