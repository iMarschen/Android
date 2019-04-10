package com.example.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Activity {
	
	Button b_zhuce;
	EditText e_user;
	EditText e_pw;
	TextView t_ts;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		b_zhuce=(Button)findViewById(R.id.zhuce);
		e_user=(EditText)findViewById(R.id.phonenum);
		e_pw=(EditText)findViewById(R.id.pw_login);
		t_ts=(TextView)findViewById(R.id.tishi);
		
		b_zhuce.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(Login.this,MainActivity.class);
				String user=e_user.getText().toString();
				String pw=e_pw.getText().toString();
				if (e_user.getText().length()==0 & e_pw.getText().length()==0) {
					t_ts.setText("请输入有效的用户名和密码");
				}
				else {
					it.putExtra("k1", user);
					it.putExtra("k2", pw);
					startActivity(it);
				}
			}
		});
	}
}
