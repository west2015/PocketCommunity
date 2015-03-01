package com.west2.login;

import com.example.pocketcommunity.R;
import com.west2.main.MainActivity;
import com.west2.register.RegisterActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity{
	private Context mContext;
	
	private EditText inUsername,inPassword;
	private Button btnCantLogin,btnNewAccount,btnLogin;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_login);
		findView();
		initValue();
		setListener();
	}
	void findView(){
		inUsername = (EditText)findViewById(R.id.login_username);
		inPassword = (EditText)findViewById(R.id.login_password);
		btnLogin = (Button)findViewById(R.id.login_btnlogin);
		btnCantLogin = (Button)findViewById(R.id.login_btn_cant_login);
		btnNewAccount = (Button)findViewById(R.id.login_btn_new_account);
	}
	void initValue(){
		mContext = LoginActivity.this;
	}
	void setListener(){
		btnLogin.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SkipPage(MainActivity.class,1);
			}
		});
		btnCantLogin.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewAccount.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
				LoginActivity.this.startActivity(intent);
			}
		});
	}
	private void SkipPage(Class<?> pageClass,int isFinish){
		Intent intent = new Intent(mContext,pageClass);
		mContext.startActivity(intent);
		switch(isFinish){
			case 0:break;
			case 1:LoginActivity.this.finish();break;
		}
	}
}
