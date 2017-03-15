package com.thyago.sqlitetherightway;

import android.provider.BaseColumns;

/**
 * Created by thyago on 3/14/17.
 */

public final class TodoContract {
    public static class TodoEntry implements BaseColumns {
        public static final String TABLE_NAME = "todo";

        public static final String DESCRIPTION = "description";
        public static final String CHECKED = "checked";
    }
}
