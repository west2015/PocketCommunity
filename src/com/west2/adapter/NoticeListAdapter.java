package com.west2.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pocketcommunity.R;
import com.west2.entity.Notice;

public class NoticeListAdapter extends BaseAdapter{
	private Context mContext;
	private List<Notice> listNotice;

	public NoticeListAdapter(Context context,List<Notice> notice){
		this.mContext = context;
		this.listNotice = notice;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listNotice.size();
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
			view = LayoutInflater.from(mContext).inflate(R.layout.list_item_notice, null);
			holder.textTitle = (TextView)view.findViewById(R.id.notice_title);
			holder.textDate = (TextView)view.findViewById(R.id.notice_date);
			view.setTag(holder);
		}else{
			holder = (ViewHolder)view.getTag();
		}
		Notice notice = listNotice.get(position);
		holder.textTitle.setText(notice.getTitle());
		holder.textDate.setText(notice.getDate());
		return view;
	}
	
    class ViewHolder{
		TextView textTitle;
		TextView textDate;
	}
}
