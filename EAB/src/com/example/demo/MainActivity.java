package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class MainActivity extends Activity {

	ListView list1; 
	ImageView p1;
	List<String> name = new ArrayList<String>();
	List<String> phone = new ArrayList<String>();
	List<String> tx = new ArrayList<String>();
	List<HashMap<String, Object>> datt;
	SimpleAdapter adp;
	int k=0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        list1=(ListView)findViewById(R.id.listView1);
        p1=(ImageView)findViewById(R.id.tz);
        
        //准备数据
        datt=new ArrayList<HashMap<String,Object>>();
        
        for(int i=0;i<name.size();i++){
        	HashMap<String,Object> map =new HashMap<String, Object>();
    		map.put("name", name.get(i));
    		map.put("phone",phone.get(i));
    		map.put("tx", Integer.parseInt(tx.get(i)));
    		datt.add(map);
        }
        
        //构造adapt
        String [] from={"name","tx"};
           int [] to={R.id.name,R.id.tx};
        adp = new SimpleAdapter(this, datt, R.layout.item, from, to);
        list1.setAdapter(adp);
        
        //添加按钮跳转
        p1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(MainActivity.this,Edit.class);
				startActivityForResult(it, 222);
				//list1.setAdapter(adp);
			}
		});
        //单击详情
        list1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent ite = new Intent(MainActivity.this, Details.class);
				ite.putExtra("name", datt.get(arg2).get("name").toString());
				ite.putExtra("phone", datt.get(arg2).get("phone").toString());
				ite.putExtra("tx", datt.get(arg2).get("tx").toString());
				startActivity(ite);
			}
		});
        //长按删除
        list1.setOnItemLongClickListener(new OnItemLongClickListener() {

		@Override
		public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
				int arg2, long arg3) {
			// TODO Auto-generated method stub
			k=arg2;
			AlertDialog.Builder di =new AlertDialog.Builder(MainActivity.this);
			di.setMessage("是否删除");
			di.setNegativeButton("否", null);
			di.setPositiveButton("是", new DialogInterface.OnClickListener() {
					
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					datt.remove(k);
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
    		String tt=data.getStringExtra("tx");
    		name.add(nn);
    	    phone.add(pp);
    	    tx.add(tt);
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("name", nn);
            map.put("phone", pp);
            map.put("tx", Integer.parseInt(tt));
            datt.add(map);
    	    list1.setAdapter(adp);
    	}
    }
}
