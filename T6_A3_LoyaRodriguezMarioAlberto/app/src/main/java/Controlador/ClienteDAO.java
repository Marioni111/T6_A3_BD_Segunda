package Controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import Modelo.Alumno;
import Modelo.Cliente;

public class ClienteDAO extends SQLiteOpenHelper {

    private EditText et_nombre;
    private EditText et_primerAp;
    private EditText et_segundoAp;
    private EditText et_direccion;
    private EditText et_fechaNac;
    private EditText et_telefono;
    private EditText et_email;



    private static final int VERSION_BD = 1;
    private static final String NOMBRE_BD = "SistFacturas";
    private static final String CAMPO_ID_CLIENTE = "id_Cliente";
    private static final String TABLA_CLIENTES= "Clientes";
    private static final String CAMPO_NOMBRE = "Nombre";
    private static final String CAMPO_PRIMERAP = "Primer_AP";
    private static final String CAMPO_SEGUNDOAP = "Segundo_Ap";
    private static final String CAMPO_DIRECCION = "Direccion";
    private static final String CAMPO_FECHANAC = "FechaNac";
    private static final String CAMPO_TELEFONO = "Telefono";
    private static final String CAMPO_EMAIL = "Email";

    private static final String CREAR_TABLA_CLIENTES = "CREATE TABLE "+TABLA_CLIENTES+"("+CAMPO_ID_CLIENTE+
            " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_PRIMERAP+" TEXT, "+CAMPO_SEGUNDOAP+" TEXT, "
            +CAMPO_DIRECCION+" TEXT, " +CAMPO_FECHANAC+" TEXT, "+CAMPO_TELEFONO+"TEXT, "+ CAMPO_EMAIL+" TEXT)";


    public ClienteDAO(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, NOMBRE_BD, null , VERSION_BD);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREAR_TABLA_CLIENTES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqliteDatabase, int i, int i1) {

    }
    public boolean agregarEmpleado(Cliente c) {

        SQLiteDatabase db = this.getWritableDatabase();

        //Meter datos en el ojeto
        ContentValues cv = new ContentValues();
        //(campo, dato)


        cv.put(CAMPO_NOMBRE, c.getNombre());
        cv.put(CAMPO_PRIMERAP, c.getPrimerAp());
        cv.put(CAMPO_SEGUNDOAP, c.getSegundoAp());
        cv.put(CAMPO_DIRECCION, c.getDireccion());
        cv.put(CAMPO_FECHANAC, c.getFechaNac());
        cv.put(CAMPO_TELEFONO, c.getTelefono());
        cv.put(CAMPO_EMAIL, c.getEmail());
        long res = db.insert(TABLA_CLIENTES, null, cv);

        //Ternario

        return (res==-1) ? false:true;


    }

    public boolean eliminarAlumno(String nc){
        return false;
    }

    public boolean modificarAlimno(Alumno a){
        return false;
    }

    public ArrayList<Alumno> obtenerTodosLosAlumnos(String filtro) {

        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLA_CLIENTES;

        Cursor cursor = db.rawQuery(sql, null);
        //Si hay o no registros
        if (cursor.moveToFirst()) {
            do {
                listaAlumnos.add(new Alumno(cursor.getString(0),
                        cursor.getString(1),cursor.getString(2),
                        cursor.getString(3),(byte)cursor.getInt(4),
                        (byte)cursor.getInt(5),cursor.getString(6)));


            }while(cursor.moveToNext()); //poder moverse al siguiente
        }
        return listaAlumnos;
    }
}
