package com.west2.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.pocketcommunity.R;

public class ActivityPostActivity extends Activity{
	private Context mContext;
	private ImageButton btnBack;
	private Button btnCancel,btnSubmit;
	private EditText etTitle,etContent;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_post);
		
		FindView();
		InitValue();
		SetListener();
	}
	private void FindView(){
		btnBack = (ImageButton)findViewById(R.id.activity_post_btn_back);
		btnCancel = (Button)findViewById(R.id.activity_post_btn_cancel);
		btnSubmit = (Button)findViewById(R.id.activity_post_btn_submit);
		etTitle = (EditText)findViewById(R.id.activity_post_txt_title);
		etContent = (EditText)findViewById(R.id.activity_post_txt_description);
	}
	private void InitValue(){
		mContext = ActivityPostActivity.this;
	}
	private void SetListener(){
		btnBack.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ActivityPostActivity.this.finish();
			}
		});
		btnCancel.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ActivityPostActivity.this.finish();
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
