package com.west2.shop;

public class Item {
	private String name;
	private double price;
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Item(){
		name = "";
		price = 0.0;
	}
	public Item(String _name,double _price){
		name = _name;
		price = _price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
