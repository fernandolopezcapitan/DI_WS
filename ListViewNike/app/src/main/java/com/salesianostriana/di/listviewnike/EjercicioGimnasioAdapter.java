package com.salesianostriana.di.listviewnike;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EjercicioGimnasioAdapter extends ArrayAdapter<EjercicioGimnasio> {
    private final Context context;
    private final ArrayList<EjercicioGimnasio> values;

    public EjercicioGimnasioAdapter(Context context, ArrayList<EjercicioGimnasio> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // La siguiente línea de código recibe como parámetro el layout
        // que he diseñado para un elemento del ListView, en este caso
        View gimnasioAInyectar = inflater.inflate(R.layout.list_view_nike, parent, false);

        // Busco en el layout los elementos a modificar
        TextView nombreTextView = (TextView) gimnasioAInyectar.findViewById(R.id.textViewNombre);
        ImageView tiempoTextView = (ImageView) gimnasioAInyectar.findViewById(R.id.imageViewTimer);

        // Para poder llenar los elementos del Layout de contenido, necesito obtener
        // los datos del alumno que estoy recorriendo en esta iteración
        EjercicioGimnasio ejercicioActual = values.get(position);

        if(position %2 == 0)
            gimnasioAInyectar.setBackgroundColor(android.graphics.Color.rgb(200,200,200));

/**
 * Continuar........
 */
        nombreTextView.setText(ejercicioActual.getNombre());
        tiempoTextView.setText(ejercicioActual.getPeso());
        precioTextView.setText(String.valueOf(ejercicioActual.getPrecio())+" euros");

        return gimnasioAInyectar;
    }

}
