package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class MainActivity extends Activity {

	ListView list1; 
	ImageView p1;
	List<String> name = new ArrayList<String>();
	List<String> phone = new ArrayList<String>();
//	List<String> date = new ArrayList<String>();
	List<String> head = new ArrayList<String>();
	List<HashMap<String, Object>> datt;
	List<HashMap<String, Object>> dat;
	SimpleAdapter adp;
	int k=0;
	MyDatabase mydb;
	Cursor cur;
	Drawable drawable;
	ImageView imgview;
	
	private final static String CNAME="cname";
	private final static String CTEL="ctel";
	private final static String CDATE="cdate";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb=new MyDatabase(this);
        cur=mydb.query();
        
        list1=(ListView)findViewById(R.id.listView1);
        p1=(ImageView)findViewById(R.id.tz);
        
        //׼������
        datt=new ArrayList<HashMap<String,Object>>();
        if(cur.moveToFirst()){
			do{
				HashMap<String, Object> map=new HashMap<String, Object>();
				map.put("CNAME", cur.getString(cur.getColumnIndex(CNAME)));
				map.put("CTEL", cur.getString(cur.getColumnIndex(CTEL)));
				map.put("CDATE", cur.getString(cur.getColumnIndex(CDATE)));
		        Bitmap bp=mydb.getbmp(1);
		        drawable=change_to_drawable(bp);
				map.put("HEAD", R.drawable.p1);
				datt.add(map);
			}while(cur.moveToNext());
		}
        //����adapt
        String [] from={"HEAD","CNAME"};
           int [] to={R.id.tx1,R.id.name1};
        adp = new SimpleAdapter(this, datt, R.layout.item, from, to);
        list1.setAdapter(adp);
        
        //��Ӱ�ť��ת
        p1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(MainActivity.this,Edit.class);
				startActivityForResult(it, 222);
				//list1.setAdapter(adp);
			}
		});
       //��������
        list1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent ite = new Intent(MainActivity.this, Details.class);
				//�����ڼ�����¼
				cur.moveToPosition(arg2);
				ite.putExtra("cname", cur.getString(cur.getColumnIndex(CNAME)));
				ite.putExtra("ctel", cur.getString(cur.getColumnIndex(CTEL)));
				ite.putExtra("cdate", cur.getString(cur.getColumnIndex(CDATE)));
//				ite.putExtra("head", R.drawable.p1);
				startActivity(ite);
			}
		});
        //����ɾ��
        list1.setOnItemLongClickListener(new OnItemLongClickListener() {

		@Override
		public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
				int arg2, long arg3) {
			// TODO Auto-generated method stub
			k=arg2;
			AlertDialog.Builder di =new AlertDialog.Builder(MainActivity.this);
			di.setMessage("�Ƿ�ɾ��");
			di.setNegativeButton("��", null);
			di.setPositiveButton("��", new DialogInterface.OnClickListener() {
					
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					datt.remove(k);
					//�����ݿ�ɾ��
					cur.moveToPosition(k);
					String del_n=cur.getString(cur.getColumnIndex(CNAME));
					mydb.delete(del_n);
					list1.setAdapter(adp);
				}
				});
				di.show();
				return false;
			}
		});
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// TODO Auto-generated method stub
    	super.onActivityResult(requestCode, resultCode, data);
    	if(requestCode==222 && resultCode==111){
    		String nn=data.getStringExtra("name");
    		String pp=data.getStringExtra("phone");
    		String da=data.getStringExtra("date");
    		String tt=data.getStringExtra("tx");
    		int itt=Integer.parseInt(tt);
    		
    		drawable=this.getResources().getDrawable(itt);
    	    byte[] img=mydb.imgtobyte(drawable);
    	    
    	    mydb.insert(nn, pp, da, img);
    	    
            //�����ݿ���ȡ����
            dat=new ArrayList<HashMap<String,Object>>();
            if(cur.moveToFirst()){
    			do{
    				HashMap<String, Object> map=new HashMap<String, Object>();
    				map.put("CNAME", cur.getString(cur.getColumnIndex(CNAME)));
    				map.put("CTEL", cur.getString(cur.getColumnIndex(CTEL)));
    				map.put("CDATE", cur.getString(cur.getColumnIndex(CDATE)));
    		        Bitmap bp=mydb.getbmp(1);
    		        drawable=change_to_drawable(bp);
    				map.put("HEAD", R.drawable.p1);
    				datt.add(map);
    			}while(cur.moveToNext());
    		}
            //����adapt
            String [] from={"HEAD","CNAME"};
               int [] to={R.id.tx1,R.id.name1};
            adp = new SimpleAdapter(this, dat, R.layout.item, from, to);
            list1.setAdapter(adp);
    	}
    }
    
    public Drawable change_to_drawable(Bitmap bp){
    	Bitmap bm=bp;
    	BitmapDrawable bd=new BitmapDrawable(this.getResources(),bm);
    	return bd;
    }
}
