package com.salesianostriana.dam.di.listviewcustom_listaclase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (GridView)findViewById(R.id.gridView);

        final ArrayList<App> listadoApps = new ArrayList<App>();
        listadoApps.add(new App("CashTrack",R.drawable.ic_cashtrack));
        listadoApps.add(new App("Cocktail",R.drawable.ic_cocktailflow));
        listadoApps.add(new App("Currents",R.drawable.ic_currents));
        listadoApps.add(new App("DMD Pano",R.drawable.ic_dmdpano));
        listadoApps.add(new App("Dropbox",R.drawable.ic_dropbox));
        listadoApps.add(new App("Evernote",R.drawable.ic_evernote));
        listadoApps.add(new App("Facebook",R.drawable.ic_facebook));
        listadoApps.add(new App("Fancy",R.drawable.ic_fancy));
        listadoApps.add(new App("Gilt",R.drawable.ic_gilt));
        listadoApps.add(new App("Hello",R.drawable.ic_hello));
        listadoApps.add(new App("Instagram",R.drawable.ic_instagram));
        listadoApps.add(new App("Kobo",R.drawable.ic_kobo));
        listadoApps.add(new App("Lapse It",R.drawable.ic_lapseit));
        listadoApps.add(new App("Marvel",R.drawable.ic_marvelavenger));
        listadoApps.add(new App("Opera",R.drawable.ic_operamobile));
        listadoApps.add(new App("Pair",R.drawable.ic_pair));
        listadoApps.add(new App("Path",R.drawable.ic_path));
        listadoApps.add(new App("Pocket",R.drawable.ic_pocket));
        listadoApps.add(new App("Pulse",R.drawable.ic_pulse));
        listadoApps.add(new App("Reddionic",R.drawable.ic_reddionic));
        listadoApps.add(new App("runtastic",R.drawable.ic_runtastic));
        listadoApps.add(new App("Skitch",R.drawable.ic_skitch));
        listadoApps.add(new App("Streamzoo",R.drawable.ic_streamzoo));
        listadoApps.add(new App("Trip Journal",R.drawable.ic_tripjournal));
        listadoApps.add(new App("Twitter",R.drawable.ic_twitter));

        final AppAdapter adaptador = new AppAdapter(this, listadoApps);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                App appSeleccionado = listadoApps.get(position);

                //Solo si hay que actualizar el adaptador(el listado)
                adaptador.notifyDataSetChanged();
            }
        });

    }
}
