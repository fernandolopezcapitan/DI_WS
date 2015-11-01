package com.salesianostriana.di.lopez_capitan_fernando_examendi;

import android.content.Context;
import android.view.*;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by flopez on 30/10/2015.
 */

public class MenuAdapter extends ArrayAdapter<ItemMenu> {
    private final Context context;
    private final ArrayList<ItemMenu> values;


    public MenuAdapter(Context context, ArrayList<ItemMenu> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutAlumnoAInyectar = inflater.inflate(R.layout.grid_item_menu, parent, false);



        // Busco en el layout los elementos a modificar
        TextView icono = (TextView) layoutAlumnoAInyectar.findViewById(R.id.imageViewIcono);

        // Para poder llenar los elementos del Layout de contenido, necesito obtener
        // los datos del alumno que estoy recorriendo en esta iteración
        ItemMenu menuActual = values.get(position);

        menuActual.setT
        nombreTextView.setText(appActual.getNombre());
        icono.setImageResource(appActual.getIcono());

        ItemMenu menuActual = values.get(position);

        // Modificaciones a realizar en el layout...

        return layoutAlumnoAInyectar;
    }
}
