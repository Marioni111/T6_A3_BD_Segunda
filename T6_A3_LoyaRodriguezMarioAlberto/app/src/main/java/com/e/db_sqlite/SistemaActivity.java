package com.e.db_sqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class SistemaActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sistema);

    }


    public void abcc(View v){
        switch (v.getId()){

            case R.id.btn_agregar: Intent a = new Intent(this,AltasActivity.class);
                startActivity(a);
                break;
            case R.id.btn_eliminar: Intent e = new Intent(this,BajasActivity.class);
                startActivity(e);
                break;
            case R.id.btn_modificar: Intent m = new Intent(this,ModificacionesActivity.class);
                startActivity(m);
                break;
            case R.id.btn_buscar: Intent b = new Intent(this,ActivityConsultas.class);
                startActivity(b);
                break;



        }
    }
}
