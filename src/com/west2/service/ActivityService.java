package com.west2.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.example.pocketcommunity.R;
import com.west2.activity.Activities;
import com.west2.activity.Review;
import com.west2.tool.HttpUtils;

public class ActivityService {
	
	public static List<Activities> getActivities(Context context){
		List<Activities> data = new ArrayList<Activities>();
		
		String url = context.getString(R.string.url_activity);
		String res = HttpUtils.getData2(url);
//		Log.e("!", url+"\n!!!!"+res);
		if(res==null)
			return data;
		try {

			JSONObject jsonObj = new JSONObject(res);
			JSONArray array = jsonObj.getJSONArray("list");
			if(array==null) return data;
			for(int i = 0;i<array.length();i++){
				
				JSONObject obj = array.getJSONObject(i);
				Activities act = new Activities();
				act.setContent(obj.getString("content"));
				act.setIsTop(obj.getBoolean("top"));
				act.setTitle(obj.getString("title"));
				act.setThePerson(obj.getString("person"));
				
				JSONArray arr =obj.getJSONObject("comment").getJSONArray("data"); 
				for(int j=0;j<arr.length();j++){
					Review review = new Review();
					review.setContent(arr.getJSONObject(i).getString("content"));
					review.setPerson(arr.getJSONObject(i).getString("person"));
					act.getReviews().add(review);		
				}
				if(act.getIsTop()){
					data.add(0,act);
				}
				else 	data.add(act);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return data;
	}
	
	
	public static boolean addActivity(Context context,Activities act){
		
		String url = context.getString(R.string.url_addactivity);
		url=url+"?title="+act.getTitle()+"&content="+act.getContent()+"&person="+act.getThePerson();
		String res = HttpUtils.getData2(url);
		Log.e("", url+"!!"+res);
		if (res == null) return false;
		
		try {
			JSONObject obj = new JSONObject(res);
			boolean status =obj.getBoolean("status"); 
			Log.e("!!!",status+"1!!!");
			return status;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
}
