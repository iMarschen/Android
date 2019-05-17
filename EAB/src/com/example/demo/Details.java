package com.example.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends Activity {
	
	TextView t1,t2;
	ImageView i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details_contact);
		
		t1=(TextView)findViewById(R.id.xm);
		t2=(TextView)findViewById(R.id.dh);
		i=(ImageView)findViewById(R.id.cp);
		
		Intent get_it = getIntent();
		String name = get_it.getStringExtra("name");
		String phone = get_it.getStringExtra("phone");
		String tx =get_it.getStringExtra("tx");
		
		t1.setText(name);
		t2.setText(phone);
		i.setImageResource(Integer.parseInt(tx));
	}
}
