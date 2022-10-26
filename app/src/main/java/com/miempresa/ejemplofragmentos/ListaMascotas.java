package com.miempresa.ejemplofragmentos;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListaMascotas extends Fragment {

    public ListaMascotas(){}
    public static String TAG = "Fragmento Lista";

    private AdaptadorMascotas adaptadorMascotas;

    public static ListaMascotas getInstance(String[] mascotas, int columns){
        ListaMascotas mascota = new ListaMascotas();
        Bundle arg = new Bundle();
        arg.putStringArray("datos", mascotas);
        arg.putInt("columns", columns);
        mascota.setArguments(arg);
        return mascota;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            adaptadorMascotas = new AdaptadorMascotas(savedInstanceState.getStringArray("datos"));
            Log.d("Prueba savedstate", adaptadorMascotas.toString() );

        }else if (getArguments() != null) {
            adaptadorMascotas = new AdaptadorMascotas(getArguments().getStringArray("datos"));
            Log.d("Prueba argumentos", adaptadorMascotas.toString() );

        }
        Log.d("Prueba oncreate", "Text" );
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragmentomascotas, container, false);
        RecyclerView recyclerView = vista.findViewById(R.id.reciclermascotas);
        if (savedInstanceState != null) {
            adaptadorMascotas = new AdaptadorMascotas(savedInstanceState.getStringArray("datos"));
            recyclerView.setAdapter(adaptadorMascotas);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }else if (getArguments() != null){
            adaptadorMascotas = new AdaptadorMascotas(getArguments().getStringArray("datos"));
            recyclerView.setAdapter(adaptadorMascotas);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }else{
            adaptadorMascotas = new AdaptadorMascotas(new String[]{"Mascota 1", "mascota 2", "mascota 3", "Mascota 4", "mascota 5", "mascota 6"});
            recyclerView.setAdapter(adaptadorMascotas);
            Log.d("prueba create view", "texto");
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
            Toast.makeText(getContext(),"no se pueden mostrar datos", Toast.LENGTH_SHORT).show();
        }
        return vista;

    }
}
