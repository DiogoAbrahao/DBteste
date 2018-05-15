package com.controller.db.dbteste.DBConfigs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.controller.db.dbteste.Objects.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DB {

    private SQLiteDatabase db;

    public DB(Context context){
        DBCore dbCore = new DBCore(context);
        db = dbCore.getWritableDatabase();
    }

    public void  InsertValues(Transaction transaction){
        ContentValues contentValues = new ContentValues();
        contentValues.put("value", transaction.getValue());
        contentValues.put("description", transaction.getDescription());
        contentValues.put("date", transaction.getDate());
        contentValues.put("type", transaction.getTransactionType().toString());
        db.insert("tb_transaction",null,contentValues);
    }

    public List<Transaction> SeachValues(){
        List<Transaction> list = new ArrayList<Transaction>();
        String[] colunas = new String[]{"_id","value","type","date","description"};

        Cursor cursor = db.query("tb_transaction", colunas,null,null,null,null,"nome ASC");


        return(list);
    }

}
