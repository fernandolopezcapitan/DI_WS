package com.salesianostriana.dam.di.listviewcustom_listaclase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AppAdapter extends ArrayAdapter<App> {
    private final Context context;
    private final ArrayList<App> values;


    public AppAdapter(Context context, ArrayList<App> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutAppAInyectar = inflater.inflate(R.layout.grid_item_alumno, parent, false);

        // Busco en el layout los elementos a modificar
        ImageView icono = (ImageView) layoutAppAInyectar.findViewById(R.id.imageViewIcono);
        TextView nombreTextView = (TextView) layoutAppAInyectar.findViewById(R.id.textViewNombre);

        // Para poder llenar los elementos del Layout de contenido, necesito obtener
        // los datos del alumno que estoy recorriendo en esta iteración
        App appActual = values.get(position);

        nombreTextView.setText(appActual.getNombre());
        icono.setImageResource(appActual.getIcono());

        return layoutAppAInyectar;
    }
}
