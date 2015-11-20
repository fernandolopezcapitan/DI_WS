package com.salesianostriana.dam.di.talkmev1.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salesianostriana.dam.di.talkmev1.R;
import com.salesianostriana.dam.di.talkmev1.adapters.MensajesAdapter;
import com.salesianostriana.dam.di.talkmev1.models.AmigosItem;
import com.salesianostriana.dam.di.talkmev1.models.MensajesItem;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MensajesFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<MensajesItem> mensajes;


    public MensajesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mensajes, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mensajes = new ArrayList();
        mensajes.add(new MensajesItem("Luisma", "Hola soy lm",R.drawable.ic_recibido));
        mensajes.add(new MensajesItem("Pepe", "Un cafe??",R.drawable.ic_recibido));
        mensajes.add(new MensajesItem("Ale B", "illo, vente pa coria",R.drawable.ic_enviado));

        // specify an adapter (see also next example)
        mAdapter = new MensajesAdapter(mensajes);
        mRecyclerView.setAdapter(mAdapter);

        return v;
    }


}
