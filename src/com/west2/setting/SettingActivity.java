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
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends Activity{
	private Context mContext;
	private TextView txtUsername,txtTel,txtAddress;
	private Button btnLogOff,btnModify,btnTel,btnAddress,btnExpense,btnRepair,btnAdvice,btnShopRecord;
	private ImageButton btnPhoto;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		
		FindView();
		InitValue();
		SetListener();
	}
	private void FindView(){
		btnPhoto = (ImageButton)findViewById(R.id.setting_photo);
		btnModify = (Button)findViewById(R.id.setting_btn_modify);
		btnTel = (Button)findViewById(R.id.setting_btn_tel);
		btnAddress = (Button)findViewById(R.id.setting_btn_address);
		btnExpense = (Button)findViewById(R.id.setting_btn_myexpense);
		btnRepair = (Button)findViewById(R.id.setting_btn_myrepair);
		btnAdvice = (Button)findViewById(R.id.setting_btn_myadvice);
		btnShopRecord = (Button)findViewById(R.id.setting_btn_myshoprecord);
		btnLogOff = (Button)findViewById(R.id.setting_btn_logoff);
		txtUsername = (TextView)findViewById(R.id.setting_text_username);
		txtTel = (TextView)findViewById(R.id.setting_txt_tel);
		txtAddress = (TextView)findViewById(R.id.setting_txt_address);
	}
	private void InitValue(){
		mContext = SettingActivity.this;
	}
	private void SetListener(){
		btnPhoto.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent();
                intent.setType("image/*");
				intent.setAction(Intent.ACTION_GET_CONTENT);
				intent.addCategory(Intent.CATEGORY_OPENABLE);
				
				SettingActivity.this.getParent().startActivityForResult(intent, 1);
				
//				SettingActivity.this.startActivityForResult(intent, 1);
				Log.e("1","!!2!!!");
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
	
	public void changeImage(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK) {
//			Toast.makeText(mContext, "result OK!", Toast.LENGTH_SHORT).show();
			Uri uri = data.getData();
			ContentResolver cr = this.getContentResolver();  
			try {  
				Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
				btnPhoto.setImageBitmap(bitmap);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
//			Toast.makeText(mContext, "result FAIL!", Toast.LENGTH_SHORT).show();
		}
	}  
}
