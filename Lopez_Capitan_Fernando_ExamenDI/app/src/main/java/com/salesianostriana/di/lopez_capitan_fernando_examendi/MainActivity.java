package com.salesianostriana.di.lopez_capitan_fernando_examendi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView listaGridView;
    private ListView listaListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaGridView = (GridView)findViewById(R.id.gridView);

        final ArrayList<ItemMenu> listadoMenu = new ArrayList<ItemMenu>();
        listadoMenu.add(new ItemMenu(R.drawable.menu1));
        listadoMenu.add(new ItemMenu(R.drawable.menu2));
        listadoMenu.add(new ItemMenu(R.drawable.menu3));

        final MenuAdapter adaptador1 = new MenuAdapter(this, listadoMenu);

        listaGridView.setAdapter(adaptador1);

        listaGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemMenu menuSeleccionado = listadoMenu.get(position);
                adaptador1.notifyDataSetChanged();
            }
        });
        listaListView = (ListView)findViewById(R.id.listView);

        final ArrayList<EmailItem> listadoEmail = new ArrayList<EmailItem>();
        listadoEmail.add(new EmailItem("L", "Los escarabajos", "Un viaje mágico"));
        listadoEmail.add(new EmailItem("T", "TIBCO Jaspersoft", "Our Apologies"));
        listadoEmail.add(new EmailItem("K", "Klout", "Your Klout Score went up"));

        final EmailAdapter adaptador2 = new EmailAdapter(this, listadoEmail);

        listaListView.setAdapter(adaptador2);

        listaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EmailItem emailSeleccionado = listadoEmail.get(position);
                adaptador2.notifyDataSetChanged();
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
