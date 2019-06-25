package com.example.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends Activity {
	
	TextView t1,t2,t3;
	ImageView i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details_contact);
		
		t1=(TextView)findViewById(R.id.xm);
		t2=(TextView)findViewById(R.id.dh);
		t3=(TextView)findViewById(R.id.sr);
		i=(ImageView)findViewById(R.id.cp);
		
		Intent get_it = getIntent();
		String name = get_it.getStringExtra("cname");
		String phone = get_it.getStringExtra("ctel");
		String sr = get_it.getStringExtra("cdate");
//		String tx =get_it.getStringExtra("head");
		
		t1.setText(name);
		t2.setText(phone);
		t3.setText(sr);
		i.setImageResource(R.drawable.p1);
	}
}
