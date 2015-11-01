package com.salesianostriana.di.formulario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText email, contrasena;
    CheckBox terminos;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.editTextEmail);
        contrasena = (EditText) findViewById(R.id.editTextContrasena);
        terminos = (CheckBox) findViewById(R.id.checkBoxTerminos);
        login = (Button) findViewById(R.id.buttonLogin);

        login.setOnClickListener(this);


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
        String message = null;
        if (v.getId() == R.id.buttonLogin){
            if (email.getText().toString().equals("admin@admin.com") && contrasena.getText().toString().equals("1234") && terminos.isChecked()){
                message = "Login correcto";
                Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
            } else {
                message = "Login incorrecto / debe aceptar los términos";
                Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
            }
        }
    }
}
