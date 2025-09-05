package com.kh.model.vo;

public class Users {
	
	// 사용자의 정보를 저장할 VO
	
	// 필드부
	private int userNo;
	private String userId;
	private String userPwd;
	private String nickname;
	private String subscription;
	
	// 생성자부(기본+모든필드)
	public Users() {
		super();
	}
	
	public Users(int userNo, String userId, String userPwd, String nickname, String subscription) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.nickname = nickname;
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

	public String getNickname() {
		return nickname;
	}

	public String getSubscription() {
		return subscription;
	}
	
	// 메소드부(setter 제외 / getter, hashCode, equals, toString)
	

}
