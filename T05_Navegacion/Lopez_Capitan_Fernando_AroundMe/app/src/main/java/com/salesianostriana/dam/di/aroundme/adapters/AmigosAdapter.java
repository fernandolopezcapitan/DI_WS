package com.salesianostriana.dam.di.aroundme.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.salesianostriana.dam.di.aroundme.R;
import com.salesianostriana.dam.di.aroundme.activities.AvatarActivity;
import com.salesianostriana.dam.di.aroundme.activities.MensajeActivity;
import com.salesianostriana.dam.di.aroundme.models.AmigosItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by flopez on 19/11/2015.
 */
public class AmigosAdapter extends RecyclerView.Adapter<AmigosAdapter.AmigosViewHolder> {
    private ArrayList<AmigosItem> mDataset;
    Context contexto;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class AmigosViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView amigos;
        public ImageButton enviar;
        public ImageView avatar;


        public AmigosViewHolder(View v) {

            super(v);
            amigos = (TextView)v.findViewById(R.id.tv_usuario);
            enviar = (ImageButton)v.findViewById(R.id.img_enviar);
            avatar = (ImageView) v.findViewById(R.id.imageViewAvatarAmigos);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AmigosAdapter(ArrayList<AmigosItem> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AmigosViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item_amigos, parent, false);
        // set the view's size, margins, paddings and layout parameters
        contexto = v.getContext();
        AmigosViewHolder vh = new AmigosViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(AmigosViewHolder holder, final int position) {

        // Recoger en el OnCreate del MandarMensaje el extra "amigos"
        holder.amigos.setText(mDataset.get(position).getAmigos());
        holder.enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(contexto, MensajeActivity.class);
                String nombre = mDataset.get(position).getAmigos();
                i.putExtra("destinatario", nombre);
                (contexto).startActivity(i);
            }
        });
        Picasso.with(contexto).load(AvatarActivity.URL_AVATAR(mDataset.get(position).getAvatar())).into(holder.avatar);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
