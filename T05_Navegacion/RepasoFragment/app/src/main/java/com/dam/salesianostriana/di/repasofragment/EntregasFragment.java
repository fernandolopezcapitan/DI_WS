package com.dam.salesianostriana.di.repasofragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class EntregasFragment extends Fragment {

    TextView tv;

    public EntregasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_entregas, container, false);

        tv = (TextView) v.findViewById(R.id.tvEntregas);

        Bundle extras = getArguments();
        String nombre="";
        if(extras!=null){
            nombre =  extras.getString("nombre");
            tv.setText(nombre);
        }

        return v;
    }

}
