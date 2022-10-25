package com.miempresa.ejemplofragmentos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import org.jetbrains.annotations.NotNull;

public class DialogoEjemplo extends DialogFragment {

    public static String TAG = "Dialog Ejemplo";

    @NotNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        return new AlertDialog.Builder(requireContext())
                .setMessage("Desea adoptar la mascota")
                .setPositiveButton("Si", (dialog ,which)->{
                    Intent i = new Intent(getContext(),AdopcionActivity.class);
                    startActivity(i);
                    dialog.dismiss();
                })
                .setNegativeButton("No", (dialog ,which)->{
                    dialog.dismiss();
                })
                .create();
    }

}
