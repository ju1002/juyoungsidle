package com.kh.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SQLPropertiesRun {

	public static void main(String[] args) {
		
        Properties prop = new Properties();

        try {
            // Properties 객체의 내용을 XML 파일로 저장
            prop.storeToXML(new FileOutputStream("resources/queries.xml"), "SQL Statements for Employee Project");

            System.out.println("resources/queries.xml 파일이 성공적으로 생성되었습니다.");

        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
