package com.kh.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverPropertiesRun {

	public static void main(String[] args) {
		
        Properties prop = new Properties();

        // JDBCTemplate에서 사용할 DB 접속 정보 설정
        prop.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
        prop.setProperty("url", "jdbc:oracle:thin:@115.90.212.20:10000:xe");
        prop.setProperty("user", "lSw17");
        prop.setProperty("password", "LSW171234");

        try {
            prop.store(new FileOutputStream("resources/driver.properties"), "DATABASE CONNECTION INFO");
            
            System.out.println("resources/driver.properties 파일이 성공적으로 생성되었습니다.");

        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
