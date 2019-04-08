package com.vigteam.study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDao {
	private String dbuser = null;
	private String dbpass = null;
	
	public BaseDao(String dbuser, String dbpass) {
		this.dbuser = dbuser;
		this.dbpass = dbpass;
		
	}
	
	protected Connection getConnection() throws SQLException /*외부에 예외처리 넘겨줌*/{
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521/orcl";
			conn = DriverManager.getConnection(dburl, dbuser, dbpass); /*생성자로 부터 넘겨받은 값*/
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패");
		}
		
		return conn;
		/*데이터 베이스 connection 받아오게*/
	}
}
