package com.west2.shop;

import java.util.ArrayList;
import java.util.List;

import com.example.pocketcommunity.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.west2.service.ViewService;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MyShopActivity extends Activity{
	private Context mContext;
	private ImageButton btnBack;
	private Button btnOrder,btnGood,btnAdd;
	private TextView txtOrder,txtGood,txtAdd;
	private ImageView imgOrder,imgGood,imgAdd;
	private ListView actListOrder,actListGood;
	private PullToRefreshListView pullListOrder,pullListGood;
	
	private int curPos;
	private ViewService viewService;
	private ScrollView layoutAdd;
	private OrderListAdapter orderAdapter;
	private GoodListAdapter goodAdapter;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_myshop);

		FindView();
		InitValue();
		SetListener();
	}
	private void FindView(){
		btnBack = (ImageButton)findViewById(R.id.myshop_btn_back);
		btnOrder = (Button)findViewById(R.id.myshop_btn_order);
		btnGood = (Button)findViewById(R.id.myshop_btn_good);
		btnAdd = (Button)findViewById(R.id.myshop_btn_add);
		imgOrder = (ImageView)findViewById(R.id.myshop_img_order);
		imgGood = (ImageView)findViewById(R.id.myshop_img_good);
		imgAdd = (ImageView)findViewById(R.id.myshop_img_add);
		txtOrder = (TextView)findViewById(R.id.myshop_txt_order);
		txtGood = (TextView)findViewById(R.id.myshop_txt_good);
		txtAdd = (TextView)findViewById(R.id.myshop_txt_add);
		pullListOrder = (PullToRefreshListView)findViewById(R.id.myshop_list_order);
		pullListGood = (PullToRefreshListView)findViewById(R.id.myshop_list_good);
		layoutAdd = (ScrollView)findViewById(R.id.myshop_layout_add);
	}
	private void InitValue(){
		mContext = MyShopActivity.this;
		viewService = new ViewService(mContext);
		pullListOrder.setMode(Mode.PULL_FROM_START);
		pullListGood.setMode(Mode.PULL_FROM_START);
		actListOrder = pullListOrder.getRefreshableView();
		actListGood = pullListGood.getRefreshableView();
		curPos = 0;
		ShowItem(curPos);
		List<Order> listOrder = new ArrayList<Order>();
		for(int i=0;i<20;++i){
			listOrder.add(new Order((int)(Math.random()*1000)/100.0,i%2,"ÀîÑý³Ø","10:54","32ºÅÂ¥605"));
		}
		orderAdapter = new OrderListAdapter(mContext,listOrder);
		actListOrder.setAdapter(orderAdapter);
		List<Item> listGood = new ArrayList<Item>();
		for(int i=0;i<20;++i){
			listGood.add(new Item("Ñ©±Ì",10.0));
		}
		goodAdapter = new GoodListAdapter(mContext,listGood);
		actListGood.setAdapter(goodAdapter);
	}
	private void SetListener(){
		btnBack.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MyShopActivity.this.finish();
			}
		});
		btnOrder.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToPage(0);
			}
		});
		btnGood.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToPage(1);
			}
		});
		btnAdd.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ToPage(2);
			}
		});
	}
	private void ToPage(int position){
		if(position == curPos) return ;
		HideItem(curPos);
		curPos = position;
		ShowItem(curPos);
	}
	private void ShowItem(int position){
		if(position<0 || position>2) return ;
		LayoutParams params;
		switch(position){
		case 0:
			txtOrder.setTextColor(mContext.getResources().getColor(R.color.blue));
			imgOrder.setImageDrawable(mContext.getResources().getDrawable(R.drawable.myshop_order_yes_icon));
			actListOrder.setVisibility(View.VISIBLE);
			params = (LayoutParams) actListOrder.getLayoutParams();
			params.setMargins(0, 0, 0, 0);
			actListOrder.setLayoutParams(params);
			actListOrder.setAdapter(orderAdapter);
			break;
		case 1:
			txtGood.setTextColor(mContext.getResources().getColor(R.color.blue));
			imgGood.setImageDrawable(mContext.getResources().getDrawable(R.drawable.myshop_good_yes_icon));
//			actListGood.setVisibility(View.VISIBLE);
//			params = (LayoutParams) actListGood.getLayoutParams();
//			params.setMargins(0, 0, 0, 0);
//			actListGood.setLayoutParams(params);
			actListOrder.setVisibility(View.VISIBLE);
			params = (LayoutParams) actListOrder.getLayoutParams();
			params.setMargins(0, 0, 0, 0);
			actListOrder.setLayoutParams(params);
			actListOrder.setAdapter(goodAdapter);
			break;
		case 2:
			txtAdd.setTextColor(mContext.getResources().getColor(R.color.blue));
			imgAdd.setImageDrawable(mContext.getResources().getDrawable(R.drawable.myshop_add_yes_icon));
			layoutAdd.setVisibility(View.VISIBLE);
			params = (LayoutParams) layoutAdd.getLayoutParams();
			params.setMargins(0, 0, 0, 0);
			layoutAdd.setLayoutParams(params);
			break;
		}
	}
	private void HideItem(int position){
		if(position<0 || position>2) return ;
		LayoutParams params;
		switch(position){
		case 0:
			txtOrder.setTextColor(mContext.getResources().getColor(R.color.dark_grey));
			imgOrder.setImageDrawable(mContext.getResources().getDrawable(R.drawable.myshop_order_no_icon));
			actListOrder.setVisibility(View.INVISIBLE);
			params = (LayoutParams) actListOrder.getLayoutParams();
			params.setMargins(viewService.GetScrWidth(), 0, 0, 0);
			actListOrder.setLayoutParams(params);
			break;
		case 1:
			txtGood.setTextColor(mContext.getResources().getColor(R.color.dark_grey));
			imgGood.setImageDrawable(mContext.getResources().getDrawable(R.drawable.myshop_good_no_icon));
//			actListGood.setVisibility(View.INVISIBLE);
//			params = (LayoutParams) actListGood.getLayoutParams();
//			params.setMargins(viewService.GetScrWidth(), 0, 0, 0);
//			actListGood.setLayoutParams(params);
			actListOrder.setVisibility(View.INVISIBLE);
			params = (LayoutParams) actListOrder.getLayoutParams();
			params.setMargins(viewService.GetScrWidth(), 0, 0, 0);
			actListOrder.setLayoutParams(params);
			break;
		case 2:
			txtAdd.setTextColor(mContext.getResources().getColor(R.color.dark_grey));
			imgAdd.setImageDrawable(mContext.getResources().getDrawable(R.drawable.myshop_add_no_icon));
			layoutAdd.setVisibility(View.INVISIBLE);
			params = (LayoutParams) layoutAdd.getLayoutParams();
			params.setMargins(viewService.GetScrWidth(), 0, 0, 0);
			layoutAdd.setLayoutParams(params);
			break;
		}

	}
}