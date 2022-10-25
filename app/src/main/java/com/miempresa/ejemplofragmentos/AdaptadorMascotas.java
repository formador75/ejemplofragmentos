package com.miempresa.ejemplofragmentos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorMascotas extends RecyclerView.Adapter<AdaptadorMascotas.MyViewHolder> {

    private String[] datos;

    public AdaptadorMascotas(String[] datos){
        this.datos=datos;
    }

    @NonNull
    @Override
    public AdaptadorMascotas.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.text_row_item, parent, false);
        return new MyViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorMascotas.MyViewHolder holder, int position) {
        holder.getTextView().setText(datos[position]);
    }

    @Override
    public int getItemCount() {
        return datos.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }

        public TextView getTextView(){
            return textView;
        }
    }

}
