package com.west2.subactivity.activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {
	private boolean isTop;
	private String title,content,thePerson;
	private List<Review> reviews;
	private Comment [] comments;
	public Activities(){
		isTop = false;
		title = "";
		content = "";
		thePerson = ""; 
		reviews = new ArrayList<Review>();
	}
	public Activities(boolean _isTop,String _title,String _content,String _thePerson,String _review){
		isTop = _isTop;
		title = _title;
		content = _content;
		thePerson = _thePerson;
	}
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void setTop(boolean isTop) {
		this.isTop = isTop;
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
	public Comment[] getComments() {
		return comments;
	}
	public void setComments(Comment[] comments) {
		this.comments = comments;
	}
	
	

}


