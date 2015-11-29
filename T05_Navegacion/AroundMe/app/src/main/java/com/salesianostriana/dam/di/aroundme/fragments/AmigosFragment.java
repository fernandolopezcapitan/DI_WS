package com.salesianostriana.dam.di.aroundme.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salesianostriana.dam.di.aroundme.R;
import com.salesianostriana.dam.di.aroundme.adapters.AmigosAdapter;
import com.salesianostriana.dam.di.aroundme.models.AmigosItem;
import com.salesianostriana.dam.di.aroundme.services.AmigosAsyncTask;

import java.util.ArrayList;

/**
 * Created by flopez on 29/11/2015.
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

        //new AsyntTask
        new AmigosAsyncTask().execute();
        //new GcmRegistrationAsyncTask(LoginActivity.this).execute(nick_name.getText().toString());

        // specify an adapter (see also next example)
        mAdapter = new AmigosAdapter(amigos);
        mRecyclerView.setAdapter(mAdapter);

        return v;

    }
}
