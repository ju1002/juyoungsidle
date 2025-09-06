package com.kh.model.vo;

import java.sql.Date;

public class Board {

	// == 리뷰필드 ==
	private int reviewNo;
	private String userId;
	private String title;
	private String text;
	private int rating;
	
	// == 
	
	
	public Board() {
		super();
	}
	
	//== 리뷰정보 제공용 생성자 ==
	
	public Board(int reviewNo, String userId, String title, String text, int rating) {
		super();
		this.reviewNo = reviewNo;
		this.userId = userId;
		this.title = title;
		this.text = text;
		this.rating = rating;
	}
	
	// 사용자 생성자
	public Board(int int1, String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
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
	
