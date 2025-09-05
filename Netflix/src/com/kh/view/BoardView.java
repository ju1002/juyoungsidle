package com.kh.view;

import java.util.Scanner;

public class BoardView {
	
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		
        while (true) {
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
                case "1": break;
                case "2": break;
                case "3": break;
                case "4": break;
                case "5": break;
                case "6": break;
                case "7": break;
                case "8": break;
                case "0": System.out.println("프로그램을 종료합니다."); return;
                default: System.out.println("잘못된 번호입니다. 다시 입력해주세요."); break;
            }
        }
    }
	
	
}
