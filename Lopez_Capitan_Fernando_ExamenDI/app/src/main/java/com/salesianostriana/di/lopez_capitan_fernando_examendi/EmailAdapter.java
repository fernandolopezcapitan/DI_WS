package com.salesianostriana.di.lopez_capitan_fernando_examendi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by flopez on 30/10/2015.
 */

public class EmailAdapter extends ArrayAdapter<EmailItem> {
    private final Context context;
    private final ArrayList<EmailItem> values;


    public EmailAdapter(Context context, ArrayList<EmailItem> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutAlumnoAInyectar = inflater.inflate(R.layout.list_item_email, parent, false);



        EmailItem emailActual = values.get(position);

        // Modificaciones a realizar en el layout...

        return layoutAlumnoAInyectar;
    }
}