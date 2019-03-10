package horangya.jhm.begin.yoondongju.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import horangya.jhm.begin.yoondongju.dummy.Poem;

public class DbOpenHelper {

    private static final String DATABASE_NAME = "InnerDatabase(SQLite).db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private DatabaseHelper mDBHelper;
    private Context mCtx;

    private class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(DataBases.CreateDB._CREATE0);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS "+DataBases.CreateDB._TABLENAME0);
            onCreate(db);
        }
    }

    public DbOpenHelper(Context context){
        this.mCtx = context;
    }

    public DbOpenHelper open() throws SQLException {
        mDBHelper = new DatabaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = mDBHelper.getWritableDatabase();
        return this;
    }

    public void create(){
        mDBHelper.onCreate(mDB);
    }

    public void close(){
        mDB.close();
    }

    public long insertColumn(Poem poem){
        ContentValues values = new ContentValues();
        values.put(DataBases.CreateDB._ID, poem.getPoemTitle());
        values.put(DataBases.CreateDB.POEMTITLE, poem.getPoemTitle());
        values.put(DataBases.CreateDB.POEMWRITER, poem.getPoemWriter());
        values.put(DataBases.CreateDB.POEMTEXT, poem.getPoemText());
        values.put(DataBases.CreateDB.USERTITLE, "");
        values.put(DataBases.CreateDB.USERWRITER, "");
        values.put(DataBases.CreateDB.USERTEXT, "");
        values.put(DataBases.CreateDB.NI_DATE, "");
        values.put(DataBases.CreateDB.LS_DATE, "");
        return mDB.insert(DataBases.CreateDB._TABLENAME0, null, values);
    }
    public Cursor selectColumns(){
        return mDB.query(DataBases.CreateDB._TABLENAME0, null, null, null, null, null, null);
    }

    public Cursor sortColumn(String sort){
        Cursor c = mDB.rawQuery( "SELECT * FROM "+ DataBases.CreateDB._TABLENAME0+" ORDER BY " + sort + ";", null);
        return c;
    }

    public boolean updateColumn(Poem poem){
        ContentValues values = new ContentValues();
        values.put(DataBases.CreateDB.USERTITLE, poem.getUserTitle());
        values.put(DataBases.CreateDB.USERWRITER, poem.getUserWriter());
        values.put(DataBases.CreateDB.USERTEXT, poem.getUserText());
        values.put(DataBases.CreateDB.LS_DATE, poem.getDate());


        return mDB.update(DataBases.CreateDB._TABLENAME0, values, "id=\'" + poem.getPoemTitle() + "\'", null) > 0;
        //return mDB.update(DataBases.CreateDB._TABLENAME0, values, "id=aa" ,null) > 0;
    }
    // Delete All
    public void deleteAllColumns() {
        mDB.delete(DataBases.CreateDB._TABLENAME0, null, null);
    }

    // Delete Column
    public boolean deleteColumn(Poem poem){
        return mDB.delete(DataBases.CreateDB._TABLENAME0, "id=\'" + poem.getPoemTitle() + "\'", null) > 0;
    }

}

