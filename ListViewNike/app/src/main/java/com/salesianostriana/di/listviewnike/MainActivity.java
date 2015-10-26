package com.salesianostriana.di.listviewnike;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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


        final ArrayList<EjercicioGimnasio> listado = new ArrayList<EjercicioGimnasio>();
        listado.add(new EjercicioGimnasio("SWEAT + SHAPE",R.drawable.min30));
        listado.add(new EjercicioGimnasio("SLIM CHANCE",R.drawable.min30));
        listado.add(new EjercicioGimnasio("FIGHTER FIT",R.drawable.min15));
        listado.add(new EjercicioGimnasio("JUMP START",R.drawable.min30));
        listado.add(new EjercicioGimnasio("HURRICANE",R.drawable.min45));
        listado.add(new EjercicioGimnasio("CRUNCH + BURN",R.drawable.min45));
        listado.add(new EjercicioGimnasio("CARDIO SURGE",R.drawable.min45));

        final EjercicioGimnasioAdapter adaptador = new EjercicioGimnasioAdapter(this,listado);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EjercicioGimnasio ejercicioSeleccionado = listado.get(position);

                adaptador.notifyDataSetChanged();


            }
        });
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
}
