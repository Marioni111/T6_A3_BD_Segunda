package com.e.db_sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import Controlador.ClienteDAO;

public class BajasActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText et_nombre;
    private EditText et_primerAp;
    private EditText et_segundoAp;
    private EditText et_direccion;
    private EditText et_fechaNac;
    private EditText et_telefono;
    private EditText et_email;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bajas);

        et_nombre = (EditText) findViewById(R.id.et_nombre_mod);
        et_primerAp = (EditText) findViewById(R.id.et_primerap_mod);
        et_segundoAp = (EditText) findViewById(R.id.et_segundoap_mod);
        et_direccion = (EditText) findViewById(R.id.et_direccion_mod);
        et_fechaNac = (EditText) findViewById(R.id.et_fechanac_mod);
        et_telefono = (EditText) findViewById(R.id.et_tel_mod);
        et_email = (EditText) findViewById(R.id.et_email_mod);



    }

    //Metodo altas

    public void Eliminar(View v) {
        ClienteDAO em = new ClienteDAO(this, "Fact", null, 1);
        SQLiteDatabase db = em.getWritableDatabase();

        String nombre = et_nombre.getText().toString();

        if (!nombre.isEmpty()) {


            int cantidad = db.delete("Clientes", "nombre= ?", new String[]{String.valueOf(nombre)});
            db.close();

            et_nombre.setText("");


            if (cantidad == 1) {
                Toast.makeText(this, "Cliente eliminado exitosamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El cliente no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes de introducir el nombre del empleado", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
