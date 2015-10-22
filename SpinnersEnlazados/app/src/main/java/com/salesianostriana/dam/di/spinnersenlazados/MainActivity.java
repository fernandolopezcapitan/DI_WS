package com.salesianostriana.dam.di.spinnersenlazados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner comunidades;
    Spinner provincias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comunidades = (Spinner) findViewById(R.id.spinnerComunidad);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.comunidades, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comunidades.setAdapter(adapter1);

        //Asociamos el spinner al evento OnItemSelectedListener
        comunidades.setOnItemSelectedListener(this);

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
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selecc = (String) comunidades.getSelectedItem();

        if (selecc.equalsIgnoreCase("Andalucía")){
            Spinner provincias = (Spinner) findViewById(R.id.spinnerProvincia);
            ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                    R.array.andalucia, android.R.layout.simple_spinner_item);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            provincias.setAdapter(adapter1);

            Toast.makeText(this,"Se ha seleccionado: "+provincias.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();

        } else if (selecc.equalsIgnoreCase("Extremadura")){
            Spinner provincias = (Spinner) findViewById(R.id.spinnerProvincia);
            ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                    R.array.extremadura, android.R.layout.simple_spinner_item);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            provincias.setAdapter(adapter1);

            Toast.makeText(this,"Se ha seleccionado: "+selecc,Toast.LENGTH_SHORT).show();
        } else if (selecc.equalsIgnoreCase("Aragón")){
            Spinner provincias = (Spinner) findViewById(R.id.spinnerProvincia);
            ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                    R.array.aragon, android.R.layout.simple_spinner_item);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            provincias.setAdapter(adapter1);
            Toast.makeText(this,"Se ha seleccionado: "+selecc,Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
