package edu.ues.fia.eisi.sistemadeencuestas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Listado extends AppCompatActivity {
    ListView listView;
    ArrayList<String> listado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        listView=(ListView) findViewById(R.id.ListView);
        CargarListado();
    }
    private void CargarListado(){
        listado = ListadoAlumnos();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, listado);
        listView.setAdapter(adapter);
    }
    private ArrayList<String> ListadoAlumnos(){
        ArrayList<String> datos= new ArrayList<String>();
        BaseHelper helper =new BaseHelper(this,"sistemadeencuesta",null,1);
        SQLiteDatabase db= helper.getReadableDatabase();
        String sql="select idAlumno,nomAlumno,apelAlumno from Alumno";
        Cursor c = db.rawQuery(sql,null);
        if(c.moveToFirst()){
            do{
                String linea=c.getInt(0)+" "+c.getString(1)+" "+c.getString(2);
                datos.add(linea);
            }while(c.moveToNext());
        }
        db.close();
        return datos;
    }
}
