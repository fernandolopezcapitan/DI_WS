package com.salesianostriana.dam.di.listviewcustom_listaclase;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DulcesAdapter extends ArrayAdapter<Dulces>{
    private final Context context;
    private final ArrayList<Dulces> values;

    public DulcesAdapter(Context context, ArrayList<Alumno> values) {
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
        // para un Alumno de la lista >>> R.layout.list_item_alumno
        View layoutDulcesAInyectar = inflater.inflate(R.layout.list_item_dulces, parent, false);

        // Busco en el layout los elementos a modificar
        ImageView iconoPagado = (ImageView) layoutAlumnoAInyectar.findViewById(R.id.imageViewPagado);
        TextView nombreApTextView = (TextView) layoutAlumnoAInyectar.findViewById(R.id.textViewNombreAp);
        TextView telefonoTextView = (TextView) layoutAlumnoAInyectar.findViewById(R.id.textViewTelefono);

        // Para poder llenar los elementos del Layout de contenido, necesito obtener
        // los datos del alumno que estoy recorriendo en esta iteración
        Alumno alumnoActual = values.get(position);

        if(alumnoActual.isPagado()) {
            iconoPagado.setImageResource(R.drawable.ic_pagado);
        } else {
            iconoPagado.setImageResource(R.drawable.ic_no_pagado);
        }

        nombreApTextView.setText(alumnoActual.getNombre() + " " + alumnoActual.getApellidos());
        telefonoTextView.setText(String.valueOf(alumnoActual.getTelefono()));

        return layoutAlumnoAInyectar;
    }

}
