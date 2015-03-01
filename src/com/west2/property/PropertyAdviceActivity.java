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

public class PropertyAdviceActivity extends Activity{
	private Context mContext;
	private EditText txtDescrip;
	private ImageButton btnBack;
	private Button btnCancel,btnSubmit;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_property_advice);
		FindView();
		InitValue();
		SetListener();
	}
	private void FindView(){
		txtDescrip = (EditText)findViewById(R.id.property_advice_txt_description);
		btnBack = (ImageButton)findViewById(R.id.property_advice_btn_back);
		btnCancel = (Button)findViewById(R.id.property_advice_btn_cancel);
		btnSubmit = (Button)findViewById(R.id.property_advice_btn_submit);
	}
	private void InitValue(){
		mContext = PropertyAdviceActivity.this;
	}
	private void SetListener(){
		btnBack.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				PropertyAdviceActivity.this.finish();
			}
		});
		btnCancel.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				PropertyAdviceActivity.this.finish();
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
