package com.miempresa.ejemplofragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdopcionActivity extends AppCompatActivity {

    Button btnAtras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopcion);
        btnAtras = findViewById(R.id.button2);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();




        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ListaMascotas listaMascotas = ListaMascotas.getInstance(new String[]{"Mascota 1", "mascota 2", "mascota 3", "Mascota 4"}, 2);
                transaction.add(R.id.container,listaMascotas);
                transaction.commit();


            }
        });

    }
}