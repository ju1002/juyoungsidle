package com.kh.controller;

import java.util.List;

import com.kh.model.service.BoardService;
import com.kh.model.vo.Board;

public class BoardController {
	public List<Board> findAll() {
		List<Board> boards =new BoardService().findAll();
		
		return boards;
		
	}
	

}
