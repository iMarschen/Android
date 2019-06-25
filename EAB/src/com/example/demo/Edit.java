package com.example.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Edit extends Activity{
	
	EditText name;
	EditText phone;
	EditText date;
	Button add;
	Button qx;
	RadioButton p1,p2,p3;
	String tx;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_contact);
		
		name=(EditText)findViewById(R.id.name);
		phone=(EditText)findViewById(R.id.phone);
		date=(EditText)findViewById(R.id.date);
		add=(Button)findViewById(R.id.add);
		qx=(Button)findViewById(R.id.del);
		p1=(RadioButton)findViewById(R.id.p1);
		p2=(RadioButton)findViewById(R.id.p2);
		p3=(RadioButton)findViewById(R.id.p3);
		
		if(p1.isChecked()){
			tx=R.drawable.p1+"";
		}
		else if (p2.isChecked()) {
			tx=R.drawable.p2+"";
		}
		else if (p3.isChecked()) {
			tx=R.drawable.p3+"";
		}
		else{
			tx=R.drawable.p1+"";
		}
		
		add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent();
				String n=name.getText().toString().trim();
				String p=phone.getText().toString().trim();
				String d=date.getText().toString().trim();
				if(n.length()==0 && p.length()==0 && d.length()==0)
					Toast.makeText(Edit.this, "请输入完整的联系人信息", Toast.LENGTH_SHORT).show();
				else{
					it.putExtra("name", n);
					it.putExtra("phone", p);
					it.putExtra("date", d);
					it.putExtra("tx", tx);
					setResult(111,it);
					finish();
				}
			}
		});
		
		qx.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			finish();
			}
		});
	}
}