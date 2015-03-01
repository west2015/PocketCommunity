package com.west2.main;

import java.util.ArrayList;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pocketcommunity.R;
import com.west2.activity.ActivityActivity;
import com.west2.adapter.ViewPagerAdapter;
import com.west2.notice.NoticeActivity;
import com.west2.property.PropertyActivity;
import com.west2.setting.SettingActivity;
import com.west2.shop.ShopActivity;

public class MainActivity extends Activity{
	final private int[] titleId = {R.string.main_notice_title,R.string.main_property_title,R.string.main_shop_title,R.string.main_activity_title,R.string.main_setting_title};
	final private String[] names = {"NoticeActivity","PropertyActivity","ShopActivity","ActivityActivity","SettingActivity"};
	final private Class<?>[] classs = {NoticeActivity.class,PropertyActivity.class,ShopActivity.class,ActivityActivity.class,SettingActivity.class};
	private ViewPager viewpager;
	private Button btnNotice,btnProperty,btnShop,btnActivity,btnSetting;
	private TextView txtNotice,txtProperty,txtShop,txtActivity,txtSetting;
	private ImageView imgNotice,imgProperty,imgShop,imgActivity,imgSetting;
	
	private Context mContext;
	private LocalActivityManager mManager;
	
	private int curItem;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mManager = new LocalActivityManager(this,true);
		mManager.dispatchCreate(savedInstanceState);
		
		FindView();
		InitValue();
		SetListener();
	}
	private void FindView(){
		viewpager = (ViewPager)findViewById(R.id.main_viewpager);
		btnNotice = (Button)findViewById(R.id.main_btn_notice);
		btnProperty = (Button)findViewById(R.id.main_btn_property);
		btnShop = (Button)findViewById(R.id.main_btn_shop);
		btnActivity = (Button)findViewById(R.id.main_btn_activity);
		btnSetting = (Button)findViewById(R.id.main_btn_setting);
		imgNotice = (ImageView)findViewById(R.id.main_img_notice);
		imgProperty = (ImageView)findViewById(R.id.main_img_property);
		imgShop = (ImageView)findViewById(R.id.main_img_shop);
		imgActivity = (ImageView)findViewById(R.id.main_img_activity);
		imgSetting = (ImageView)findViewById(R.id.main_img_setting);
		txtNotice = (TextView)findViewById(R.id.main_txt_notice);
		txtProperty = (TextView)findViewById(R.id.main_txt_property);
		txtShop = (TextView)findViewById(R.id.main_txt_shop);
		txtActivity = (TextView)findViewById(R.id.main_txt_activity);
		txtSetting = (TextView)findViewById(R.id.main_txt_setting);
	}
	private void InitValue(){
		mContext = MainActivity.this;
		ArrayList<View> views = new ArrayList<View>();
		for(int i=0;i<names.length;++i){
			Intent intent = new Intent(mContext,classs[i]);
			views.add(GetView(names[i],intent));
		}
		viewpager.setAdapter(new ViewPagerAdapter(views));
		curItem = 0;
		LightItem(curItem);
		viewpager.setCurrentItem(curItem);
	}
	private void SetListener(){
		btnNotice.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DarkItem(curItem);curItem = 0;LightItem(curItem);
				viewpager.setCurrentItem(curItem, false);
			}
		});
		btnProperty.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DarkItem(curItem);curItem = 1;LightItem(curItem);
				viewpager.setCurrentItem(curItem, false);
			}
		});
		btnShop.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DarkItem(curItem);curItem = 2;LightItem(curItem);
				viewpager.setCurrentItem(curItem, false);
			}
		});
		btnActivity.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DarkItem(curItem);curItem = 3;LightItem(curItem);
				viewpager.setCurrentItem(curItem, false);
			}
		});
		btnSetting.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DarkItem(curItem);curItem = 4;LightItem(curItem);
				viewpager.setCurrentItem(curItem, false);
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
				DarkItem(curItem);curItem = position;LightItem(curItem);
			}
		});
	}
	private View GetView(String id,Intent intent){
		if(intent == null) return null;
		return mManager.startActivity(id, intent).getDecorView();
	}
	private void DarkItem(int position){
		switch(position){
		case 0:
			imgNotice.setImageDrawable(mContext.getResources().getDrawable(R.drawable.main_icon_1));
			txtNotice.setTextColor(mContext.getResources().getColor(R.color.black_grey));
			break;
		case 1:
			imgProperty.setImageDrawable(mContext.getResources().getDrawable(R.drawable.property_icon_1));
			txtProperty.setTextColor(mContext.getResources().getColor(R.color.black_grey));
			break;
		case 2:
			imgShop.setImageDrawable(mContext.getResources().getDrawable(R.drawable.shop_icon_1));
			txtShop.setTextColor(mContext.getResources().getColor(R.color.black_grey));
			break;
		case 3:
			imgActivity.setImageDrawable(mContext.getResources().getDrawable(R.drawable.activity_icon_1));
			txtActivity.setTextColor(mContext.getResources().getColor(R.color.black_grey));
			break;
		case 4:
			imgSetting.setImageDrawable(mContext.getResources().getDrawable(R.drawable.setting_icon_1));
			txtSetting.setTextColor(mContext.getResources().getColor(R.color.black_grey));
			break;
		}
	}
	private void LightItem(int position){
		switch(position){
		case 0:
			imgNotice.setImageDrawable(mContext.getResources().getDrawable(R.drawable.main_icon_2));
			txtNotice.setTextColor(mContext.getResources().getColor(R.color.blue));
			break;
		case 1:
			imgProperty.setImageDrawable(mContext.getResources().getDrawable(R.drawable.property_icon_2));
			txtProperty.setTextColor(mContext.getResources().getColor(R.color.blue));
			break;
		case 2:
			imgShop.setImageDrawable(mContext.getResources().getDrawable(R.drawable.shop_icon_2));
			txtShop.setTextColor(mContext.getResources().getColor(R.color.blue));
			break;
		case 3:
			imgActivity.setImageDrawable(mContext.getResources().getDrawable(R.drawable.activity_icon_2));
			txtActivity.setTextColor(mContext.getResources().getColor(R.color.blue));
			break;
		case 4:
			imgSetting.setImageDrawable(mContext.getResources().getDrawable(R.drawable.setting_icon_2));
			txtSetting.setTextColor(mContext.getResources().getColor(R.color.blue));
			break;
		}
	}
}
