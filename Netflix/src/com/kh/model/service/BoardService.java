package com.kh.model.service;

import static com.kh.common.JDBCTemplate.getConnection;

//예외처리 , 커넥션 객체 생성, 예외처리
import java.sql.Connection;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.BoardDAO;
import com.kh.model.vo.Board;
import com.kh.model.vo.User;

public class BoardService {
	
	private BoardDAO boardDAO = new BoardDAO();	
	
	
	/**
	 * @return
	 */
	public List<Board> findAll() {
	getConnection();
	Connection conn =getConnection(); //커넥션
	List<Board> boards =new BoardDAO().findAll(conn);
	JDBCTemplate.close(conn);
	return boards;
	}

	/**
	 * @param userId
	 * @param userPwd
	 * @return 
	 */
    public User login(String userId, String userPwd) {
        Connection conn = getConnection();
        User user = boardDAO.login(conn, userId, userPwd);
        JDBCTemplate.close(conn);
        return user;
    }

}
