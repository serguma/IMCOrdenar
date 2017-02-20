package com.gumadev.e2indicemasacorporal.Listener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;

import com.gumadev.e2indicemasacorporal.Activities.MuestraMasInfo;
import com.gumadev.e2indicemasacorporal.Activities.MuestraRegistros;
import com.gumadev.e2indicemasacorporal.Dialogos.AlertDialogos;
import com.gumadev.e2indicemasacorporal.R;

/**
 * Created by sergu on 07/02/2017.
 */

public class EscuchaMenu implements MenuItem.OnMenuItemClickListener {

    private Context ctx;

    public EscuchaMenu(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.msalir:
                //Pulso el botón salir

                AlertDialogos alertDialogos = new AlertDialogos(ctx);
                alertDialogos.dialogoSalir();

                Log.d(getClass().getCanonicalName(),"Salir?");
                break;
            case R.id.minfo:
                //pulso el boton info
                //llamo la actividad con el web view

                Intent intent = new Intent(ctx, MuestraMasInfo.class);
                ctx.startActivity(intent);

                Log.d(getClass().getCanonicalName(),"INFO ");
                break;

            case R.id.mhistorial:
                //llama a la actividad que muestra los datos guardados
                Intent verRegistros = new Intent(ctx, MuestraRegistros.class);
                ctx.startActivity(verRegistros);
                break;


        }


        return false;
    }
}
