package com.miempresa.ejemplofragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListaMascotas extends Fragment {

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
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.activity_adopcion, container, false);
        RecyclerView recyclerView = vista.findViewById(R.id.reciclermascotas);
        adaptadorMascotas = new AdaptadorMascotas(savedInstanceState.getStringArray("datos"));
        recyclerView.setAdapter(adaptadorMascotas);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        return vista;

    }
}
