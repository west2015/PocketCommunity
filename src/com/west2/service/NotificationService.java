package com.west2.service;


import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.pocketcommunity.R;
import com.west2.activity.MainActivity;
import com.west2.adapter.NoticeListAdapter;
import com.west2.entity.Mes;
import com.west2.subactivity.shop.ShopActivity;
import com.west2.utils.HttpUtils;


public class NotificationService {
	public static void showMessage(Context context,List<Mes> pushMes){
		
		String ns = context.NOTIFICATION_SERVICE;
        NotificationManager mNotificationManager = (NotificationManager)context.getSystemService(ns);
        //����֪ͨ��չ�ֵ�������Ϣ
        int icon = R.drawable.ic_launcher;
        CharSequence tickerText = "���Կڴ���������Ϣ";
        long when = System.currentTimeMillis();
        Notification notification = new Notification(icon, tickerText, when);
        notification.flags=Notification.FLAG_AUTO_CANCEL;;
        
        for(Mes mes:pushMes){
        	//��������֪ͨ��ʱҪչ�ֵ�������Ϣ
            CharSequence contentTitle = mes.getTitle();
            //���õ��������activity
            Intent intent = new Intent();
            intent.setClass(context, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
            PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                    intent, PendingIntent.FLAG_UPDATE_CURRENT);
            
            notification.setLatestEventInfo(context, contentTitle, "",
                    contentIntent);
             
            //��mNotificationManager��notify����֪ͨ�û����ɱ�������Ϣ֪ͨ
            mNotificationManager.notify(mes.getType(), notification);
        }
        
        
	}
	

	
	public static List<Mes> getPushMes(Context context,String userName){
		List<Mes> pushMes = new ArrayList<Mes>();
		String url = context.getString(R.string.url_push)+"?name="+userName;
		String res  = HttpUtils.getData2(url+"&type=0");
		if(res==null||res.length()==0){
			return null;
		}
		try {
			JSONObject jsonObj = new JSONObject(res);
			if(!jsonObj.getBoolean("status"))
				return null;
			JSONArray array = jsonObj.getJSONArray("list");
			for(int i=0;i<array.length();i++){
				Mes mes = new Mes();
				mes.setContent(array.getJSONObject(i).getString("content"));
				mes.setPerson(array.getJSONObject(i).getString("person"));
				mes.setTitle(array.getJSONObject(i).getString("title"));
				mes.setType(array.getJSONObject(i).getInt("type"));
				pushMes.add(mes);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pushMes;
	}
}
