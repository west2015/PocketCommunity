package com.west2.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.example.pocketcommunity.R;
import com.west2.shop.Item;
import com.west2.shop.Shop;
import com.west2.tool.HttpUtils;

public class ShopService {
	
	public static List<Shop> getShops(Context context){
		List<Shop> data = new ArrayList<Shop>();
		
		String url =context.getString(R.string.url_marketlist);
		String res =HttpUtils.getData2(url);
		Log.e("!!", res+"shop");
		if(res!=null){
			try {
				JSONObject jsonObj = new JSONObject(res);
				if(!jsonObj.getBoolean("status"))
					return data;
				JSONArray array = jsonObj.getJSONArray("list");
				for(int i=0;i<array.length();i++){
					Shop shop = new Shop();
					shop.setName(array.getJSONObject(i).getString("marketname"));
					shop.setPerson(array.getJSONObject(i).getString("person"));
					shop.setId(array.getJSONObject(i).getString("id"));
					JSONArray a = array.getJSONObject(i).getJSONObject("goods").getJSONArray("data");
					for(int j=0;j<a.length();j++){
						Item item = new Item();
						item.setId(a.getJSONObject(i).getString("id"));
						item.setName(a.getJSONObject(i).getString("name"));
						item.setPrice(a.getJSONObject(i).getDouble("price"));
						shop.getListItem().add(item);
						
					}
					
					data.add(shop);
				}
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return data;
		
	}
}
