package com.salesianostriana.dam.di.listviewcustom_listaclase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView)findViewById(R.id.listView);


        final ArrayList<Dulces> listadoDulces = new ArrayList<Dulces>();
        listadoDulces.add(new Dulces("Hojaldres","300 g",4.50));
        listadoDulces.add(new Dulces("Empiñonadas","220 g", 3.80));
        listadoDulces.add(new Dulces("Bizcochadas","400 g", 3.75));
        listadoDulces.add(new Dulces("Cortadillos","500 g", 6.25));
        listadoDulces.add(new Dulces("Mantecados","950 g", 8.90));
        listadoDulces.add(new Dulces("Bombones","180 g", 4.20));

        final DulcesAdapter adaptador = new DulcesAdapter(this,listadoDulces);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dulces dulceSeleccionado = listadoDulces.get(position);

                adaptador.notifyDataSetChanged();
            }
        });

    }
}
