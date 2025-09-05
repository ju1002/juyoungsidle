package com.kh.model.vo;

import java.sql.Date;

public class Board {
	
	//리뷰 보드 필드부
	private int reivewNum;
	//private String userId;
	//private String title;
	private String reivewTxt;
	private int ration;
	private Date createdAt;
	
	//유저
	private int userNo;
	private String userId;
	private String userNickname;
	private String subscription;
	
	//콘텐츠
	private int contentsNum;
	private String title;
	private String genre;
	private String director;
	private int subscriptionLevel;
	
	
	public Board() {}
	
	//모든 필드를 포함하는 생성자
	public int getReivewNum() {return reivewNum;}
	public Board(int reivewNum, String reivewTxt, int ration, Date createdAt, int userNo, String userId,
			String userNickname, String subscription, int contentsNum, String title, String genre, String director,
			int subscriptionLevel) {
		super();
		this.reivewNum = reivewNum;
		this.reivewTxt = reivewTxt;
		this.ration = ration;
		this.createdAt = createdAt;
		this.userNo = userNo;
		this.userId = userId;
		this.userNickname = userNickname;
		this.subscription = subscription;
		this.contentsNum = contentsNum;
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.subscriptionLevel = subscriptionLevel;
	}

	public String getReivewTxt() {return reivewTxt;}
	public int getRation() {return ration;}
	public Date getCreatedAt() {return createdAt;}
	public int getUserNo() {return userNo;}
	public String getUserId() {return userId;}
	public String getUserNickname() {return userNickname;}
	public String getSubscription() {return subscription;}
	public int getContentsNum() {return contentsNum;}
	public String getTitle() {return title;}
	public String getGenre() {return genre;}
	public String getDirector() {return director;}
	public int getSubscriptionLevel() {return subscriptionLevel;}
	
	
	
	

}
