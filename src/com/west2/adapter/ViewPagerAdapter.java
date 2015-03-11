package com.west2.adapter;

import java.util.List;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerAdapter;
import android.view.View;

public class ViewPagerAdapter extends PagerAdapter{
	private List<View> views;
	public ViewPagerAdapter(List<View> views){
		this.views=views;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return views.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0==arg1;
	}
	
	@Override
	public void destroyItem(View container, int position, Object object) {
		((ViewPager)container).removeView(views.get(position));
	}
	
	@Override
	public Object instantiateItem(View container, int position){
		((ViewPager)container).addView(views.get(position));
		return views.get(position);
	}
}
