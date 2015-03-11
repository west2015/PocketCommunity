package com.west2.subactivity.shop;

public class Order {
	private String name,time,address;
	private int status;
	private double money;
	public Order(){
		name = "";
		time = "";
		address = "";
		money = 0;
		status = 0;
	}
	public Order(double _money,int _status,String _name,String _time,String _address){
		money = _money;
		status = _status;
		name = _name;
		time = _time;
		address = _address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
