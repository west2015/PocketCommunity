package com.west2.register;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.pocketcommunity.R;
import com.west2.service.ViewService;

public class RegisterActivity extends Activity{
	private Context mContext;
	private int cntPage;
	private Button btnNext,btnFinish;
	private ImageButton btnBack;
	private EditText etUsername,etPassword_1,etPassword_2;
	private EditText etName,etTel,etAddress;
	private LinearLayout layoutFirst,layoutSecond;
	private ViewService viewService;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		FindView();
		InitValue();
		SetListener();
	}
	private void FindView(){
		btnBack = (ImageButton)findViewById(R.id.register_btnback);
		layoutFirst = (LinearLayout)findViewById(R.id.register_layout_first);
		etUsername = (EditText)findViewById(R.id.register_username);
		etPassword_1 = (EditText)findViewById(R.id.register_password_1);
		etPassword_2 = (EditText)findViewById(R.id.register_password_2);
		btnNext = (Button)findViewById(R.id.register_btnnextstep);
		layoutSecond = (LinearLayout)findViewById(R.id.register_layout_second);
		etName = (EditText)findViewById(R.id.register_name);
		etTel = (EditText)findViewById(R.id.register_tel);
		etAddress = (EditText)findViewById(R.id.register_address);
		btnFinish = (Button)findViewById(R.id.register_btnfinish); 
	}
	private void InitValue(){
		cntPage = 1;
		mContext = RegisterActivity.this;
		viewService = new ViewService(mContext);
		LayoutParams params = (LayoutParams) layoutSecond.getLayoutParams();
		params.setMargins(viewService.GetScrWidth(), 0, 0, 0);
		layoutSecond.setLayoutParams(params);
	}
	private void SetListener(){
		btnBack.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(cntPage == 1){
					RegisterActivity.this.finish();
				}
				else{
					changePage();
					--cntPage;
				}
			}
		});
		btnNext.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int res = check(cntPage);
				if(res==0){
					changePage();
					++cntPage;
				}
				else{
					switch(res){
					case 1:break;
					case 2:break;
					case 3:break;
					case 4:break;
					case 5:break;
					case 6:break;
					}
				}
			}
		});
		btnFinish.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				RegisterActivity.this.finish();
			}
		});
	}
	private int check(int step){
//		if(step == 1){
//			String username = etUsername.getText().toString();
//			if(username==null || username.equals("")) return 1;
//			String psw_1 = etPassword_1.getText().toString();
//			if(psw_1==null || psw_1.equals("")) return 2;
//			String psw_2 = etPassword_2.getText().toString();
//			if(psw_2==null || !psw_2.endsWith(psw_1)) return 3;
//		}
//		else
//		if(step == 2){
//			String name = etName.getText().toString();
//			if(name==null || name.equals("")) return 4;
//			String tel = etTel.getText().toString();
//			if(tel==null || tel.equals("")) return 5;
//			String address = etAddress.getText().toString();
//			if(address==null || address.equals("")) return 6;
//		}
		return 0;
	}
	private void changePage(){
		Toast.makeText(mContext, "cntPage = " + cntPage, Toast.LENGTH_SHORT).show();
		if(cntPage == 1){
			LayoutParams params;
			TranslateAnimation animSecond;
			layoutSecond.clearAnimation();
			animSecond = new TranslateAnimation(
					Animation.RELATIVE_TO_SELF, 1.0f,
					Animation.RELATIVE_TO_SELF, 0.0f,
					Animation.RELATIVE_TO_SELF, 0.0f,
					Animation.RELATIVE_TO_SELF, 0.0f);
			animSecond.setFillAfter(false);
			animSecond.setDuration(300);
			layoutSecond.setVisibility(View.INVISIBLE);
			layoutSecond.startAnimation(animSecond);
			params = (LayoutParams) layoutSecond.getLayoutParams();
			params.setMargins(0, 0, 0, 0);
			layoutSecond.setLayoutParams(params);
			layoutSecond.setVisibility(View.VISIBLE);
		}
		else{
			TranslateAnimation animSecond;
			layoutSecond.clearAnimation();
			animSecond = new TranslateAnimation(
					Animation.RELATIVE_TO_SELF, 0.0f,
					Animation.RELATIVE_TO_SELF, 1.0f,
					Animation.RELATIVE_TO_SELF, 0.0f,
					Animation.RELATIVE_TO_SELF, 0.0f);
			animSecond.setFillAfter(true);
			animSecond.setDuration(300);
			layoutSecond.startAnimation(animSecond);
			animSecond.setAnimationListener(new AnimationListener(){
				@Override
				public void onAnimationEnd(Animation arg0) {
					// TODO Auto-generated method stub
					LayoutParams params = (LayoutParams) layoutSecond.getLayoutParams();
					params.setMargins(viewService.GetScrWidth(), 0, 0, 0);
					layoutSecond.setLayoutParams(params);
				}
				@Override
				public void onAnimationRepeat(Animation arg0) {
					// TODO Auto-generated method stub
				}
				@Override
				public void onAnimationStart(Animation arg0) {
					// TODO Auto-generated method stub
				}
			});
		}
	}
	@Override
	public boolean onKeyDown(int KeyCode,KeyEvent event){
		if(KeyCode == KeyEvent.KEYCODE_BACK){
			if(cntPage == 1){
				RegisterActivity.this.finish();
			}
			else{
				changePage();
				--cntPage;
			}
		}
		return false;
	}
}
