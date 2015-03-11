package com.west2.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

import com.west2.domain.User;

public class DataService {
	
	private final String USERMES="usermessage";
	private final String PSW="password";
	private final String USERNAME="username";
	private final String REALNAME="realname";
	private final String ISLOGIN="islogin";
	private final String PHONE="phone";
	private final String ADDRESS="address";
	private final String LEVEL="level";
	
	private SharedPreferences userMesShare;
	private Context mContext;
	
	public DataService(Context context){
		this.mContext=context;
	}
	
	public boolean saveUserMes(User u){
		Log.e("YAO", u.getName()+"name");
		userMesShare = mContext.getSharedPreferences(USERMES, mContext.MODE_PRIVATE);
		Editor et = userMesShare.edit();
		et.putString(LEVEL, u.getLevel());
		et.putString(PHONE, u.getPhone());
		et.putString(PSW, u.getPass());
		et.putString(REALNAME, u.getRealName());
		et.putString(USERNAME, u.getName());
		et.putString(ADDRESS, u.getAddress());
		et.putBoolean(ISLOGIN, true);
		return et.commit();
		
	}
	
	public String getUserName(){
		userMesShare = mContext.getSharedPreferences(USERMES, mContext.MODE_PRIVATE);
		
		return userMesShare.getString(USERNAME, "");
	}
	
}
