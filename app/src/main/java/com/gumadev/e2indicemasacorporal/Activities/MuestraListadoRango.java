package com.gumadev.e2indicemasacorporal.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.gumadev.e2indicemasacorporal.Adapters.RangoAdapter;
import com.gumadev.e2indicemasacorporal.Listener.EscuchaMenu;
import com.gumadev.e2indicemasacorporal.R;

public class MuestraListadoRango extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_listado_rango);

        ListView listView = (ListView) findViewById(R.id.listaRangos);
        listView.setAdapter(new RangoAdapter(this));
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
}
