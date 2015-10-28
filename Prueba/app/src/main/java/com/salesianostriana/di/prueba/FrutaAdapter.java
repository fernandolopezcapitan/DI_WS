package com.salesianostriana.di.prueba;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by flopez on 28/10/2015.
 */
public class FrutaAdapter extends ArrayAdapter<Fruta> {
    private List<Fruta> frutas;
    Activity context;
    int layoutMolde;

    public FrutaAdapter(Activity context, int layout,List<Fruta> listadoFrutas) {
        super(context, layout, listadoFrutas);
        frutas = listadoFrutas;
        this.context = context;
        this.layoutMolde = layout;
        }

    @Override
    public View getView(int position, View moldeVacio, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        moldeVacio = inflater.inflate(layoutMolde, null);
// Si optamos por eliminar del constructor del Adaptador el
// parámetro del layout que utilizamos como molde, podríamos
// hacerlo de la siguiente manera:
//convertView = inflater.inflate(R.layout.list_item_fruta, null);
        Fruta frutaActual = frutas.get(position);

// Rescato los elementos del molde para modificarlos con el nombre y el icono de la fruta actual
        ImageView marcado = (ImageView) moldeVacio.findViewById(R.id.imageMarcado);
        TextView nombreFruta = (TextView) moldeVacio.findViewById(R.id.textView);
        TextView comentariosFruta = (TextView) moldeVacio.findViewById(R.id.textView2);
        ImageView estrella = (ImageView) moldeVacio.findViewById(R.id.imageEstrella);



        marcado.setImageResource(frutaActual.getMarcado());
        nombreFruta.setText(frutaActual.getNombre());
        comentariosFruta.setText(frutaActual.getComentarios());
        estrella.setImageResource(frutaActual.getEstrella());
            return moldeVacio;

    }
}
