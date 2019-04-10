package com.example.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	Button b_login;
	Button b_phone;
	Button b_sign;
	EditText e_user;
	EditText e_pw;
	TextView t_ts;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        b_login=(Button)findViewById(R.id.login);
        b_phone=(Button)findViewById(R.id.phone_login);
        b_sign=(Button)findViewById(R.id.sign);
        e_user=(EditText)findViewById(R.id.username);
        e_pw=(EditText)findViewById(R.id.password);
        t_ts=(TextView)findViewById(R.id.tishi);
        
        Intent it=getIntent();
        final String user=it.getStringExtra("k1");
        final String pw=it.getStringExtra("k2");
        e_user.setText(user);
        
        b_login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			String password = e_pw.getText().toString(); 
			String username = e_user.getText().toString();
				if(username.equals(user) & password.equals(pw)){
					Intent it = new Intent(MainActivity.this,Home.class);
					startActivity(it);
				}
				else{
					t_ts.setText("”√ªß√˚√‹¬Î¥ÌŒÛ");
				}
			}
		});
        
        b_phone.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(MainActivity.this,Phone.class);
				startActivity(it);
			}
		});
        
        b_sign.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,Login.class);
				startActivity(intent);
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
