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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

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
            case R.id.llamar:
                // Lanzar Toast con alumno a editar
                Toast.makeText(MainActivity.this, ejercicioSeleccionado,Toast.LENGTH_SHORT).show();
                return true;
            case R.id.compartir:
                // Lanzar un Intent implícito
                // que permita compartir por Whatsapp
                // el nombre del alumno seleccionado
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
