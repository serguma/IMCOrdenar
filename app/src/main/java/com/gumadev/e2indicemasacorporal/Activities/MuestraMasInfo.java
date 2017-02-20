package com.gumadev.e2indicemasacorporal.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gumadev.e2indicemasacorporal.Listener.EscuchaMenu;
import com.gumadev.e2indicemasacorporal.R;

public class MuestraMasInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_mas_info);

        WebView masInfo = (WebView) findViewById(R.id.winfo);
        WebViewClient viewClient = new WebViewClient();

        masInfo.setWebViewClient(viewClient);
        //habilito el Javascript de la web
        masInfo.getSettings().setJavaScriptEnabled(true);
        //cargo el enlace de la wikipedia
        masInfo.loadUrl("https://es.wikipedia.org/wiki/Índice_de_masa_corporal");
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
