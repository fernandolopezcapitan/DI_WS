package com.salesianostriana.dam.di.aroundme.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.salesianostriana.dam.di.aroundme.R;
import com.salesianostriana.dam.di.aroundme.models.MensajesItem;
import com.salesianostriana.dam.di.aroundme.services.GcmSendMessageAsyncTask;


public class MensajeActivity extends AppCompatActivity {

    TextView destinatario;
    ImageView enviar_mensaje;
    EditText mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        destinatario = (TextView) findViewById(R.id.destinatario);
        enviar_mensaje = (ImageView) findViewById(R.id.img_send);
        mensaje = (EditText) findViewById(R.id.editText);


        Bundle extras = getIntent().getExtras();
        String nombre = "";
        if(extras!=null) {
            nombre = extras.getString("destinatario");
        }
        destinatario.setText(nombre);

        final String finalNombre = nombre;
        enviar_mensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = mensaje.getText().toString();
                if (msg.isEmpty()) {
                    Toast.makeText(MensajeActivity.this, "Debe introducir algún mensaje", Toast.LENGTH_SHORT).show();
                } else {
                    MensajesItem m = new MensajesItem(finalNombre, msg);
                    Log.i("OBJETO MENSAJE: ", m.getRemitente() + "\n" + m.getMensaje());
                    new GcmSendMessageAsyncTask(MensajeActivity.this).execute(m);
                    mensaje.setText("");
                }

            }
        });
    }

}
