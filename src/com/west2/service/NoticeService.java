package com.west2.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.example.pocketcommunity.R;
import com.west2.entity.Notice;
import com.west2.utils.HttpUtils;

public class NoticeService {
	public static List<Notice> getNotices(Context context){
		List<Notice> data = new ArrayList<Notice>();
		String url = context.getString(R.string.url_notice);
		
//		Log.e("!!!", url);
		String res = HttpUtils.getData2(url);
//		Log.e("!!!", res+"!!!");
		if(res==null||res.length()==0)
			return data;
		try {
			JSONObject JSobj = new JSONObject(res);
			JSONArray array = JSobj.getJSONArray("list");
			if(array==null)
				return data;
			for(int i =0;i<array.length();i++){
				JSONObject obj = array.getJSONObject(i);
				Notice n = new Notice();
				n.setContent(obj.getString("content"));
				n.setDate(obj.getString("date"));
				n.setTitle(obj.getString("title"));
				data.add(n);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return data;
		
	}
}
