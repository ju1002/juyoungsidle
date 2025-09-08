package com.kh.controller;

import java.util.List;

import com.kh.model.service.BoardService;
import com.kh.model.vo.Board;
import com.kh.model.vo.User;

public class BoardController {
	
	 private BoardService boardService = new BoardService();
	
	
	/**
	 * @return
	 */
	public List<Board> findAll() {
		
		List<Board> boards = boardService.findAll();
		
		return boards;
		
	}
	
	public int writeReivew(String userId, String title, String text, int rating) {
		return boardService.writeReivew(userId, title, text, rating);
		
	}


	/**
	 * 로그인 체크 메소드
	 * @param userPwd 
	 * @param userId 
	 */
    public User login(String userId, String userPwd) {
        return boardService.login(userId, userPwd);
        
    }

	/**
	 * @param userId
	 * @return 
	 */
	public List<Board> checkReivew(String userId) {
		return boardService.checkReview(userId);
		
	}


}
