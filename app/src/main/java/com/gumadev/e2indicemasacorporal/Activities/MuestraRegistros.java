package com.gumadev.e2indicemasacorporal.Activities;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.gumadev.e2indicemasacorporal.Adapters.RegistroAdapter;
import com.gumadev.e2indicemasacorporal.BaseDatos.BaseDatosUsuarios;
import com.gumadev.e2indicemasacorporal.Listener.EscuchaMenu;
import com.gumadev.e2indicemasacorporal.Objetos.ComparaDatos;
import com.gumadev.e2indicemasacorporal.Objetos.UsuariosDatos;
import com.gumadev.e2indicemasacorporal.R;

import java.util.Collections;
import java.util.List;

public class MuestraRegistros extends AppCompatActivity {

    private  List<UsuariosDatos> listado = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_registros);

        SharedPreferences sharedPreferences = getSharedPreferences("preferen", this.MODE_PRIVATE);
        BaseDatosUsuarios baseDatosUsuarios = new BaseDatosUsuarios(this, "usuariosdb", null, 1);

        int idusuario = sharedPreferences.getInt("idusuario", 0);
        listado = baseDatosUsuarios.listarResultados(idusuario);

        if(listado != null) {
            Log.d(getClass().getCanonicalName(), "USUARIO: " + idusuario);
            Log.d(getClass().getCanonicalName(), "DATO " + listado.size());

            RegistroAdapter registroAdapter = new RegistroAdapter(this, R.layout.fila_registros, listado);

            ListView listView = (ListView) findViewById(R.id.listadoRegistros);
            listView.setAdapter(registroAdapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflo el menu
        getMenuInflater().inflate(R.menu.menu_ordenar, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(listado != null) {
            if (item.getTitle().equals("Ordenar por IMC")){
                Collections.sort(listado, new ComparaDatos());
            }else{
                Collections.sort(listado);
            }

            RegistroAdapter registroAdapter = new RegistroAdapter(this, R.layout.fila_registros, listado);
            ListView listView = (ListView) findViewById(R.id.listadoRegistros);
            listView.setAdapter(registroAdapter);
        }

        return true;
    }
}
