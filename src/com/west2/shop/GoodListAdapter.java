package com.west2.shop;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pocketcommunity.R;

public class GoodListAdapter extends BaseAdapter{
	private Context mContext;
	private List<Item> listItem;

	public GoodListAdapter(Context context,List<Item> listItem){
		this.mContext = context;
		this.listItem = listItem;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listItem.size();
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
			view = LayoutInflater.from(mContext).inflate(R.layout.list_item_good, null);
			holder.txtName = (TextView)view.findViewById(R.id.myshop_good_txt_name);
			holder.txtPrice = (TextView)view.findViewById(R.id.myshop_good_txt_price);
			view.setTag(holder);
		}else{
			holder = (ViewHolder)view.getTag();
		}
		Item item = listItem.get(position);
		holder.txtName.setText(item.getName());
		holder.txtPrice.setText("µ¥¼Û:£¤"+item.getPrice());
		return view;
	}
	
    private class ViewHolder{
    	TextView txtName,txtPrice;
	}
}