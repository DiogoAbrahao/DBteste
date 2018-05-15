package com.controller.db.dbteste.DBConfigs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBCore extends SQLiteOpenHelper {

    private static final String DB_NAME = "db_transaction";
    private static final int DB_VERSION = 1;

    public DBCore(Context context) {super(context,DB_NAME,null,1);}


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_transaction(_id intiger primary key autoincrement, value real not null, type text not null, date text not null, description text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table tb_transaction");
        onCreate(db);
    }
}
