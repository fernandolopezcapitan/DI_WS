package com.salesianostriana.dam.di.aroundme.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.salesianostriana.dam.di.aroundme.R;
import com.salesianostriana.dam.di.aroundme.models.MensajesItem;

import java.util.ArrayList;

/**
 * Created by flopez on 19/11/2015.
 */
public class MensajesAdapter extends RecyclerView.Adapter<MensajesAdapter.MensajesViewHolder>{
    private ArrayList<MensajesItem> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MensajesViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mensaje;
        public TextView remitente;
        public ImageView icono_enviado;

        public MensajesViewHolder(View v) {
            super(v);

            mensaje = (TextView) v.findViewById(R.id.tv_mensaje);
            remitente = (TextView) v.findViewById(R.id.tv_remitente);
            icono_enviado = (ImageView) v.findViewById(R.id.img_enviado);



        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MensajesAdapter(ArrayList<MensajesItem> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MensajesViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item_mensajes, parent, false);
        // set the view's size, margins, paddings and layout parameters


        MensajesViewHolder vh = new MensajesViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MensajesViewHolder holder, int position) {
        holder.mensaje.setText(mDataset.get(position).getMensaje());
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
