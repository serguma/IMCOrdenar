package com.gumadev.e2indicemasacorporal.Listener;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.gumadev.e2indicemasacorporal.Activities.MuestraListadoRango;

/**
 * Created by sergu on 19/01/2017.
 */

public class MuestraRangos implements View.OnClickListener {

    private Context ctx;

    public MuestraRangos (Context context){
        this.ctx = context;
    }

    @Override
    public void onClick(View view){

        Log.d(getClass().getCanonicalName(), "Se ha pulsado el botón mostrar rangos");

        Intent intent = new Intent(ctx, MuestraListadoRango.class);
        ctx.startActivity(intent);

    }
}
