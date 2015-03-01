package com.west2.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.pocketcommunity.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

public class ActivityActivity extends Activity{
	private Context mContext;
	private ImageButton btnPost;
	private ListView actualListView;
	private PullToRefreshListView pullToRefreshView;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity);
		
		FindView();
		InitValue();
		SetListener();
	}
	private void FindView(){
		btnPost = (ImageButton)findViewById(R.id.activity_btn_post);
		pullToRefreshView = (PullToRefreshListView)findViewById(R.id.activity_listview);
	}
	private void InitValue(){
		mContext = ActivityActivity.this;
		pullToRefreshView.setMode(Mode.BOTH);
		actualListView = pullToRefreshView.getRefreshableView();
		List<Activities> listActivity = new ArrayList<Activities>();
		for(int i=0;i<20;++i){
			listActivity.add(new Activities(false,"这是第"+i+"个活动","无","管理员 12-26","回复20"));
		}
		actualListView.setAdapter(new ActivityListAdapter(mContext,listActivity));
	}
	private void SetListener(){
		btnPost.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ActivityActivity.this,ActivityPostActivity.class);
				ActivityActivity.this.startActivity(intent);
			}
		});
		pullToRefreshView.setOnRefreshListener(new OnRefreshListener<ListView>(){
			@Override
			public void onRefresh(PullToRefreshBase refreshView) {
				// TODO Auto-generated method stub
				
			}
		});
		actualListView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
