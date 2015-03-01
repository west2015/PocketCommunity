package com.west2.activity;

public class Activities {
	private boolean isTop;
	private String title,content,thePerson,review;
	
	public Activities(){
		isTop = false;
		title = "";
		content = "";
		thePerson = "";
		review = "";
	}
	
	public Activities(boolean _isTop,String _title,String _content,String _thePerson,String _review){
		isTop = _isTop;
		title = _title;
		content = _content;
		thePerson = _thePerson;
		review = _review;
	}

	public boolean getIsTop() {
		return isTop;
	}

	public void setIsTop(boolean isTop) {
		this.isTop = isTop;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getThePerson() {
		return thePerson;
	}

	public void setThePerson(String thePerson) {
		this.thePerson = thePerson;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
}
