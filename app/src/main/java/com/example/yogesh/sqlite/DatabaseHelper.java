package com.example.yogesh.sqlite;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 import java.lang.String ;


/**
 * Created by Yogesh on 05-09-2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String  DATABASE_NAME="contacts.db";
    private static final String  TABALE_NAME="CONTACTS";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db =this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " +TABALE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOBILE_NUMBER INTEGER ,EMAIL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXSITS" +TABALE_NAME);
        onCreate(sqLiteDatabase);
    }
    public boolean InsertData(String Names,Integer mobliles,String Emails) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("NAME",Names);
        contentValues.put("MOBILE_NUMBER",mobliles);
        contentValues.put("EMAIL",Emails);
       long result= sqLiteDatabase.insert(TABALE_NAME,null,contentValues);
        if(result==-1 )
            return  false;



      else
        return true ;
    }
    public Cursor getdata(String Mobile){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        String query="SELECT * FROM  "+ TABALE_NAME+" WHERE MOBILE_NUMBER ='"+Mobile+"'" ;
        Cursor cursor =sqLiteDatabase.rawQuery(query,null);
        return cursor;


    }
}
