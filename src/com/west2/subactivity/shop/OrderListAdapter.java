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

public class OrderListAdapter extends BaseAdapter{
	private Context mContext;
	private List<Order> listOrder;

	public OrderListAdapter(Context context,List<Order> listOrder){
		this.mContext = context;
		this.listOrder = listOrder;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listOrder.size();
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
			view = LayoutInflater.from(mContext).inflate(R.layout.list_item_order, null);
			holder.txtUser = (TextView)view.findViewById(R.id.myshop_order_user);
			holder.txtTime = (TextView)view.findViewById(R.id.myshop_order_time);
			holder.txtAddress = (TextView)view.findViewById(R.id.myshop_order_address);
			holder.txtTotal = (TextView)view.findViewById(R.id.myshop_order_total);
			holder.txtStatus = (TextView)view.findViewById(R.id.myshop_order_status);
			view.setTag(holder);
		}else{
			holder = (ViewHolder)view.getTag();
		}
		Order order = listOrder.get(position);
		holder.txtUser.setText(order.getName());
		holder.txtTime.setText(order.getTime());
		holder.txtAddress.setText(order.getAddress());
		holder.txtTotal.setText("总价:￥"+order.getMoney());
		if(order.getStatus()==0){
			holder.txtStatus.setText("等待中");
			holder.txtStatus.setTextColor(mContext.getResources().getColor(R.color.red_500));
		}
		else{
			holder.txtStatus.setText("已发送");
			holder.txtStatus.setTextColor(mContext.getResources().getColor(R.color.blue_500));
		}
		return view;
	}
	
    private class ViewHolder{
    	TextView txtUser,txtTime,txtAddress,txtTotal,txtStatus;
	}
}