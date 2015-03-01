package com.west2.shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	private String name;
	private List<Item> listItem;
	public Shop(){
		name = "";
		listItem = new ArrayList<Item>();
	}
	public Shop(String _name){
		name = _name;
		listItem = new ArrayList<Item>();
	}
	public Shop(String _name,List<Item> _listItem){
		name = _name;
		listItem = _listItem;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Item> getListItem() {
		return listItem;
	}
	public void setListItem(List<Item> listItem) {
		this.listItem = listItem;
	}
}
