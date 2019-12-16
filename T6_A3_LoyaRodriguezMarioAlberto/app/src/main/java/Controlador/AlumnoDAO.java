package Controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import Modelo.Alumno;

public class AlumnoDAO extends SQLiteOpenHelper {


    //constantes que definiran la estructura de la BD

    private static final int VERSION_BD = 1;
    private static final String NOMBRE_BD = "Escuela";
    private static final String TABLA_ALUMNOS = "Alumnos";
    private static final String CAMPO_NUM_CONTROL = "Num_Control";
    private static final String CAMPO_NOMBRE = "Nombre";
    private static final String CAMPO_PRIMERAP = "Primer_AP";
    private static final String CAMPO_SEGUNDOAP = "Segundo_Ap";
    private static final String CAMPO_EDAD = "Edad";
    private static final String CAMPO_SEMESTRE = "Semestre";
    private static final String CAMPO_CARRERA = "Carrera";


    //CREATE TABLE Alumnos(Num_Control TEXT

    private static final String CREAR_TABLA_ALUMNOS = "CREATE TABLE "+TABLA_ALUMNOS+"("+CAMPO_NUM_CONTROL+
            " TEXT, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_PRIMERAP+" TEXT, "+CAMPO_SEGUNDOAP+" TEXT, "+CAMPO_EDAD+" INTEGER, "
            +CAMPO_SEMESTRE+" INTEGER, "+CAMPO_CARRERA+"TEXT)";

    //Crear tabla


    public AlumnoDAO(@Nullable Context context) {
        super(context, NOMBRE_BD, null , VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_ALUMNOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Para actualizar ESQUEMA de la BD
    }

    //----------------------------- METODOS PARA ABCC -----------------------------

    public boolean agregarAlumno(Alumno a) {
        SQLiteDatabase db = this.getWritableDatabase();

        //Meter datos en el ojeto
        ContentValues cv = new ContentValues();
                //(campo, dato)
        cv.put(CAMPO_NUM_CONTROL, a.getNumControl());
        cv.put(CAMPO_NOMBRE, a.getNombre());
        cv.put(CAMPO_PRIMERAP, a.getPrimerAp());
        cv.put(CAMPO_SEGUNDOAP, a.getSegundoAp());
        cv.put(CAMPO_PRIMERAP, a.getPrimerAp());
        cv.put(CAMPO_EDAD, a.getPrimerAp());
        cv.put(CAMPO_SEMESTRE, a.getPrimerAp());
        cv.put(CAMPO_CARRERA, a.getPrimerAp());

        long res = db.insert(TABLA_ALUMNOS, null, cv);

        //Ternario

        return (res==-1) ? false:true;

    }

    public boolean eliminarAlumno(String nc){
        return false;
    }

    public boolean modificarAlimno(Alumno a){
        return false;
    }

    public ArrayList<Alumno> obtenerTodosLosAlumnos( String filtro) {

        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLA_ALUMNOS;

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
