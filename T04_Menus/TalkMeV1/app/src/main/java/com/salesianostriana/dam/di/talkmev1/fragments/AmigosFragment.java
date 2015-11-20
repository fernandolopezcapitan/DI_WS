package com.salesianostriana.dam.di.talkmev1.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salesianostriana.dam.di.talkmev1.R;
import com.salesianostriana.dam.di.talkmev1.adapters.AmigosAdapter;
import com.salesianostriana.dam.di.talkmev1.models.AmigosItem;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AmigosFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<AmigosItem> amigos;


    public AmigosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_amigos, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        amigos = new ArrayList();
        amigos.add(new AmigosItem("pepe"));
        amigos.add(new AmigosItem("luisma"));
        amigos.add(new AmigosItem("noe"));

        // specify an adapter (see also next example)
        mAdapter = new AmigosAdapter(amigos);
        mRecyclerView.setAdapter(mAdapter);

        return v;

        /*Desde aqui
        View v = inflater.inflate(R.layout.fragment_pronostico, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        new GetDataTask().execute();
        return v;
        //////hasta aaqui*/
    }


}
