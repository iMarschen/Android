package com.example.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Phone extends Activity{
	
	EditText e_sj;
	EditText e_yzm;
	Button b_yzm;
	Button b_login;
	TextView t_ts;
	String str;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.phone_login);
		e_sj=(EditText)findViewById(R.id.e_phonenum);
		e_yzm=(EditText)findViewById(R.id.e_yzm);
		b_yzm=(Button)findViewById(R.id.b_yzm);
		b_login=(Button)findViewById(R.id.login);
		t_ts=(TextView)findViewById(R.id.tishi);
		b_yzm.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				str=(int) ((Math.random()*9000+1000))+"";
				SmsManager sms=SmsManager.getDefault();
				sms.sendTextMessage(e_sj.getText().toString().trim(), null,"验证码为："+str, null, null);
			}
		});
		
		b_login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String yzm=e_yzm.getText().toString();
				if (yzm.equals(str)) {
					
					Intent it = new Intent(Phone.this,Home.class);
					startActivity(it);
				} else {
					t_ts.setText("验证码错误");
				}
			}
		});
	}

}
