package com.gumadev.e2indicemasacorporal.Activities;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.gumadev.e2indicemasacorporal.Dialogos.AlertDialogos;
import com.gumadev.e2indicemasacorporal.Listener.EscuchaBoton;
import com.gumadev.e2indicemasacorporal.Listener.EscuchaMenu;
import com.gumadev.e2indicemasacorporal.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle bundle) {

        Log.v(getClass().getCanonicalName(), "Estamos en el Oncreate");

        super.onCreate(bundle);

        setContentView(R.layout.activity_main);

        Button boton = (Button) findViewById(R.id.calcular);
        EscuchaBoton escuchaBoton = new EscuchaBoton(this);
        boton.setOnClickListener(escuchaBoton);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflo el menu
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Con escucha menu ejecuto las acciones de los item del menú
        EscuchaMenu escuchaMenu = new EscuchaMenu(this);
        item.setOnMenuItemClickListener(escuchaMenu);
        return true;
    }

    @Override
    public void onBackPressed() {
        //Para mostrar el diálogo al pulsar el botón atras
        AlertDialogos alertDialogos = new AlertDialogos(this);
        alertDialogos.dialogoSalir();
    }
}
