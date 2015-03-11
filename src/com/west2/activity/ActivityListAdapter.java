package com.west2.activity;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pocketcommunity.R;
import com.west2.notice.Notice;

public class ActivityListAdapter extends BaseAdapter{
	private Context mContext;
	private List<Activities> listActivity;

	public ActivityListAdapter(Context context,List<Activities> activity){
		this.mContext = context;
		this.listActivity = activity;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listActivity.size();
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
			view = LayoutInflater.from(mContext).inflate(R.layout.list_item_activity, null);
			holder.textTop = (TextView)view.findViewById(R.id.activity_top);
			holder.textTitle = (TextView)view.findViewById(R.id.activity_title);
			holder.textContent = (TextView)view.findViewById(R.id.activity_content);
			holder.textThePerson = (TextView)view.findViewById(R.id.activity_the_person);
			holder.textReview = (TextView)view.findViewById(R.id.activity_review);
			view.setTag(holder);
		}else{
			holder = (ViewHolder)view.getTag();
		}
		Activities activity = listActivity.get(position);
		if(activity.getIsTop()) holder.textTop.setVisibility(View.VISIBLE);
		else holder.textTop.setVisibility(View.GONE);
		holder.textTitle.setText(activity.getTitle());
		holder.textContent.setText(activity.getContent());
		holder.textThePerson.setText(activity.getThePerson());
		holder.textReview.setText("»Ø¸´"+activity.getReviews().size());
		return view;
	}
	
    class ViewHolder{
		TextView textTop,textTitle;
		TextView textContent,textThePerson,textReview;
	}
}
