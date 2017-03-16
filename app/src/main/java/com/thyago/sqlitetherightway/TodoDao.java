package com.thyago.sqlitetherightway;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by thyago on 3/15/17.
 */

public class TodoDao {
    public static String[] fetchAll(Context context) {
        SQLiteDatabase database = TodoSQLiteOpenHelper
                .getInstance(context.getApplicationContext())
                .getReadableDatabase();

        Cursor cursor = null;
        try {
            cursor = database.query(false, TodoContract.TodoEntry.TABLE_NAME, null, null, null, null, null, null, null);

            int i = 0;
            String[] result = new String[cursor.getCount()];
            while (cursor.moveToNext()) {
                result[i++] = cursor.getString(cursor.getColumnIndex(TodoContract.TodoEntry.DESCRIPTION));
            }
            cursor.close();
            return result;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static void insert(Context context, String description) {
        SQLiteDatabase database = TodoSQLiteOpenHelper
                .getInstance(context.getApplicationContext())
                .getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TodoContract.TodoEntry.DESCRIPTION, description);
        values.put(TodoContract.TodoEntry.CHECKED, 0);

        database.insert(TodoContract.TodoEntry.TABLE_NAME, null, values);
    }
}
