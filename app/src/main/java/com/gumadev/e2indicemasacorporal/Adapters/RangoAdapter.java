package com.gumadev.e2indicemasacorporal.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gumadev.e2indicemasacorporal.R;

/**
 * Created by sergu on 19/01/2017.
 */

public class RangoAdapter extends BaseAdapter {

    private Context ctx;

    private Integer[] datos = {
            R.drawable.imc_1, R.drawable.imc_2, R.drawable.imc_3, R.drawable.imc_6, R.drawable.imc_8};

    public RangoAdapter(Context context){
        ctx = context;
    }

    public  int getCount(){
        return  datos.length;
    }

    public Object getItem(int posicion){
        return null;
    }

    public long getItemId(int position){
        return 0;
    }


    public View getView(int posicion, View contentView, ViewGroup parent){

        Activity activity = (Activity) ctx;

        //obtengo los valores para mostrar los estados
        String[] valores = {
        activity.getResources().getString(R.string.desnutrido),
        activity.getResources().getString(R.string.bajopeso),
        activity.getResources().getString(R.string.normal),
        activity.getResources().getString(R.string.sobrepeso),
        activity.getResources().getString(R.string.obesidad)};

        //inflo la vista

        //ViewGroup listadoRangos =  (ViewGroup) activity.findViewById(R.id.listaRangos);

        LayoutInflater inflater = activity.getLayoutInflater();
        View item = inflater.inflate(R.layout.rangos, parent, false);

        //asigno valores
        TextView textView = (TextView) item.findViewById(R.id.textorango);
        textView.setText(valores[posicion]);

        ImageView imageView = (ImageView) item.findViewById(R.id.imagenrango);
        imageView.setImageResource(datos[posicion]);

        return item;

    }
}


