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

    public DulcesAdapter(Context context, ArrayList<Dulces> values) {
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
        View layoutDulcesAInyectar = inflater.inflate(R.layout.list_item_dulces, parent, false);

        // Busco en el layout los elementos a modificar
        TextView nombreTextView = (TextView) layoutDulcesAInyectar.findViewById(R.id.textViewNombre);
        TextView pesoTextView = (TextView) layoutDulcesAInyectar.findViewById(R.id.textViewPeso);
        TextView precioTextView = (TextView) layoutDulcesAInyectar.findViewById(R.id.textViewPrecio);

        // Para poder llenar los elementos del Layout de contenido, necesito obtener
        // los datos del alumno que estoy recorriendo en esta iteración
        Dulces dulceActual = values.get(position);

        if(position %2 == 0)
            layoutDulcesAInyectar.setBackgroundColor(android.graphics.Color.rgb(200,200,200));


        nombreTextView.setText(dulceActual.getNombre());
        pesoTextView.setText(dulceActual.getPeso());
        precioTextView.setText(String.valueOf(dulceActual.getPrecio())+" euros");

        return layoutDulcesAInyectar;
    }

}
