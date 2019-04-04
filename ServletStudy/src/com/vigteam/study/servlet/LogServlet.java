package com.vigteam.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/logs")
public class LogServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.println("<ul>");
		
		// c##vigteam log 테이블로부터 내용을 select 해서 화면에 표시
		Connection conn = null; // DB 접속 객체
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1. 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 얻기
			String dburl = "jdbc:oracle:thin:@localhost:1521/orcl";
			conn = DriverManager.getConnection(dburl, "vigteam", "vigteam");
			// 3. Statement 생성
			stmt = conn.createStatement();
			// 4. 쿼리 실행
			String sql = "SELECT name, log FROM log";
			rs = stmt.executeQuery(sql);
			// 5. rs를 루프 돌면서 내용 확인
			while (rs.next()) {
				String name = rs.getString("name");
				String log = rs.getString(2);
				
				System.out.println("이름:" + name + ", 기록:" + log);
				writer.print("<li>이름:" + name + ",기록:" + log + "</li>");
			}
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원 정리
			try { if (rs != null) rs.close(); } catch (Exception e) {
				
			}
			try { if (stmt != null) stmt.close(); } catch (Exception e) {
				
			}
			try { if (conn != null) conn.close(); } catch (Exception e) {
				
			}
			writer.println("</ul>");
			writer.close();
		}
	}
	

}
