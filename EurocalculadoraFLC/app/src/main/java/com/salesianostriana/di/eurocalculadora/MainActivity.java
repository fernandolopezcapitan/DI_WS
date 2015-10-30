package com.salesianostriana.di.eurocalculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView pantalla;
    Button cambiopts, cambioeur, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero, c, punto;
    double num, tot, var;
    int pun = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantalla = (TextView) findViewById(R.id.pantalla);
        cambiopts = (Button) findViewById(R.id.btnCambioapts);
        cambioeur = (Button) findViewById(R.id.btnCambioaeur);
        uno = (Button) findViewById(R.id.btn_1);
        dos = (Button) findViewById(R.id.btn_2);
        tres = (Button) findViewById(R.id.btn_3);
        cuatro = (Button) findViewById(R.id.btn_4);
        cinco = (Button) findViewById(R.id.btn_5);
        seis = (Button) findViewById(R.id.btn_6);
        siete = (Button) findViewById(R.id.btn_7);
        ocho = (Button) findViewById(R.id.btn_8);
        nueve = (Button) findViewById(R.id.btn_9);
        cero = (Button) findViewById(R.id.btn_0);
        c = (Button) findViewById(R.id.btn_c);
        punto = (Button) findViewById(R.id.btn_doc);

        cambiopts.setOnClickListener(this);
        cambioeur.setOnClickListener(this);
        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        seis.setOnClickListener(this);
        siete.setOnClickListener(this);
        ocho.setOnClickListener(this);
        nueve.setOnClickListener(this);
        cero.setOnClickListener(this);
        c.setOnClickListener(this);
        punto.setOnClickListener(this);
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
        switch (v.getId()){

            case R.id.btn_0:
                pantalla.setText(pantalla.getText().toString()+"0");
                break;
            case R.id.btn_1:
                pantalla.setText(pantalla.getText().toString()+"1");
                break;
            case R.id.btn_2:
                pantalla.setText(pantalla.getText().toString()+"2");
                break;
            case R.id.btn_3:
                pantalla.setText(pantalla.getText().toString()+"3");
                break;
            case R.id.btn_4:
                pantalla.setText(pantalla.getText().toString()+"4");
                break;
            case R.id.btn_5:
                pantalla.setText(pantalla.getText().toString()+"5");
                break;
            case R.id.btn_6:
                pantalla.setText(pantalla.getText().toString()+"6");
                break;
            case R.id.btn_7:
                pantalla.setText(pantalla.getText().toString()+"7");
                break;
            case R.id.btn_8:
                pantalla.setText(pantalla.getText().toString()+"8");
                break;
            case R.id.btn_9:
                pantalla.setText(pantalla.getText().toString()+"9");
                break;
            case R.id.btn_doc:
                if (pun < 2){
                    pantalla.setText(pantalla.getText().toString()+".");
                    pun++;
                } else
                    Toast.makeText(this,"No puedes introducir más de un punto",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_c:
                pantalla.setText("");
                break;
            case R.id.btnCambioaeur:
                var = 0;
                tot = 0;
                var = Double.parseDouble(pantalla.getText().toString());
                tot = var / 166.386;
                pantalla.setText(String.valueOf(tot));
                break;
            case R.id.btnCambioapts:
                var = 0;
                tot = 0;
                var = Double.parseDouble(pantalla.getText().toString());
                tot = var * 166.386;
                pantalla.setText(String.valueOf(tot));
                break;
        }
    }
}
