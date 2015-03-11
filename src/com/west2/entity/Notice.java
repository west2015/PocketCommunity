package com.west2.entity;

public class Notice {
	private String title,date,content;
	public Notice(){
		title = "";
		date = "";
		content = "";
	};
	public Notice(String _title,String _date,String _content){
		title = _title;
		date = _date;
		content = _content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
