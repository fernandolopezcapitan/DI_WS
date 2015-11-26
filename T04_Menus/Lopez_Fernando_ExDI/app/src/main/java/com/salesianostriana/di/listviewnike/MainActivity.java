package com.salesianostriana.di.listviewnike;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    ArrayList<EjercicioGimnasio> listado= null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView)findViewById(R.id.listView);


        listado = new ArrayList<EjercicioGimnasio>();


        listado.add(new EjercicioGimnasio("SWEAT + SHAPE",R.drawable.min30));
        listado.add(new EjercicioGimnasio("SLIM CHANCE",R.drawable.min30));
        listado.add(new EjercicioGimnasio("FIGHTER FIT",R.drawable.min15));
        listado.add(new EjercicioGimnasio("JUMP START",R.drawable.min30));
        listado.add(new EjercicioGimnasio("HURRICANE",R.drawable.min45));
        listado.add(new EjercicioGimnasio("CRUNCH + BURN",R.drawable.min45));
        listado.add(new EjercicioGimnasio("CARDIO SURGE", R.drawable.min45));

        final EjercicioGimnasioAdapter adaptador = new EjercicioGimnasioAdapter(this,listado);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EjercicioGimnasio ejercicioSeleccionado = listado.get(position);

                adaptador.notifyDataSetChanged();

            }
        });
        // IMPORTANTE!!!!!!!
        // darle evento a la pulsación larga
        registerForContextMenu(lista);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        String mensaje = "";
        switch(id) {
            case R.id.add: mensaje = "Añadir";
                break;
            case R.id.buscar: mensaje = "Buscar";
                break;
        }

        Toast.makeText(this, "Barra de menú: "+mensaje, Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        AdapterView.AdapterContextMenuInfo info;
        try {
            // Casts the incoming data object into the type for AdapterView objects.
            info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        } catch (ClassCastException e) {
            // If the menu object can't be cast, logs an error.
            Log.e("TAG", "bad menuInfo", e);
            return;
        }

        String ejercicioSeleccionado = listado.get(info.position).getNombre();

        menu.setHeaderTitle(ejercicioSeleccionado);
        // Lo del icono puede que sea de la versión (quizás necesite android 1.5)
        menu.setHeaderIcon(android.R.drawable.stat_notify_sdcard);
        //menu.setHeaderIcon(R.drawable.ic_action_name);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String ejercicioSeleccionado = listado.get(info.position).getNombre();
        switch (item.getItemId()) {
            case R.id.editar:
                // Lanzar Toast
                Toast.makeText(MainActivity.this, "editar "+ejercicioSeleccionado,Toast.LENGTH_SHORT).show();
                return true;
            case R.id.eliminar:
                // Lanzar Toast
                Toast.makeText(MainActivity.this, "eliminar "+ejercicioSeleccionado,Toast.LENGTH_SHORT).show();
                return true;
            case R.id.compartir:
                // Lanzar un Intent implícito
                // que permita compartir
                Intent compartir = new Intent();
                compartir.setAction(Intent.ACTION_SEND);
                compartir.setType("text/plain");
                compartir.putExtra(Intent.EXTRA_TEXT, ejercicioSeleccionado);
                startActivity(compartir);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
