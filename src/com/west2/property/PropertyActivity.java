package com.west2.property;

import com.example.pocketcommunity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class PropertyActivity extends Activity{
	private ImageButton btnMsg,btnExpense,btnRepair,btnAdvice;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_property);
		
		FindView();
		InitValue();
		SetListener();
	}
	private void FindView(){
		btnMsg = (ImageButton)findViewById(R.id.property_btn_msg);
		btnExpense = (ImageButton)findViewById(R.id.property_btn_expense);
		btnRepair = (ImageButton)findViewById(R.id.property_btn_repair);
		btnAdvice = (ImageButton)findViewById(R.id.property_btn_advice);
	}
	private void InitValue(){
		
	}
	private void SetListener(){
		btnMsg.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(PropertyActivity.this,PropertyMsgActivity.class);
				PropertyActivity.this.startActivity(intent);
			}
		});
		btnExpense.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(PropertyActivity.this,PropertyExpenseActivity.class);
				PropertyActivity.this.startActivity(intent);
			}
		});
		btnRepair.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(PropertyActivity.this,PropertyRepairActivity.class);
				PropertyActivity.this.startActivity(intent);
			}
		});
		btnAdvice.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(PropertyActivity.this,PropertyAdviceActivity.class);
				PropertyActivity.this.startActivity(intent);
			}
		});
	}
}
