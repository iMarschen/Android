package com.example.demo;

import java.io.ByteArrayOutputStream;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class MyDatabase {
	//常量
		private final static String DATABASENAME="mysqlite.db";
		private final static String TNAME="contact";
		private final static String CID="cid";
		private final static String CNAME="cname";
		private final static String CTEL="ctel";
		private final static String CDATE="cdate";
		
		public MyOpenHelper myhelper;
		public SQLiteDatabase mydb;
		
		public MyDatabase(Context context){
			
			 myhelper=new MyOpenHelper(context);
			 mydb=myhelper.getWritableDatabase();
			 
		}


		void insert(String cname,String ctel,String cdate,byte[] img){
			ContentValues values=new ContentValues();
			 values.put(CNAME, cname);
			 values.put(CTEL, ctel);
			 values.put(CDATE, cdate);
			 values.put("head", img);
			 mydb.insert(TNAME, null, values);
		 }
		
		Cursor query(){
			
			Cursor cursor=mydb.query(TNAME, null, null, null, null, null, null);
			return cursor;
		}
		
		public void delete(String name){
			 ContentValues values=new ContentValues();
			 String[] args = {name};
			 mydb.delete(TNAME, "cname=?", args);
			 //db.delete(Table, "username=?", args);
		 }	
		 
		//Drawable-->byte[] 
		byte[] imgtobyte(Drawable drawable){
				BitmapDrawable bitmap=(BitmapDrawable)drawable;
				Bitmap bitma=bitmap.getBitmap();
				ByteArrayOutputStream baos=new ByteArrayOutputStream();
				bitma.compress(Bitmap.CompressFormat.PNG, 100, baos);
				return baos.toByteArray();
			}
		//数据库中图片（byte[]）-->Bitmap
		Bitmap getbmp(int position){
	    	Cursor cursor=mydb.query(TNAME, null, null, null, null, null, null);
	    	
	    	cursor.moveToPosition(position);
	    	
	    	byte[] in=cursor.getBlob(cursor.getColumnIndex("head"));
	    	Bitmap biout=BitmapFactory.decodeByteArray(in, 0, in.length);
	    	
	    	return biout;	
	    }
}
