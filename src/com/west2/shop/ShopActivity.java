package com.west2.shop;

import java.util.ArrayList;
import java.util.List;

import com.example.pocketcommunity.R;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.west2.service.ShopService;
import com.west2.service.ViewService;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class ShopActivity extends Activity{
	private Context mContext;
	private ListView actualListView;
	private PullToRefreshListView pullToRefreshView;
	private boolean menuIsShow;
	private LinearLayout layoutMenu;
	private ImageButton btnMenu,btnRecord,btnMyShop;
	private ViewService viewService;
	
	private List<Shop> listShop;
	private ShopListAdapter mAdapter;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shop);
		
		FindView();
		InitValue();
		SetListener();
	}
	private void FindView(){
		btnMenu = (ImageButton)findViewById(R.id.shop_btn_menu);
		btnRecord = (ImageButton)findViewById(R.id.shop_btn_record);
		btnMyShop = (ImageButton)findViewById(R.id.shop_btn_myshop);
		layoutMenu = (LinearLayout)findViewById(R.id.shop_layout_menu);
		pullToRefreshView = (PullToRefreshListView)findViewById(R.id.shop_listview);
	}
	private void InitValue(){
		mContext = ShopActivity.this;
		viewService = new ViewService(mContext);
		LayoutParams params = (LayoutParams) layoutMenu.getLayoutParams();
		params.width = viewService.GetScrWidth();
		params.height = viewService.GetTitleHeight() * 2;
		layoutMenu.setLayoutParams(params);
		pullToRefreshView.setMode(Mode.BOTH);
		actualListView = pullToRefreshView.getRefreshableView();
		listShop = new ArrayList<Shop>();
		for(int i=0;i<10;++i){
			listShop.add(new Shop("Íò¼Î³¬ÊÐ("+(i+1)+")"));
		}
		actualListView.setAdapter(new ShopListAdapter(mContext,listShop));
		
		new GetShopListTask().execute();
		menuIsShow = false;
	}
	private void SetListener(){
		btnMenu.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(menuIsShow){
					HideMenu();
				}
				else{
					ShowMenu();
				}
			}
		});
		btnRecord.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "Shop Record", Toast.LENGTH_SHORT).show();
			}
		});
		btnMyShop.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "My Shop", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(ShopActivity.this,MyShopActivity.class);
				ShopActivity.this.startActivity(intent);
			}
		});
	}
	private void ShowMenu(){
		TranslateAnimation mShowAction = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.0f,
				Animation.RELATIVE_TO_SELF, -1.0f,
				Animation.RELATIVE_TO_SELF, 0.0f);
		mShowAction.setDuration(300);
		mShowAction.setFillAfter(true);
		layoutMenu.setVisibility(View.GONE);
		layoutMenu.startAnimation(mShowAction);
		LayoutParams params = (LayoutParams) layoutMenu.getLayoutParams();
		params.setMargins(0, viewService.GetTitleHeight(), 0, 0);
		layoutMenu.setLayoutParams(params);
		layoutMenu.setVisibility(View.VISIBLE);
		menuIsShow = true;
		btnMenu.setImageDrawable(mContext.getResources().getDrawable(R.drawable.menu_in_icon));
	}
	private void HideMenu(){
		TranslateAnimation mShowAction = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.5f,
				Animation.RELATIVE_TO_SELF, -0.5f);
		mShowAction.setDuration(300);
		mShowAction.setFillAfter(false);
		layoutMenu.setVisibility(View.GONE);
		layoutMenu.startAnimation(mShowAction);
		LayoutParams params = (LayoutParams) layoutMenu.getLayoutParams();
		params.setMargins(0, 0, viewService.GetTitleHeight()+viewService.GetBarHeight(), 0);
		layoutMenu.setLayoutParams(params);
		layoutMenu.setVisibility(View.VISIBLE);
		mShowAction.setAnimationListener(new AnimationListener(){
			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				layoutMenu.setVisibility(View.GONE);
			}
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
			}
		});
		btnMenu.setImageDrawable(mContext.getResources().getDrawable(R.drawable.menu_out_icon));
		menuIsShow = false;
	}
	
	
	class GetShopListTask extends AsyncTask<Void, Void, Void>{

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			listShop = ShopService.getShops(mContext);
			
			return null;
		}
		
		protected void onPostExecute(Void result) {
			
//			if(mAdapter==null){
				mAdapter = new ShopListAdapter(mContext, listShop);
				actualListView.setAdapter(mAdapter);
//			}
			mAdapter.notifyDataSetChanged();
			
			super.onPostExecute(result);
		}
		
	}
	
	
}
