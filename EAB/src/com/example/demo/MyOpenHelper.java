package com.example.demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {

	//³£Á¿
	private final static String DATABASENAME="mysqlite.db";
	private final static String TNAME="contact";
	private final static String CID="cid";
	private final static String CNAME="cname";
	private final static String CTEL="ctel";
	private final static String CDATE="cdate";
	
	public MyOpenHelper(Context context) {
		super(context, DATABASENAME, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		arg0.execSQL("create table if not exists "+TNAME+"("+CID+" integer primary key autoincrement,"+CNAME+" text(20),"+CTEL+" text(20),"+CDATE+" text(20),head blob)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
