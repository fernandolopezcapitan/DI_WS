package com.salesianostriana.dam.di.aroundme.grid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.salesianostriana.dam.di.aroundme.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by flopez on 29/11/2015.
 */
public class AdapterAvatar extends ArrayAdapter<Avatar> {

    private final Context context;
    private final ArrayList<Avatar> values;

    public AdapterAvatar(Context context, ArrayList<Avatar> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutAppAInyectar = inflater.inflate(R.layout.grid_item_avatar, parent, false);

        // Busco en el layout los elementos a modificar
        ImageView icono = (ImageView) layoutAppAInyectar.findViewById(R.id.imageViewIcono);
        TextView nombreTextView = (TextView) layoutAppAInyectar.findViewById(R.id.textViewNombre);

        // Para poder llenar los elementos del Layout de contenido, necesito obtener
        // los datos del alumno que estoy recorriendo en esta iteración
        Avatar avatarActual = values.get(position);

        nombreTextView.setText(avatarActual.getNombre());
        Picasso.with(context).load(avatarActual.getUrl_avatar()).into(icono);

        return layoutAppAInyectar;
    }
}
