package com.gumadev.e2indicemasacorporal.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.gumadev.e2indicemasacorporal.Objetos.UsuariosDatos;
import com.gumadev.e2indicemasacorporal.R;

import java.util.List;

/**
 * Created by sergu on 14/02/2017.
 */

public class RegistroAdapter extends ArrayAdapter<UsuariosDatos> {

    private Context ctx;
    private List<UsuariosDatos> listado = null;

    public RegistroAdapter(Context ctx, int resource, List<UsuariosDatos> listado) {
        super(ctx, resource);
        this.ctx = ctx;
        this.listado = listado;
    }

    @Override
    public int getCount() {
        return listado.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        if(convertView == null){

            Activity activity = (Activity) ctx;
            LayoutInflater lista = activity.getLayoutInflater();
            view = lista.inflate(R.layout.fila_registros, parent, false);

        }else{
            view = convertView;
        }

        if(listado != null) {
            TextView resultado = (TextView) view.findViewById(R.id.rimc);
            TextView fecha = (TextView) view.findViewById(R.id.rfecha);

            UsuariosDatos datos = listado.get(position);

            resultado.setText(String.valueOf(datos.getResultado()));
            fecha.setText(datos.getFecha());
        }

        return view;
    }
}
