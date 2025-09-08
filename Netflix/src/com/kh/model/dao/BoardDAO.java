package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Board;
import com.kh.model.vo.User;




public class BoardDAO {
	
	private static Properties prop = new Properties();
	
	
	
    public BoardDAO() { // 생성자로 변경하여 객체 생성 시 로드하도록 함
        try {
            prop.loadFromXML(new FileInputStream("resources/queries.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	/**
	 * @param conn
	 * @return
	 */
	public List<Board> findAll(Connection conn) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		List<Board> boards  = new ArrayList(); 
		String sql = prop.getProperty("findAll");
		try {
	    pstmt = conn.prepareStatement(sql);
	    rset = pstmt.executeQuery();
	    while(rset.next()) {
	    	Board board = new Board(rset.getInt("CONTENTS_NUM")
	    						   ,rset.getString("TITLE")
	    						   ,rset.getString("GANRE")
	    						   , rset.getString("DIRECTOR")
	    						   ,rset.getInt("LEVEL_NUM"));
	    	boards.add(board);
	    			
	    }
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return boards;
		
	}
	
	
	public int writeRieview(Connection conn, String userId, String title, String text, int rating) {
		
		int rs = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("writeReivew");
		
		try {
			pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, title);
            pstmt.setString(3, text);
            pstmt.setInt(4, rating);
            rs = pstmt.executeUpdate();
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(pstmt);
		}
		
		return rs;
		
	}
	
	/**
	 * @param conn
	 * @param userId
	 * @param userPwd
	 * @return
	 */
	public User login(Connection conn, String userId, String userPwd) {
		
		User user = null;
		
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("loginUser");
		
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, userPwd);
            rset = pstmt.executeQuery();

            if (rset.next()) {
                user = new User(
                    rset.getInt("USER_NO"),
                    rset.getString("USER_ID"),
                    rset.getString("USER_PWD"),
                    rset.getString("NICKNAME"),
                    rset.getString("SUBSCRIPTION")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JDBCTemplate.close(rset);
        	JDBCTemplate.close(pstmt);
        }
        return user;
		
		
		
	}


	public List<Board> checkReivew(Connection conn, String userId) {
		List<Board> boards  = new ArrayList(); 
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("checkReivew");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			if(rset.next()) {
				
				Board board = new Board(rset.getInt("REVIEW_NO"),
                        rset.getString("USER_ID"),
                        rset.getString("TITLE"),
                        rset.getString("REVIEW_TEXT"), 
                        rset.getInt("RATING"),       
                        rset.getDate("CREATED_AT"));
				
				boards.add(board);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boards;
		
	}
	
	
	
	

}
