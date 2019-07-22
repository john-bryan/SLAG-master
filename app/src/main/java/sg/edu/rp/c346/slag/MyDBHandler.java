package sg.edu.rp.c346.slag;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

    public class MyDBHandler extends SQLiteOpenHelper {
        //information of database
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "adhocDB.db";

        public static final String TABLE_NAME = "Adhoc";

        public static final String COLUMN_ID = "userID";
        public static final String COLUMN_NAME = "userName";
        public static final String COLUMN_ADDRESS = "address";
        public static final String COLUMN_ITEMS = "itemsCollected";
        //initialize the database

        SQLiteDatabase database;

        public MyDBHandler(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            database = getWritableDatabase();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_NAME+ " TEXT, " + COLUMN_ADDRESS + " TEXT, " + COLUMN_ITEMS + " TEXT)");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
        public Cursor loadHandler() {
            database = this.getWritableDatabase();
            String query = "SELECT * FROM " +  TABLE_NAME;
            Cursor data  = database.rawQuery(query, null);
            return data;
        }

        public boolean addHandler(String item) {
            database = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_NAME, item);
            contentValues.put(COLUMN_ADDRESS, item);
            contentValues.put(COLUMN_ITEMS, item);

            long result = database.insert(TABLE_NAME, null, contentValues);

            if (result == -1) {
                return false;
            } else{
                return true;
            }
        }
//        public AdHoc findHandler(String name) {}
//        public boolean deleteHandler(int ID) {}
//        public boolean updateHandler(int ID, String name) {}
    }
