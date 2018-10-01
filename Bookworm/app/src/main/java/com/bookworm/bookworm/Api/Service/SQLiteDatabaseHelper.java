package com.bookworm.bookworm.Api.Service;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.bookworm.bookworm.Ui.Adapter.CostomAdapter;

/**
 * Created by Valdrin on 2/8/2018.
 */

public class SQLiteDatabaseHelper extends SQLiteOpenHelper {




    public SQLiteDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getBook(String query)
    {
        SQLiteDatabase db=getWritableDatabase();
        return db.rawQuery(query,null);
    }

    public void query(String sqlQuery)
    {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(sqlQuery);
    }

    public void insertBook(int state,String title,String author,String imagePath)
    {
        SQLiteDatabase db=getWritableDatabase();
        String query="Insert into BOOK values(NULL,?,?,?,?)";
        SQLiteStatement statement=db.compileStatement(query);
        statement.clearBindings();
        statement.bindString(1,title);
        statement.bindString(2,author);
        statement.bindString(3,imagePath);
        statement.bindString(4,state+"");
        statement.executeInsert();
    }

    public void deleteBook(int id)
    {
        SQLiteDatabase db = getWritableDatabase();
        String CommandForDelete = "delete from BOOK where id = ?";
        SQLiteStatement statement = db.compileStatement(CommandForDelete);
        statement.clearBindings();
        statement.bindDouble(1,(double)id);
        statement.execute();
        db.close();


    }
}
