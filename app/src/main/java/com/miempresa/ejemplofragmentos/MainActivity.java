package com.miempresa.ejemplofragmentos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDialogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDialogo = findViewById(R.id.button);

        btnDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DialogoEjemplo().show(getSupportFragmentManager(), DialogoEjemplo.TAG);
            }
        });

    }
}