package com.salesianostriana.di.prueba;

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

        final ArrayList<Fruta> listado = new ArrayList<Fruta>();
        listado.add(new Fruta(R.id.imageMarcado,"Pera", "A 1.05 euros el kilo",R.id.imageEstrella));
        listado.add(new Fruta(R.id.imageMarcado,"Manzana", "A 1.20 euros el kilo",R.id.imageEstrella));
        listado.add(new Fruta(R.id.imageMarcado,"Naranja", "A 1.35 euros el kilo",R.id.imageEstrella));
        listado.add(new Fruta(R.id.imageMarcado,"Sandía", "A 0.40 euros el kilo",R.id.imageEstrella));
        listado.add(new Fruta(R.id.imageMarcado,"Melón", "A 0.50 euros el kilo",R.id.imageEstrella));
        listado.add(new Fruta(R.id.imageMarcado,"Uvas", "A 1.95 euros el kilo",R.id.imageEstrella));
        listado.add(new Fruta(R.id.imageMarcado,"Limones", "A 2.05 euros el kilo",R.id.imageEstrella));

        final FrutaAdapter adaptador = new FrutaAdapter(this,R.layout.list_item_pr,listado);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruta frutaSeleccionada = listado.get(position);

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
