package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Home extends Activity{
	
	ListView list1; 
	String name[]={"张三","李四","王五"};
	String talk[]={"啊啊啊","哦哦哦","呵呵呵"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		list1=(ListView)findViewById(R.id.listView1);
		
		ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		HashMap<String, Object> map3 = new HashMap<String, Object>();
		
			map1.put("tx", R.drawable.shouji);
			map1.put("name", name[0]);
			map1.put("talk", talk[0]);
			
			map2.put("tx", R.drawable.mima);
			map2.put("name", name[1]);
			map2.put("talk", talk[1]);
			
			map3.put("tx", R.drawable.yonghu);
			map3.put("name", name[2]);
			map3.put("talk", talk[2]);
		
		
		
		String from[]={"tx","name","talk"};
		int to[]={R.id.textView1,R.id.textView2};
		SimpleAdapter aa = new SimpleAdapter(this, data, R.layout.home_item, from, to);
		list1.setAdapter(aa);
		
		list1.setOnItemClickListener(new OnItemClickListener() {
		
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				setTitle(arg2+1+"");
			}
		});
		
	}
}
