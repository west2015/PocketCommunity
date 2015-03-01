package com.west2.service;

import java.lang.reflect.Field;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.WindowManager;

public class ViewService {
	private final String SHARE_NAME = "VIEW";
	private final String TITLE_HEIGHT = "TITLE_HEIGHT";
	private SharedPreferences share;
	private int scrWidth;
	private int scrHeight;
	private int barHeight;
	private Context mContext;
	private int titleHeight;
	public ViewService(Context context){
		this.mContext=context;
		share = mContext.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
		getStatusBarHeight();
		WindowManager window = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
		scrWidth = window.getDefaultDisplay().getWidth();
		scrHeight = window.getDefaultDisplay().getHeight()-barHeight;
	}
	public void SetTitleHeight(int height){
		Editor edit = share.edit();
		edit.putInt(TITLE_HEIGHT, height);
		edit.commit();
	}
	public int GetBarHeight(){
		return this.barHeight;
	}
	public int GetTitleHeight(){
		int height = share.getInt(TITLE_HEIGHT, 0);
		if(height <= 0) return scrHeight/11;
		return height;
	}
	public int GetScrWidth(){
		return scrWidth;
	}
	public int GetScrHeight(){
		return scrHeight;
	}
	public int GetRealHeight(){
		return scrHeight + barHeight;
	}
	private void getStatusBarHeight(){
		try{
			Class<?> mClass = Class.forName("com.android.internal.R$dimen");
			Object mObject = mClass.newInstance();
			Field mField = mClass.getField("status_bar_height");
			int mHeight = Integer.parseInt(mField.get(mObject).toString());
			barHeight = mContext.getResources().getDimensionPixelSize(mHeight);
		}catch(Exception e) {
			barHeight = 0;
		}
	}
}
