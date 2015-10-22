package com.salesianostriana.di.di_t02_miprimeratostada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnSend;
    EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Rescato el boton cuyo id es R.id.buttonSend
        btnSend = (Button) findViewById(R.id.buttonSend);

        // Rescato el EditText cuyo id es R.id.
        nombre = (EditText) findViewById(R.id.editTextName);

        // Asocio al evento OnCLickListener que tengo implementado en esta clase, por tanto
        // puedo asociarlo al "this", porque el this hace referencia a esta clase
        btnSend.setOnClickListener(this);
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
    public void onClick(View v) {
        //Rescato el valor que tiene el EditText donde el usuario ha introducido su nombre
        String nombreUsuario = nombre.getText().toString();
        String mensaje = "Encantado de conocerte "+nombreUsuario;
        if (nombreUsuario.equals("")){
            mensaje = "¿No tienes nombre?";
        }
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
    }
}
