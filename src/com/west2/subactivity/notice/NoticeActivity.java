package com.west2.subactivity.notice;

import java.util.ArrayList;
import java.util.List;

import com.example.pocketcommunity.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.west2.adapter.NoticeListAdapter;
import com.west2.adapter.ViewPagerAdapter;
import com.west2.entity.Notice;
import com.west2.service.NoticeService;
import com.west2.service.ViewService;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;

public class NoticeActivity extends Activity{
	final int[] dotId = {R.id.notice_dot_1,R.id.notice_dot_2,R.id.notice_dot_3};
	final int[] imageId = {R.drawable.main_image_1,R.drawable.main_image_2,R.drawable.main_image_3};

	private ViewPager viewpager;
	private TextView textAbout;
	private ListView actualListView;
	private PullToRefreshListView pullToRefreshView;
	private ImageView[] dot;
	private LinearLayout titleLayout;
	
	private List<Notice> listNotice;
	private NoticeListAdapter mNoticeAdapter;

	private int curItem;
	private Context mContext;
	private ViewTreeObserver viewObserver;
	private boolean hasMeasure;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notice);

		findView();
		initValue();
		setListener();
	}
	private void findView(){
		titleLayout = (LinearLayout)findViewById(R.id.notice_title);
		viewpager = (ViewPager)findViewById(R.id.notice_viewpager);
		textAbout = (TextView)findViewById(R.id.notice_text_about);
		pullToRefreshView = (PullToRefreshListView)findViewById(R.id.notice_listview);
		dot = new ImageView[dotId.length];
		for(int i=0;i<dotId.length;++i) dot[i] = (ImageView)findViewById(dotId[i]);
	}
	private void initValue(){
		mContext = NoticeActivity.this;
		hasMeasure = false;
		viewObserver = titleLayout.getViewTreeObserver();
		curItem = 0;
		BlackDot(curItem);
		LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
		List<View> views = new ArrayList<View>();
		views.add(inflater.inflate(R.layout.notice_image_1, null));
		views.add(inflater.inflate(R.layout.notice_image_2, null));
		views.add(inflater.inflate(R.layout.notice_image_3, null));
		viewpager.setAdapter(new ViewPagerAdapter(views));
		
		pullToRefreshView.setMode(Mode.BOTH);
		actualListView = pullToRefreshView.getRefreshableView();
		listNotice = new ArrayList<Notice>();
//		for(int i=0;i<20;++i){
//			listNotice.add(new Notice("这是第"+i+"条公告","12-26",""));
//		}
//		actualListView.setAdapter(new NoticeListAdapter(mContext,listNotice));
		new GetNoticesTask().execute();
		
	}
	private void setListener(){
		pullToRefreshView.setOnRefreshListener(new OnRefreshListener<ListView>(){
			@Override
			public void onRefresh(PullToRefreshBase refreshView) {
				// TODO Auto-generated method stub
				new GetNoticesTask().execute();
			}
		});
		actualListView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				
			}
		});
		viewpager.setOnPageChangeListener(new OnPageChangeListener(){
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				GreyDot(curItem);
				curItem = position;
				BlackDot(curItem);
			}
		});
		viewObserver.addOnPreDrawListener(new OnPreDrawListener(){
			@Override
			public boolean onPreDraw() {
				// TODO Auto-generated method stub
				if(!hasMeasure){
					Log.e("notice", "title height = " + titleLayout.getMeasuredHeight());
					new ViewService(mContext).SetTitleHeight(titleLayout.getMeasuredHeight());
					hasMeasure = true;
				}
				return true;
			}
		});
	}
	private void BlackDot(int position){
		dot[position].setImageDrawable(mContext.getResources().getDrawable(R.drawable.black_dot));
	}
	private void GreyDot(int position){
		dot[position].setImageDrawable(mContext.getResources().getDrawable(R.drawable.grey_dot));		
	}
	
	
	private class GetNoticesTask extends AsyncTask<Void, Void, Void>{

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			
			listNotice=NoticeService.getNotices(mContext);
			return null;
		}
		@Override
		protected void onPostExecute(Void result) {
			
			if(pullToRefreshView.isRefreshing()) pullToRefreshView.onRefreshComplete();
			
//			if(mNoticeAdapter==null){
				mNoticeAdapter = new NoticeListAdapter(mContext, listNotice);
				actualListView.setAdapter(mNoticeAdapter);
//			}
			mNoticeAdapter.notifyDataSetChanged();
			
			super.onPostExecute(result);
		}
		
	}
	
	
	
}
