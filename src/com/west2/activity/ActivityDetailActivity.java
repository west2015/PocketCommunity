package com.west2.activity;

import java.util.ArrayList;
import java.util.List;

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
import android.widget.TextView;

public class ActivityDetailActivity extends Activity{
	private Context mContext;
	private TextView txtTitle;
	private ImageButton btnBack;
	private ListView actualListView;
	private PullToRefreshListView pullToRefreshView;
	private ActivityDetailListAdapter mAdapter;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_detail);
		FindView();
		InitValue();
		SetListener();
	}
	private void FindView(){
		txtTitle = (TextView)findViewById(R.id.activity_detail_txt_title);
		btnBack = (ImageButton)findViewById(R.id.activity_detail_btn_back);
		pullToRefreshView = (PullToRefreshListView)findViewById(R.id.activity_detail_listview);
	}
	private void InitValue(){
		mContext = ActivityDetailActivity.this;
		pullToRefreshView.setMode(Mode.PULL_FROM_START);
		actualListView = pullToRefreshView.getRefreshableView();
		List<Activities> list = new ArrayList<Activities>();
		for(int i=0;i<20;++i){
			list.add(new Activities());
		}
		mAdapter = new ActivityDetailListAdapter(mContext,list);
		actualListView.setAdapter(mAdapter);
	}
	private void SetListener(){
		btnBack.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ActivityDetailActivity.this.finish();
			}
		});
	}
}
