package com.kh.model.vo;

import java.sql.Date;

public class Board {

	private int reviewNo;
	private String userId;
	private String title;
	private String text;
	private int rating;
	
	
	public Board() {
		super();
	}
	public Board(int reviewNo, String userId, String title, String text, int rating) {
		super();
		this.reviewNo = reviewNo;
		this.userId = userId;
		this.title = title;
		this.text = text;
		this.rating = rating;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public String getUserId() {
		return userId;
	}
	public String getTitle() {
		return title;
	}
	public String getText() {
		return text;
	}
	public int getRating() {
		return rating;
	}
}
	
