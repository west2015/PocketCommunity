package com.west2.activity;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pocketcommunity.R;
import com.west2.notice.Notice;

public class ActivityDetailListAdapter extends BaseAdapter{
	private Context mContext;
	private List<Activities> listActivity;

	public ActivityDetailListAdapter(Context context,List<Activities> activity){
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
	public View getView(final int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if(view == null){
			holder = new ViewHolder();
			view = LayoutInflater.from(mContext).inflate(R.layout.list_item_activity_detail, null);
			holder.btnReview = (Button)view.findViewById(R.id.activity_detail_btn_review);
			holder.imgPhoto = (ImageView)view.findViewById(R.id.activity_detail_img_photo);
			holder.imgContent = (ImageView)view.findViewById(R.id.activity_detail_img_content);
			holder.txtName = (TextView)view.findViewById(R.id.activity_detail_txt_name);
			holder.txtFloor = (TextView)view.findViewById(R.id.activity_detail_txt_floor);
			holder.txtContent = (TextView)view.findViewById(R.id.activity_detail_txt_content);			
			view.setTag(holder);
		}else{
			holder = (ViewHolder)view.getTag();
		}
		Activities activity = listActivity.get(position);
		holder.imgPhoto.setImageDrawable(mContext.getResources().getDrawable(R.drawable.photo));
		holder.imgContent.setImageDrawable(mContext.getResources().getDrawable(R.drawable.test));
		holder.txtName.setText("李瑶池是大帅比");
		holder.txtFloor.setText(""+(position+1)+"楼");
		holder.txtContent.setText("我这么帅一定有回复\n             ---发自Orange6 Plus");
		holder.btnReview.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "Floor " + (position+1), Toast.LENGTH_SHORT).show();
			}
		});
		return view;
	}
	
    class ViewHolder{
    	Button btnReview;
    	ImageView imgPhoto,imgContent;
    	TextView txtName,txtFloor,txtContent;
	}
}
