package com.west2.property;

import com.example.pocketcommunity.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class PropertyExpenseActivity extends Activity{
	private Context mContext;
	private ImageButton btnBack;
	private Button btnAddress,btnBalance,btnUnpaid,btnDeposit,btnHistory;
	private TextView txtUser,txtAddress,txtBalance,txtUnpaid,txtDeposit;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_property_expense);
		
		FindView();
		InitValue();
		SetListener();
	}
	private void FindView(){
		btnBack = (ImageButton)findViewById(R.id.property_expense_btn_back);
		btnAddress = (Button)findViewById(R.id.property_expense_btn_address);
		btnBalance = (Button)findViewById(R.id.property_expense_btn_balance);
		btnUnpaid = (Button)findViewById(R.id.property_expense_btn_unpaid);
		btnDeposit = (Button)findViewById(R.id.property_expense_btn_deposit);
		btnHistory = (Button)findViewById(R.id.property_expense_btn_history);
		txtUser = (TextView)findViewById(R.id.property_expense_txt_username);
		txtAddress = (TextView)findViewById(R.id.property_expense_txt_address);
		txtBalance = (TextView)findViewById(R.id.property_expense_txt_balance);
		txtUnpaid = (TextView)findViewById(R.id.property_expense_txt_unpaid);
		txtDeposit = (TextView)findViewById(R.id.property_expense_txt_deposit);
	}
	private void InitValue(){
		mContext = PropertyExpenseActivity.this;
	}
	private void SetListener(){
		btnBack.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				PropertyExpenseActivity.this.finish();
			}
		});
		btnAddress.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "Address", Toast.LENGTH_SHORT).show();
			}
		});
		btnBalance.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "Balance", Toast.LENGTH_SHORT).show();
			}
		});
		btnUnpaid.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "Unpaid", Toast.LENGTH_SHORT).show();
			}
		});
		btnDeposit.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "Deposit", Toast.LENGTH_SHORT).show();
			}
		});
		btnHistory.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "History", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
