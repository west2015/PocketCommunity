package com.west2.setting;

import com.example.pocketcommunity.R;
import com.west2.login.LoginActivity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends Activity{
	private Context mContext;
	private TextView textUsername;
	private Button btnLogOff,btnTel,btnAddress;
	private ImageButton btnPhoto,btnModify,btnMyExpense,btnMyRepair,
			btnMyAdvice,btnMyShopRecord,btnHelp,btnUpdate;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		
		FindView();
		InitValue();
		SetListener();
	}
	private void FindView(){
		btnPhoto = (ImageButton)findViewById(R.id.setting_photo);
		textUsername = (TextView)findViewById(R.id.setting_text_username);
		btnModify = (ImageButton)findViewById(R.id.setting_btn_modify);
		btnTel = (Button)findViewById(R.id.setting_btn_tel);
		btnAddress = (Button)findViewById(R.id.setting_btn_address);
		btnMyExpense = (ImageButton)findViewById(R.id.setting_btn_myexpense);
		btnMyRepair = (ImageButton)findViewById(R.id.setting_btn_myrepair);
		btnMyAdvice = (ImageButton)findViewById(R.id.setting_btn_myadvice);
		btnMyShopRecord = (ImageButton)findViewById(R.id.setting_btn_myshoprecord);
		btnLogOff = (Button)findViewById(R.id.setting_btn_logoff);
		btnHelp = (ImageButton)findViewById(R.id.setting_btn_help);
		btnUpdate = (ImageButton)findViewById(R.id.setting_btn_update);
	}
	private void InitValue(){
		mContext = SettingActivity.this;
	}
	private void SetListener(){
		btnPhoto.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setType("image/*");
				intent.setAction(Intent.ACTION_GET_CONTENT);
				intent.addCategory(Intent.CATEGORY_OPENABLE);
				SettingActivity.this.startActivityForResult(intent,0);
			}
		});
		btnModify.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnTel.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnAddress.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnMyExpense.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnMyRepair.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnMyAdvice.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnMyShopRecord.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnHelp.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnUpdate.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnMyExpense.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnLogOff.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SettingActivity.this,LoginActivity.class);
				SettingActivity.this.finish();
				SettingActivity.this.startActivity(intent);
			}
		});
	}
	@Override  
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Toast.makeText(mContext, "result OK!", Toast.LENGTH_SHORT).show();
		
//		if(resultCode == RESULT_OK) {
//			Toast.makeText(mContext, "result OK!", Toast.LENGTH_SHORT).show();
//			Uri uri = data.getData();
//			ContentResolver cr = this.getContentResolver();  
//			try {  
//				Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
//				btnPhoto.setImageBitmap(bitmap);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		else
//			Toast.makeText(mContext, "result FAIL!", Toast.LENGTH_SHORT).show();
	}  
}
