package com.example.quizgame;

import android.os.Bundle;
import android.widget.RadioButton;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ScoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radiomayor:
                if (checked)
                    Toast.makeText(getApplicationContext(),"ORDEN MAYOR",Toast.LENGTH_LONG).show();
                    break;
            case R.id.radiomenor:
                if (checked)
                    Toast.makeText(getApplicationContext(),"ORDEN MENOR",Toast.LENGTH_LONG).show();
                    break;
        }
    }
}
