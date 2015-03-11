package com.west2.notification;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.west2.entity.Mes;
import com.west2.service.DataService;
import com.west2.service.NotificationService;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

public class BgService extends Service{

	private Handler mHandler;
	private Timer mTimer;
	private String lastDate;
	private String curId;
	private boolean isPush = true;
	
	private List<Mes> mPushMes;
	
	private SharedPreferences dateShare,settingShare;
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public BgService(){
		super();
	}
	public void onStart(Intent intent ,int startId){
		IntentFilter filter = new IntentFilter(Intent.ACTION_TIME_TICK);
		MyBroadcastReceiver receiver = new MyBroadcastReceiver();
		registerReceiver(receiver, filter);
		super.onStart(intent, startId);
	}
	
	public void onCreate(){
		super.onCreate();
		IntentFilter filter = new IntentFilter(Intent.ACTION_TIME_TICK);
		MyBroadcastReceiver receiver = new MyBroadcastReceiver();
		registerReceiver(receiver, filter);
		Log.e("time", "service");
		init();
	}
	
	private void init(){
		
		mHandler = new Handler() {
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				
				if(msg.what==1)
				{
					NotificationService.showMessage(BgService.this,mPushMes);
				}
			}
		};
		
		mTimer = new Timer();
		mTimer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
//				isPush = settingShare.getBoolean("isPush",true);
//				if(!isPush)
//					return;
				Message message = new Message();
				
				mPushMes = NotificationService.getPushMes(BgService.this, 
							new DataService(BgService.this).getUserName());
				if(mPushMes==null||mPushMes.size()==0)
					message.what=2;
				else
					message.what=1;
				mHandler.sendMessage(message);
				
			}
		}, 0, 4*1000);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return START_STICKY;
	}

}
