package com.west2.subactivity.shop;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pocketcommunity.R;

public class ShopListAdapter extends BaseAdapter{
	private Context mContext;
	private List<Shop> listShop;

	public ShopListAdapter(Context context,List<Shop> listShop){
		this.mContext = context;
		this.listShop = listShop;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listShop.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if(view == null){
			holder = new ViewHolder();
			view = LayoutInflater.from(mContext).inflate(R.layout.list_item_shop, null);
			holder.iconImage = (ImageView)view.findViewById(R.id.shop_supermarket_icon);
			holder.textTitle = (TextView)view.findViewById(R.id.shop_super_title);
			view.setTag(holder);
		}else{
			holder = (ViewHolder)view.getTag();
		}
		Shop shop = listShop.get(position);
		holder.textTitle.setText(shop.getName());
		holder.iconImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.shop_shop_icon));
		return view;
	}
	
    class ViewHolder{
    	ImageView iconImage;
    	TextView textTitle;
	}
}