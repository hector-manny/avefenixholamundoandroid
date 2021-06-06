package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;
import com.example.quizgame.adapter.AdapterScore;
import com.example.quizgame.database.QuizLab;
import com.example.quizgame.schema.Usuario;
import java.util.ArrayList;
import java.util.List;

public class ScoresActivity extends AppCompatActivity {

    ArrayList<String> listDatos;
    RecyclerView recycler;
    private QuizLab QuizLab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        QuizLab=QuizLab.get(this);
        List<Usuario> usuarios =QuizLab.getUsuariosDesPuntaje();

        recycler = (RecyclerView) findViewById(R.id.recyclerId);

        // Nuestro RecyclerView usará un linear layout manager
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        listDatos = new  ArrayList<String>();

        // DataSet , API , WEB SERVICE , ETC. -> RETROFIT
        for (int i=0; i < usuarios.size(); i++){
            listDatos.add(usuarios.get(i).getNombre() + "                                                          "  + usuarios.get(i).getPuntaje());
        }

        // Asociamos un adapter
        AdapterScore adapter = new AdapterScore(listDatos);
        recycler.setAdapter(adapter);
    }

    public void onRadioButtonClicked(View view) {
        List<Usuario> usuarios = null;
        listDatos = new  ArrayList<String>();
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radiomayor:
                if (checked)
                    Toast.makeText(getApplicationContext(),"ORDEN MAYOR",Toast.LENGTH_LONG).show();
                usuarios =QuizLab.getUsuariosDesPuntaje();
                break;
            case R.id.radiomenor:
                if (checked)
                    Toast.makeText(getApplicationContext(),"ORDEN MENOR",Toast.LENGTH_LONG).show();
                usuarios =QuizLab.getUsuariosAscPuntaje();
                break;
        }
        // DataSet , API , WEB SERVICE , ETC. -> RETROFIT
        for (int i=0; i < usuarios.size(); i++){
            /*
            int sizename= usuarios.get(i).getNombre().length();
            10
            20
            17
            15
             */
            listDatos.add(usuarios.get(i).getNombre() + "                                                          "  + usuarios.get(i).getPuntaje());
        }
        // Asociamos un adapter
        AdapterScore adapter = new AdapterScore(listDatos);
        recycler.setAdapter(adapter);
    }
}
