package com.west2.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.pocketcommunity.R;
import com.material.widget.RaisedButton;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.listeners.ActionClickListener;
import com.west2.entity.User;
import com.west2.service.DataService;
import com.west2.service.UserService;
import com.west2.utils.InfoUtils;

public class LoginActivity extends Activity{

	private Context mContext;

	private User mUser;
	private boolean isLogining;

	private EditText inUsername,inPassword;
	private Button btnCantLogin,btnNewAccount;
	private RaisedButton btnLogin;
	private ProgressBar pb;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		findView();
		initValue();
		setListener();
	}

	void findView(){
		inUsername = (EditText)findViewById(R.id.login_username);
		inPassword = (EditText)findViewById(R.id.login_password);
		btnCantLogin = (Button)findViewById(R.id.login_btn_cant_login);
		btnNewAccount = (Button)findViewById(R.id.login_btn_new_account);
		btnLogin = (RaisedButton)findViewById(R.id.login_btnlogin);
		pb = (ProgressBar) findViewById(R.id.pb);
	}

	void initValue(){
		mContext = this;
		mUser = new User();
		isLogining = false;
	}

	void setListener(){
		// 登陆
		btnLogin.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				if(!isLogining){
					sendMessage(InfoUtils.LOGIN);
				}
			}
		});
		// 无法登陆
		btnCantLogin.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
			}
		});
		// 新用户
		btnNewAccount.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
				LoginActivity.this.startActivity(intent);
			}
		});
	}	
	
	Handler mHandler = new Handler(){
		public void handleMessage(Message msg){
			if(InfoUtils.LOGIN<=msg.what && msg.what<=InfoUtils.LOGIN_WRONG_INPUT){
				isLogining = false;
				pb.setVisibility(View.GONE);
			}
			switch (msg.what) {
			case InfoUtils.LOGIN:
				if(isLegalInput()){
					pb.setVisibility(View.VISIBLE);
					new Thread(login).start();
				}
				break;
			case InfoUtils.LOGIN_SUCCEED:
				DataService dataSer = new DataService(LoginActivity.this);
				SkipPage(MainActivity.class,true);
				break;
			case InfoUtils.LOGIN_NET_ERROR:
				SnackbarManager.show(
                        Snackbar.with(LoginActivity.this)
                                .text("遇到错误啦")
                                .actionLabel("重试")
                                .actionColorResource(R.color.yellow_500)
                                .actionListener(new ActionClickListener() {
                                    @Override
                                    public void onActionClicked(Snackbar snackbar) {
                                    	if(!isLogining){
                                    		pb.setVisibility(View.VISIBLE);
                                    		new Thread(login).start();
                                    	}
                                    }
                                }));
				break;
			case InfoUtils.LOGIN_WRONG_INPUT:
				showToast("用户名或密码错误");
				break;
			}
		}
		
	};
	/*
	 * 登陆线程
	 */
	Runnable login = new Runnable() {
		@Override
		public void run() {
			isLogining = true;
			mUser.setName(inUsername.getText().toString());
			mUser.setPass(inPassword.getText().toString());
			sendMessage(UserService.login(mContext, mUser),1000);
		}
	};

	private boolean isLegalInput(){
		String username = inUsername.getText().toString();
		if(username == null || username.equals("")){
			showToast("用户名为空");
			return false;
		}
		String password = inPassword.getText().toString();
		if(password == null || password.equals("")){
			showToast("密码为空");
			return false;
		}
		return true;
	}
	
	private void SkipPage(Class<?> pageClass,boolean isFinish){
		mContext.startActivity(new Intent(mContext,pageClass));
		if(isFinish){
			finish();
		}
	}
	
	private void sendMessage(int message){
		sendMessage(message,0);
	}
	
	private void sendMessage(int message,long delayMillis){
		Message msg = new Message();
		msg.what = message;
		mHandler.sendMessageDelayed(msg, delayMillis);
	}
	
	private void showToast(String msg){
		SnackbarManager.show(
                Snackbar.with(LoginActivity.this).text(msg));
	}
}
