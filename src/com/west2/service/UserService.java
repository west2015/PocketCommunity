package com.west2.service;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.example.pocketcommunity.R;
import com.west2.entity.User;
import com.west2.utils.HttpUtils;
import com.west2.utils.InfoUtils;

public class UserService {

	public static int register(Context context,User u){
		String url = context.getString(R.string.url_signup);
		url=url+"?name="+u.getName()+"&pass="+u.getPass()
						+"&realname="+u.getRealName()
						+"&phone"+u.getPhone()
						+"&address="+u.getAddress();
		String res = HttpUtils.getData2(url);
		if(res==null||res.length()==0){
			return InfoUtils.REGISTER_NET_ERROR;
		}
		try {
			JSONObject jsonObj = new JSONObject(res);
			if(jsonObj.getBoolean("status")){
				return InfoUtils.REGISTER_SUCCEED;
			}else
			if("用户名已存在".equalsIgnoreCase(jsonObj.getString("mes"))){
				return InfoUtils.REGISTER_EXIST;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return InfoUtils.REGISTER_OTHER_ERROR;
	}
	
	public static int login(Context context,User user){
		String url =context.getString(R.string.url_login)+
				"?name="+user.getName()+
				"&pass="+user.getPass();
		String res =HttpUtils.getData2(url);
		if(res==null||res.length()==0){
			return InfoUtils.REGISTER_NET_ERROR;
		}
		try {
			JSONObject obj = new JSONObject(res);
			if(!obj.getBoolean("status")){
				return InfoUtils.LOGIN_WRONG_INPUT;
			}
			user.setLevel(obj.getString("level"));
			user.setRealName(obj.getString("realname"));
			user.setAddress(obj.getString("address"));
			user.setPhone(obj.getString("pohone"));	
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return InfoUtils.LOGIN_SUCCEED;
	}
}
