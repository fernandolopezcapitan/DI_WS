package com.salesianostriana.dam.di.e05_reciclerview;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CiudadAdapter extends RecyclerView.Adapter<CiudadAdapter.ViewHolder> {
    //private String[] mDataset;
    private ArrayList<ItemCiudad> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagenCiudad;
        public TextView nombreCiudadTextView;
        public TextView habitantesTextView;
        public ImageView aeropuerto;
        public RatingBar puntuacion;

        public ViewHolder(View v) {
            super(v);

            imagenCiudad = (ImageView)v.findViewById(R.id.imagen_ciudad);
            nombreCiudadTextView = (TextView)v.findViewById(R.id.nombre_ciudad);
            habitantesTextView = (TextView)v.findViewById(R.id.habitantes_ciudad);
            aeropuerto = (ImageView)v.findViewById(R.id.aeropuerto);
            puntuacion = (RatingBar)v.findViewById(R.id.ratingBar);
        }
    }
    // Provide a suitable constructor (depends on the kind of dataset)
    public CiudadAdapter(ArrayList<ItemCiudad> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public CiudadAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create a new view
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item_ciudad, viewGroup, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CiudadAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.imagenCiudad.setImageResource(mDataset.get(position).getImagen());
        holder.nombreCiudadTextView.setText(mDataset.get(position).getCiudad());
        holder.habitantesTextView.setText(String.valueOf(mDataset.get(position).getHabitantes())+" hab.");
        holder.aeropuerto.setImageResource(mDataset.get(position).isAeropuerto());
        holder.puntuacion.setRating(mDataset.get(position).getPuntuacion());
    }

    @Override
    public int getItemCount()  {
        return mDataset.size();
    }
}
