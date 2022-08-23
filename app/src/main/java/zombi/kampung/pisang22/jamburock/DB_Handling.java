package zombi.kampung.pisang22.jamburock;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB_Handling {

    //declare variables
    private static final String DATABASE_NAME = "phonebook",
            DATABASE_TABLE = "tb_phonebook",KEY_ID = "id", KEY_NAME = "person_name",
            KEY_TEL = "person_tel";

    private static final int DATABASE_VERSION = 1;
    private final Context OUR_CONTEXT;
    private SQLiteDatabase our_db;

    String[] columns = {KEY_ID,KEY_NAME,KEY_TEL};
    //Cursor - contains result of a query
    Cursor our_cursor;
    private DB_HELPER our_helper;

    //Constructor
    public DB_Handling(Context our_context){
        OUR_CONTEXT = our_context;
    }

    //1. openDB() - open connection to database
    public void openDB(){
        //initialize object our_helper
        our_helper = new DB_HELPER(OUR_CONTEXT);
        //allow read & write into database
        our_db = our_helper.getWritableDatabase();

    }

    //2. closeDB() - close connection to database
    public void closeDB(){
        our_helper.close();
    }

    //3. insertData(x,y) -
    public void insertData(String name, String telno){
        ContentValues cv = new ContentValues();

        // 2,. put data into cv
        cv.put(KEY_NAME, name);
        cv.put(KEY_TEL, telno);

        // 3. insert cv into table

        // nullColumnHack - allow column to receive null value from cv
        our_db.insert(DATABASE_TABLE, null, cv);
    }

    public String getAllData() {

        // 1. retrieve data from db
        our_cursor = our_db.query(DATABASE_TABLE, columns, null, null,
                null, null, null);

        // 2. setup a string to store data
        String result = "";

        // 3. start reading data from the table
        for (our_cursor.moveToFirst(); !our_cursor.isAfterLast(); our_cursor.moveToNext()) {
            // get data from every column
            result += our_cursor.getInt(0) + "\t\t\t" + our_cursor.getString(1)
                    + "\t\t\t" + our_cursor.getString(2) + "\n";


        }
        return result;
    }

    public String getName(int rowid) {
        String nameStr = "";

        // retrieve data from person name column
        // SELECT personName FRom tb_phonebook WHERE id=rowid
        our_cursor = our_db.query(DATABASE_TABLE, columns, KEY_ID + " = " + rowid,
                null, null, null, null);

        // 2. reading the data
        if (our_cursor != null) {
            our_cursor.moveToFirst();
            nameStr = our_cursor.getString(1);

        }

        return nameStr;
    }


    // 6. method get tel no
    public String getTelNo (int rowid) {
        String telNo = "";

       our_cursor = our_db.query(DATABASE_TABLE, columns, KEY_ID + "=" + rowid, null,
        null, null, null);

       if(our_cursor != null){
           our_cursor.moveToFirst();
           telNo = our_cursor.getString(2);
       }

       return telNo;
    }

    // 7. method update
    public void updateData(int rowID, String name, String telNo) {
        ContentValues cv = new ContentValues();

        cv.put(KEY_NAME, name);
        cv.put(KEY_TEL, telNo);

        // 3. update new data
        our_db.update(DATABASE_TABLE, cv, KEY_ID + "=" + rowID, null);
    }

    //8. method delete data
    public void deleteData(int rowid) {
        our_db.delete(DATABASE_TABLE, KEY_ID + "=" + rowid, null);
    }


    //*****INNER CLASS extents SQLiteOpenHelper*****
    private class DB_HELPER extends SQLiteOpenHelper{

        public DB_HELPER(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            //CREATE TABLE tb_phonebook(id INTEGER PRIMARY KEY AUTOINCREMENT, person_name TEXR NOT NULL)
            //person_tel TEXT NOT NULL

            sqLiteDatabase.execSQL("CREATE TABLE " + DATABASE_TABLE + " ("
                    +KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + KEY_NAME + " TEXT NOT NULL,"
                    + KEY_TEL + " TEXT NOT NULL);");

        }

        // IF THERE is new version of database, table will be dropped & recreated
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS"+ DATABASE_TABLE);
            //RE-create table
            onCreate(sqLiteDatabase);

        }
    }
}
