package com.gumadev.e2indicemasacorporal.BaseDatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.gumadev.e2indicemasacorporal.Objetos.Usuario;
import com.gumadev.e2indicemasacorporal.Objetos.UsuariosDatos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergu on 01/02/2017.
 */


public class BaseDatosUsuarios extends SQLiteOpenHelper {

    private static final String SQL_CREA_TABLA_USUARIOS = "CREATE TABLE usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, pass TEXT)";
    private static final String SQL_CREA_TABLA_USUARIOS_DATOS = "CREATE TABLE usuarios_datos (id INTEGER PRIMARY KEY AUTOINCREMENT, resultado DOUBLE, idusuario INTEGER, fecha DATETIME, FOREIGN KEY (idusuario) REFERENCES usuarios (id))";

    public BaseDatosUsuarios(Context context, String nombre, SQLiteDatabase.CursorFactory factor, int version) {
        super(context, nombre, factor, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREA_TABLA_USUARIOS);
        db.execSQL(SQL_CREA_TABLA_USUARIOS_DATOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertarUusario(Usuario usuario){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //Log.d(getClass().getCanonicalName(),"INSERT INTO usuarios (nombre, pass)VALUES('"+usuario.getNombre()+"', '"+usuario.getPass()+"')");
        sqLiteDatabase.execSQL("INSERT INTO usuarios (nombre, pass)VALUES('"+usuario.getNombre()+"', '"+usuario.getPass()+"')");
        sqLiteDatabase.close();
    }

    public boolean existeUsuario(Usuario usuario){
        boolean existe = false;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String consulta = "SELECT id FROM usuarios WHERE ((nombre = '"+usuario.getNombre()+"') AND (pass = '"+usuario.getPass()+"'))";
        Cursor cursor = sqLiteDatabase.rawQuery(consulta, null);

        if( (cursor != null) && ( cursor.getCount() > 0 )){
            existe = true;
            //Log.d(getClass().getCanonicalName(),"Existe");
            //el usuario existe
        }
        cursor.close();
        sqLiteDatabase.close();

        return existe;
    }

    public int idDeUsuario(Usuario usuario){
        int id = 0;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String consulta = "SELECT id FROM usuarios WHERE ((nombre = '"+usuario.getNombre()+"') AND (pass = '"+usuario.getPass()+"'))";
        Cursor cursor = sqLiteDatabase.rawQuery(consulta, null);
        Log.d(getClass().getCanonicalName(),"IDUSER" +consulta);
        if( (cursor != null) && ( cursor.getCount() > 0 )){

            do{
                cursor.moveToFirst();
                id = cursor.getInt(0);
                Log.d(getClass().getCanonicalName(),"IDUSER" +id);
            }while(cursor.moveToNext());

        }
        cursor.close();
        sqLiteDatabase.close();

        return id;
    }

    public void insertarRegistro(UsuariosDatos usuariosDatos){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("INSERT INTO usuarios_datos (resultado,idusuario,fecha)VALUES("+usuariosDatos.getResultado()+", "+usuariosDatos.getIdusuario()+",datetime('now'))");
        sqLiteDatabase.close();
    }

    public List<UsuariosDatos> listarResultados(int idUsuario){

        List<UsuariosDatos> listaDatos = null;

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String consulta = "SELECT id,resultado,idusuario,fecha FROM usuarios_datos WHERE idusuario= "+idUsuario+" ORDER BY fecha DESC";
        Cursor cursor = sqLiteDatabase.rawQuery(consulta, null);
        Log.d(getClass().getCanonicalName(),"CURSOR "+cursor.getCount());
        if((cursor != null) && (cursor.getCount() > 0)){

            cursor.moveToFirst();
            listaDatos = new ArrayList<>();
            int id;
            float resultado;
            int idusuario;
            String fecha = null;
            UsuariosDatos datos = null;

            do{
                id = cursor.getInt(0); //no lo uso de momento
                resultado = cursor.getFloat(1);
                idusuario = cursor.getInt(2);
                fecha = cursor.getString(3);

                datos = new UsuariosDatos(resultado,idusuario,fecha);
                listaDatos.add(datos);

                Log.d(getClass().getCanonicalName(),"DATOS "+resultado);

            }while(cursor.moveToNext());

            cursor.close();
            sqLiteDatabase.close();

        }else{
            Log.d(getClass().getCanonicalName(),"Consulta sin resultados");
        }

        return listaDatos;
    }

}
