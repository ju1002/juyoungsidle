package com.kh.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kh.controller.BoardController;
import com.kh.model.vo.Board;
import com.kh.model.vo.User;

/**
 * 
 */
public class BoardView {
	
	private Scanner sc = new Scanner(System.in);
	private BoardController bc = new BoardController();
	 private static User loginUser = null;
	
	
	
	/**
	 * 
	 */
	public void mainMenu() {
		
		
        while (true) {
        	
        	if(loginUser != null) {
        		
        		System.out.println(loginUser.getUserNickname() + "님 환영합니다.");
        		
        	}
            System.out.println("""
                    
                    ========= 넷플릭스 실행 프로그램 =======
                    1. 모든 콘텐츠 조회
                    2. 키워드로 콘텐츠 조회하기
                    3. 회원가입
                    4. 내정보 조회
                    5. 내정보 수정하기 
                    6. 리뷰 작성하기
                    7. 리뷰 수정하기
                    8. 리뷰 삭제하기
                    0. 프로그램 종료
                    =================================
                    """);
            System.out.print(">> 메뉴 선택: ");
            String menuNo = sc.nextLine();

            switch (menuNo) {
                case "1": findAll();break;
                case "2": break;
                case "3": saveUser(); break;
                case "4": break;
                case "5": break;
                case "6": writeReivew(); break;
                case "7": updateReivew(); break;
                case "8": break;
                case "0": System.out.println("프로그램을 종료합니다."); return;
                default: System.out.println("잘못된 번호입니다. 다시 입력해주세요."); break;
            }
        }
    }
	
	



	/**
	 * @return
	 */
	public List<Board> findAll() {
		System.out.println("모든 콘텐츠 조회 메뉴>>");
		
		List<Board> boards =  bc.findAll();
		
		for(Board board : boards) {
<<<<<<< HEAD
			System.out.println("고유 번호 :" +board.get());
			System.out.println("");
=======
			System.out.println("고유 번호 :" +board.getTitle());
			
			
			
>>>>>>> fcb5444 (db)
		}
		
		
		return boards;
		
	}
	
	
	

	
	// 3. 회원가입
	/**
	 * 
	 */
	private void saveUser() {
		
		System.out.println("======== 회원가입 ========");
		System.out.print("아이디를 입력해주세요 > ");
		String userId = sc.nextLine();
		
		System.out.print("비밀번호를 입력해주세요 > ");
		String userPwd = sc.nextLine();
		
		System.out.print("닉네임을 입력해주세요 > ");
		String nickname = sc.nextLine();
		String subscription = "";
		
		while(true) {
		
			System.out.println("원하시는 구독 번호를 입력해주세요.");
			System.out.print("1. 베이직 / 2. 스탠다드 / 3. 프리미엄 / 4. 보류 >> ");
			int subNo = sc.nextInt();
			sc.nextLine();
			
			switch(subNo) {
			case 1 : subscription = "Basic"; break;
			case 2 : subscription = "Standard"; break;
			case 3 : subscription = "Premium"; break;
			case 4 : subscription = "None"; break;
			default : System.out.println("잘못된 입력입니다.");
			}
			
		}
		
		// 컨트롤러에 메소드 호출하면서 값 넘겨주기 --> 컨트롤러 클래스 생성 후 작업
		
	}
	
	// 4. 내정보 조회 : 아이디와 비밀번호를 입력받아서 일치하는 회원의 정보를 받아옵니다.
	private void findUserInfo() {
		
		System.out.println("회원님의 정보를 조회합니다.");
		System.out.print("아이디를 입력해주세요 > ");
		String userId = sc.nextLine();
		
		System.out.print("비밀번호를 입력해주세요 > ");
		String userPwd = sc.nextLine();
		
		// 컨트롤러에 아이디와 비밀번호를 전달하면서 메소드 호출 --> 컨트롤러 클래스 생성 후 작업
		
	}
	
	// 5. 내정보 수정하기 : 아이디와 비밀번호를 입력받아서 일치하는 회원의 비밀번호를 변경합니다.
	private void updatePwd() {
		
		System.out.println("회원님의 비밀번호를 변경합니다.");
		System.out.print("아이디를 입력해주세요 > ");
		String userId = sc.nextLine();
		
		System.out.print("비밀번호를 입력해주세요 > ");
		String userPwd = sc.nextLine();
		
		System.out.print("새로운 비밀번호를 입력해주세요 > ");
		String newPwd = sc.nextLine();
		
		// 컨트롤러에 아이디, 비밀번호, 새비번 전달하면서 메소드 호출 --> 컨트롤러 클래스 생성 후 작업
		
	}
	
	
	//6. 리뷰 작성하기
	/**
	 * 
	 */
	private void writeReivew() {
		
		if(loginUser == null) {
			System.out.println("로그인 후 사용가능합니다.");
			login();
		}

		String userId = loginUser.getUserId();
		System.out.print("작성할 콘텐츠 제목을 선택해주세요 > ");
		String title = sc.nextLine();
		
		System.out.println("리뷰내용 작성하기");
		String text = sc.nextLine();
		
		System.out.print("평점 주기 1~5 사이 선택 >");
		int rating = sc.nextInt();
		sc.nextLine();
		
		int rs = bc.writeReivew(userId,title,text,rating);
		
		if (rs != 0) {
			System.out.println("리뷰가 작성되었습니다.");
			System.out.println("\n작성된 리뷰 : " + text + "\n평점 : " + rating);
		} else {
			System.err.println("리뷰작성에 실패하였습니다.");
		}
			
	}
	
	//7. 리뷰업데이트 하기 
	/**
	 * 
	 */
	private void updateReivew() {
		List<Board> boards = checkReivew();
		
		if(boards.isEmpty()) {
			System.out.println("리뷰 작성을 먼저하세요");
			 writeReivew();
		}
		
		System.out.println("작성할 리뷰를 선택하세요");
		int reviewNo = sc.nextInt();
		//
		//
		//
		//
		
		
		
		
	}
	
	private List<Board> checkReivew() {
		if (loginUser == null ){
			System.out.println("로그인 후 사용가능합니다.");
			login();
		}
		
		String userId = loginUser.getUserId();
		List<Board> boards = bc.checkReivew(userId);
		
		if(boards.isEmpty()) {
			System.out.println("저장된 리뷰가 없습니다.");
			return null;
			
		}else {
			for(Board board : boards) {
				System.out.println(board.getTitle() + "\n" + board.getText());
			}
			
		}
		return boards;
		
		
	}





	//9. 공통 로그인 
	private void login() {
		
		System.out.println(" 로그인을 먼저 하세요");
		
		System.out.print("아이디를 입력해주세요 > ");
		String userId = sc.nextLine();
		
		System.out.print("비밀번호를 입력해주세요 > ");
		String userPwd = sc.nextLine();
		
		User user = bc.login(userId,userPwd);
		
        if (user != null) {
            loginUser = user;
            System.out.println("\n" + loginUser.getUserNickname() + "님, 로그인에 성공했습니다.");
        } else {
            System.out.println("\n아이디 또는 비밀번호가 일치하지 않습니다.");
        }
			
	}
	
	//10. 공통 출력 메소드

	
}
