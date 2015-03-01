package com.west2.property;

import com.example.pocketcommunity.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class PropertyRepairActivity extends Activity{
	private Context mContext;
	private EditText txtDescrip;
	private Button btnCancel,btnSubmit;
	private ImageButton btnBack,btnAddImage;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_property_repair);
		
		FindView();
		InitValue();
		SetListener();
	}
	private void FindView(){
		txtDescrip = (EditText)findViewById(R.id.property_repair_txt_description);
		btnBack = (ImageButton)findViewById(R.id.property_repair_btn_back);
		btnAddImage = (ImageButton)findViewById(R.id.property_repair_addimage);
		btnCancel = (Button)findViewById(R.id.property_repair_btn_cancel);
		btnSubmit = (Button)findViewById(R.id.property_repair_btn_submit);
	}
	private void InitValue(){
		mContext = PropertyRepairActivity.this;
	}
	private void SetListener(){
		btnBack.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				PropertyRepairActivity.this.finish();
			}
		});
		btnAddImage.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "Add Image", Toast.LENGTH_SHORT).show();
			}
		});
		btnCancel.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				PropertyRepairActivity.this.finish();
			}
		});
		btnSubmit.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "Submit", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
