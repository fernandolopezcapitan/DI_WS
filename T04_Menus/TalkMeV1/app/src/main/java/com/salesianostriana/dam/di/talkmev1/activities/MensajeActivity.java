package com.salesianostriana.dam.di.talkmev1.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.salesianostriana.dam.di.talkmev1.R;

public class MensajeActivity extends AppCompatActivity {

    TextView destinatario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        destinatario = (TextView) findViewById(R.id.destinatario);

        Bundle extras = getIntent().getExtras();
        String nombre = "";
        if(extras!=null) {
            nombre = extras.getString("destinatario");
        }
        destinatario.setText(nombre);
    }

}
