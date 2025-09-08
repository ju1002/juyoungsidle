package com.kh.model.vo;

import java.sql.Date;

public class Board {

	// == 리뷰필드 ==
	private int reviewNo;
	private String userId;
	private String title;
	private String text;
	private int rating;
	private Date date;
	
	// == 
	
	
	public Board() {
		super();
	}
	
	//== 리뷰정보 제공용 생성자 ==
	



	public int getReviewNo() {
		return reviewNo;
	}
	public Board(int reviewNo, String userId, String title, String text, int rating, Date date) {
		super();
		this.reviewNo = reviewNo;
		this.userId = userId;
		this.title = title;
		this.text = text;
		this.rating = rating;
		this.date = date;
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
	
