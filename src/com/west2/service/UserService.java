package com.west2.service;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.example.pocketcommunity.R;
import com.west2.domain.User;
import com.west2.tool.HttpUtils;

public class UserService {

	/*
	 * 
	 * return int
	 * 0  ע��ɹ�
	 * 1 �û����Ѵ���
	 * 2 �������
	 * 3 ��������
	 */
	public static int register(Context context,User u){
		
		String url = context.getString(R.string.url_signup);
//		?name=yaochi&pass=liyaochi&realname=������&phone=18649735773&address=32��¥605  
		url=url+"?name="+u.getName()+"&pass="+u.getPass()
						+"&realname="+u.getRealName()
						+"&phone"+u.getPhone()
						+"&address="+u.getAddress();
		String res = HttpUtils.getData2(url);
		Log.e("!!!", url+"   "+res);
		if(res==null||res.length()==0)
			return 2;
		try {
			JSONObject jsonObj = new JSONObject(res);
			
			if(jsonObj.getBoolean("status")){
				return 0;
			}else
			if("�û����Ѵ���".equalsIgnoreCase(jsonObj.getString("mes"))){
				return 1;
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return 3;
	}
	
	
	/*
	 * return int
	 * 0 	��¼�ɹ�
	 * 1	������� 
	 * 2	���������û�������
	 */
	public static int login(Context context,User u){
		String url =context.getString(R.string.url_login)+
				"?name="+u.getName()+
				"&pass="+u.getPass();
		
		String res =HttpUtils.getData2(url);
		if(res==null||res.length()==0)
			return 1;
		
		try {
			JSONObject obj = new JSONObject(res);
			if(!obj.getBoolean("status")){
				return 2;
			}
			u.setLevel(obj.getString("level"));
			u.setRealName(obj.getString("realname"));
			u.setAddress(obj.getString("address"));
			u.setPhone(obj.getString("pohone"));
//			DataService dataSer = new DataService(context);
//			Log.e("YAO", dataSer.saveUserMes(u)+"DATASERVICE");			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
}
