package com.salesianostriana.dam.di.butterknife;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Bind(R.id.textViewHelloWorld)
    TextView textoHolaMundo;

    @Bind(R.id.imageButtonLike)
    ImageButton btnLike;

    @BindDrawable(R.drawable.ic_thumb_down)
    Drawable drawableDown;

    @BindDrawable(R.drawable.ic_thumb_up)
    Drawable drawableUp;

    @BindString(R.string.welcome) String saludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // De forma nativa:
        //textoHolaMundo.setText(getResources().getString(R.string.welcome));


        // Con Butter Knike:
        textoHolaMundo.setText(saludo);

        // Para un Toast tendría 3 formas de pasarle el texto

        // 1. De manera nativa, pasando un String:
        String stringSaludo = getResources().getString(R.string.welcome);
        Toast.makeText(this, stringSaludo, Toast.LENGTH_SHORT).show();

        // 2. De manera nativa, pasando la referencia de un String (R.string.welcome)
        Toast.makeText(this,R.string.welcome,Toast.LENGTH_SHORT).show();

        // 3. Con ButterKnife, pasándole la variable declarada con la
        // anotación @BindString
        Toast.makeText(this,saludo,Toast.LENGTH_SHORT).show();
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

    @OnClick(R.id.imageButtonLike)
    public void submit(ImageButton btn) {
        if(btn.getDrawable().equals(drawableDown)) {
            btn.setImageDrawable(drawableUp);
        } else {
            btn.setImageDrawable(drawableDown);
        }
    }

    // Si lo hubiéramos hecho sin la librería ButterKnife sería:
    public void onClickLike(View v) {
        ImageButton btn = (ImageButton)v;

        if(btn.getDrawable().equals(getDrawable(R.drawable.ic_thumb_down))) {
            btn.setImageDrawable(getDrawable(R.drawable.ic_thumb_up));
        } else {
            btn.setImageDrawable(getDrawable(R.drawable.ic_thumb_down));
        }


    }
}
