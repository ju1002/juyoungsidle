package com.kh.model.vo;

public class User {
	
	//=== 유저 필드부
	private int userNo;
	private String userId;
	private String userPwd;
	private String userNickname;
	private String subscription;
	
	public User() {
		super();
	}
	
	
	//모든 필드를 가진 생성자
	public User(int userNo, String userId, String userPwd, String userNickname, String subscription) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userNickname = userNickname;
		this.subscription = subscription;
	}



	public int getUserNo() {
		return userNo;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public String getSubscription() {
		return subscription;
	}
	
	

}
