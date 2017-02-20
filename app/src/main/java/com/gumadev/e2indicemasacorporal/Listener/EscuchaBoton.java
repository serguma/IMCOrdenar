package com.gumadev.e2indicemasacorporal.Listener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gumadev.e2indicemasacorporal.Activities.MuestraResultado;
import com.gumadev.e2indicemasacorporal.R;

/**
 * Created by sergu on 01/01/2017.
 */

public class EscuchaBoton implements View.OnClickListener {

    private Context ct;

    public EscuchaBoton (Context context){
        this.ct = context;
    }

    @Override
    public void onClick(View view){
        Log.d(getClass().getCanonicalName(), "Se ha pulsado el botón");
        String mensaje;
        Activity activity = (Activity) ct;
        EditText pesoUsuario = (EditText) activity.findViewById(R.id.peso);
        EditText alturaUsuario = (EditText) activity.findViewById(R.id.altura);

        //como el peso puede ser expresado con decimales lo paso a tipo float
        if(pesoUsuario.length() > 0 && alturaUsuario.length() > 0){
            float peso = Float.parseFloat(pesoUsuario.getText().toString());
            float altura = Float.parseFloat(alturaUsuario.getText().toString());

            Log.d(getClass().getCanonicalName(), "Paso los datos");
            Log.d(getClass().getCanonicalName(), "Peso" + peso + "Altura" + altura);

            //Le paso los datos y llamo a la actividad que muestra el resultado

            Intent intent = new Intent(ct, MuestraResultado.class);
            intent.putExtra("peso", peso);
            intent.putExtra("altura", altura);
            ct.startActivity(intent);
        }else{
            //Muestro mensaje de que faltan datos
            mensaje = activity.getResources().getString(R.string.error);
            TextView error = (TextView) activity.findViewById(R.id.vererror);
            error.setText(mensaje);
            Log.d(getClass().getCanonicalName(), "No hay datos");
        }

    }


}
