package com.salesianostriana.menucontextualactionbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    String[] alumnos;
    boolean[] seleccionados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // GESTIÓN LISTVIEW
        lista = (ListView)findViewById(R.id.listView);
        alumnos = new String[] {"Carlos","Diego","Luis","Jesús",
                "Fernando","Carlos","Diego","Luis","Jesús","Fernando"};

        seleccionados = new boolean[alumnos.length];

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,alumnos);

        lista.setAdapter(adaptador);

        // Transformamos la lista en un elemento de selección múltiple
        lista.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        // Asociar al ListView un Menú CAB (Contextual Action Bar)
        lista.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            Menu menuActual;



            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
                // Here you can do something when items are selected/de-selected,
                // such as update the title in the CAB

                seleccionados[position] = checked;
                mode.setTitle(String.valueOf(getNumSeleccionados()));

                //MenuItem infoItem = menuActual.findItem(R.id.borrar_todos);
                MenuItem infoItem = menuActual.findItem(R.id.info_item);
                if(getNumSeleccionados()>1) {
                    infoItem.setVisible(false);
                } else {
                    infoItem.setVisible(true);
                }

            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                // Respond to clicks on the actions in the CAB
                switch (item.getItemId()) {
                    case R.id.delete_items:
                        Toast.makeText(MainActivity.this,"Eliminar seleccionados",Toast.LENGTH_LONG).show();
                        mode.finish(); // Action picked, so close the CAB
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // Inflate the menu for the CAB
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.context, menu);
                menuActual = menu;
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Here you can make any necessary updates to the activity when
                // the CAB is removed. By default, selected items are deselected/unchecked.
                seleccionados = new boolean[alumnos.length];
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // Here you can perform updates to the CAB due to
                // an invalidate() request
                Log.i("Menu","Menu Prepare");

                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.borrar_todos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.borrar_todos) {
            for (int i = 0; i < alumnos.length; i++){
                seleccionados [i]= true;

            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public int getNumSeleccionados() {
        int contador = 0;
        for(int i=0; i<seleccionados.length; i++) {
            if(seleccionados[i]) {
                contador++;
            }
        }
        return contador;
    }
}
