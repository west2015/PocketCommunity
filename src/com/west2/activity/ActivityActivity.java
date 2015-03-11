package com.west2.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.pocketcommunity.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.west2.service.ActivityService;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class ActivityActivity extends Activity{
	private Context mContext;
	private ImageButton btnPost;
	private ListView actualListView;
	
	private List<Activities> listActivity;
	private ActivityListAdapter mAdapter;
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
		listActivity = new ArrayList<Activities>();
		new GetActivitisTask().execute();
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
				Toast.makeText(mContext, "Item " + (position+1), Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(ActivityActivity.this,ActivityDetailActivity.class);
				
				ActivityActivity.this.startActivity(intent);
			}
		});
	}
	class GetActivitisTask extends AsyncTask<Void, Void, Void>{
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			listActivity = ActivityService.getActivities(mContext);
			return null;
		}
		@Override
		protected void onPostExecute(Void result) {
			if(pullToRefreshView.isRefreshing()) pullToRefreshView.onRefreshComplete();
			if(listActivity==null||listActivity.size()==0){
				super.onPostExecute(result);
				return;
			}
			mAdapter = new ActivityListAdapter(mContext, listActivity);
			actualListView.setAdapter(mAdapter);
			mAdapter.notifyDataSetChanged();
			super.onPostExecute(result);
		}
	}
}
