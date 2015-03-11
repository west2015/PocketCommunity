package com.west2.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pocketcommunity.R;
import com.west2.domain.User;
import com.west2.main.MainActivity;
import com.west2.register.RegisterActivity;
import com.west2.service.DataService;
import com.west2.service.UserService;

public class LoginActivity extends Activity{
	private Context mContext;
	
	private EditText inUsername,inPassword;
	private Button btnCantLogin,btnNewAccount,btnLogin;
	private User mUser;
	
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
		mUser = new User();
	}
	void setListener(){
		btnLogin.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				SkipPage(MainActivity.class,1);
				new Thread(login).start();
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
	
	
	Handler mHandle = new Handler(){
		
		public void handleMessage(Message msg){
			
			switch (msg.what) {
			case 0:
				DataService dataSer = new DataService(LoginActivity.this);
				Log.e("YAO", dataSer.saveUserMes(mUser)+"DATASERVICE");
				SkipPage(MainActivity.class,1);
				break;
			case 1:
				Toast.makeText(mContext, "网络错误?请重试", Toast.LENGTH_SHORT).show();
				break;
			case 2:
				Toast.makeText(mContext, "用户名不存在或密码错误", Toast.LENGTH_SHORT).show();
				break;
			}
		}
		
	};
	
	
	Runnable login = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			 mUser.setName(inUsername.getText().toString());
			 mUser.setPass(inPassword.getText().toString());
			Message msg = new Message();
			msg.what=UserService.login(mContext, mUser);
			
			Log.e("YAO", new DataService(LoginActivity.this).getUserName()+"!!!");
			mHandle.sendMessage(msg);
		}
	};
	
	
	
}
