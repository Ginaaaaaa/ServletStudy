package com.vigteam.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vigteam.study.vo.LogVo;

public class LogDao extends BaseDao {

	public LogDao(String dbuser, String dbpass) {
		super(dbuser, dbpass);
	}
//SELECT
	public List<LogVo> getAllLogs() {
		List<LogVo> list = new ArrayList<>();
		// DB 로직
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT id, name, log FROM log";
			rs = stmt.executeQuery(sql);
			
			// 	ResultSet  -> List
			while (rs.next()) {
				LogVo vo = new LogVo();
				vo.setId(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setLog(rs.getString(3));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
			} catch (Exception e) {
				
			}
			try { if (stmt != null) stmt.close();
			} catch (Exception e) {
			
			}
			try { if (conn != null) conn.close();
			} catch (Exception e) {
			
			}
		}
		return list;
		
	}
	
	// INSERT
	public int insertLog(LogVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0;
		
		try {
				conn = getConnection();
				String sql = "INSERT INTO log VALUES(seq_log_pk.nextval, ? , ?)";

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getLog());
				insertedCount = pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {}
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				
			}
		}
		return insertedCount;
	}
	
}
