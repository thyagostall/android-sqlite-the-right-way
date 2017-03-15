package com.thyago.sqlitetherightway;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.thyago.sqlitetherightway.TodoContract.TodoEntry;

/**
 * Created by thyago on 3/14/17.
 */

public class TodoSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = TodoSQLiteOpenHelper.class.getSimpleName();

    private static final int VERSION = 1;
    private static final String DATABASE_FILE_NAME = "sqlite-the-right-way.db";

    private static final String SQL_CREATE_TODO_TABLE =
            "CREATE TABLE " + TodoEntry.TABLE_NAME + "(" +
                    TodoEntry._ID + " INTEGER PRIMARY KEY, " +
                    TodoEntry.DESCRIPTION + " TEXT, " +
                    TodoEntry.CHECKED + " INTEGER)";

    private static TodoSQLiteOpenHelper mInstance;

    public static TodoSQLiteOpenHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new TodoSQLiteOpenHelper(context.getApplicationContext());
        }
        return mInstance;
    }

    private TodoSQLiteOpenHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "onCreate");

        db.execSQL(SQL_CREATE_TODO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(LOG_TAG, "onUpgrade");
    }
}
