package com.thyago.sqlitetherightway;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by thyago on 3/15/17.
 */

public class SQLiteTheRightWayApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
