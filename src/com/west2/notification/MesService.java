package com.west2.notification;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.pocketcommunity.R;
import com.west2.service.DataService;
import com.west2.tool.HttpUtils;

import android.content.Context;

public class MesService {
	
	/*
	 * return int
	 * -1	网络错误
	 * 0	无消息
	 * x	x条消息
	 */
	private static int hadPushMes(Context context){
		String url = context.getString(R.string.url_push)
					+"?name="+new DataService(context).getUserName()
					+"&type=";
		
		String res =HttpUtils.getData2(url+"0");
		if(res==null)
			return -1;
		try {
			JSONObject obj = new JSONObject(res);
			if(!obj.getBoolean("status")){
				return 1;
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}
	
}
