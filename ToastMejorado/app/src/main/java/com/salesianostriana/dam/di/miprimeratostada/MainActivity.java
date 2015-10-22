package com.salesianostriana.dam.di.miprimeratostada;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    Button btnSend;
    EditText nombre, edad;
    TextView textEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Rescato el botón cuyo id es R.id.buttonSend
        btnSend = (Button) findViewById(R.id.buttonSend);

        // Rescato el editText cuyo id es R.id.editTextName
        nombre = (EditText)findViewById(R.id.editTextName);

        edad = (EditText)findViewById(R.id.editTextEdad);

        textEdad = (TextView)findViewById(R.id.textView_Edad);

        // Asocio al botón el evento OnClickListener
        // que tengo implementado en esta clase, por tanto
        // puedo asociarlo al "this", porque el this hace
        // referencia a esta clase.
        btnSend.setOnClickListener(this);    }

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
    public void onClick(View v) {
        // Rescato el valor que tiene el EditText donde el usuario
        // ha introducido su nombre
        String nombreUsuario = nombre.getText().toString();
        String edadUsuario = edad.getText().toString();

        if(edadUsuario.toString().isEmpty()) {

        } else {
            int edad = Integer.parseInt(edadUsuario);
            String message;
            if (edad < 20)
                message = "Eres un yogurín "+nombreUsuario;
            else
                message = "Qué puretilla eres "+nombreUsuario;
            Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        }
    }
}
