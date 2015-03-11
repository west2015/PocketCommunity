package com.west2.subactivity.property;

import com.example.pocketcommunity.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

public class PropertyMsgActivity extends Activity{
	private Context mContext;
	private ImageButton btnBack;
	private ListView actualListView;
	private PullToRefreshListView pullToRefreshView;

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_property_message);
		
		FindView();
		InitValue();
		SetListener();
	}
	private void FindView(){
		mContext = PropertyMsgActivity.this;
		btnBack = (ImageButton)findViewById(R.id.property_msg_btn_back);
		pullToRefreshView = (PullToRefreshListView)findViewById(R.id.property_msg_listview);
	}
	private void InitValue(){
		pullToRefreshView.setMode(Mode.BOTH);
		actualListView = pullToRefreshView.getRefreshableView();
	}
	private void SetListener(){
		btnBack.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				PropertyMsgActivity.this.finish();
			}
		});
	}
}
