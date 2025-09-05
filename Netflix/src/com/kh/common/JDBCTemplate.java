package com.kh.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC 과정 중 반복적으로 사용되는 구문들을 모아놓은 유틸리티 클래스
 */
public class JDBCTemplate {
	
	private static final Properties prop = new Properties();
	
	private JDBCTemplate() {}
	
	static {
		try {
			prop.load(new FileInputStream("resources/driver.properties"));
		} catch (Exception e) {
			 System.err.println("driver.properties 파일을 찾을 수 없습니다.");
			e.printStackTrace();
		}
	}

	/**
	 * 데이터베이스연결 객체를 생성하여 반환하는 메소드
	 * @return conn Connection 객체
	 */
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("password")
					);
			
			conn.setAutoCommit(false);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	/**
	 * 전달받은 Connection 객체에 대해 COMMIT 수행
	 * @param conn Connection 객체
	 */
	public static void commit(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
			conn.commit();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}		
	}
	
    /**
     * 전달받은 Connection 객체에 대해 ROLLBACK 수행 
     * @param conn Connection 객체
     */
    public static void rollback(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 전달받은 Connection 객체의 리소스를 반납
     * @param conn Connection 객체
     */
    public static void close(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 전달받은 Statement 객체의 리소스를 반납
     * @param stmt Statement 또는 PreparedStatement 객체
     */
    public static void close(Statement stmt) {
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 전달받은 ResultSet 객체의 리소스를 반납
     * @param rset ResultSet 객체
     */
    public static void close(ResultSet rset) {
        try {
            if (rset != null && !rset.isClosed()) {
                rset.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }}}
