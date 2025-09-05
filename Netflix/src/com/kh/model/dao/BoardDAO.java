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

/**컨텐츠 전체 조회를 하는 곳
 * 
 * 
 */
public class BoardDAO {
	private static Properties prop = new Properties();
	
	static {
		try {
			prop.loadFromXML(new FileInputStream("resources/queries.xml"));
		} catch (InvalidPropertiesFormatException e) {

			e.printStackTrace();
		} catch (FileNotFoundException e) {
			
			System.out.println("파일이 없습니다");

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
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

}
