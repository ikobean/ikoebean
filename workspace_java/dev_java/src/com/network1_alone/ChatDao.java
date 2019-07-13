package com.network1_alone;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConnectionMgr;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
/*
 * DAO : Database Access Object
 * 실질적으로 DB에 접근하는 객체.
 */
public class ChatDao {
	
	Connection 		con   = null;
	CallableStatement  cstmt = null;
	OracleCallableStatement  ocstmt = null;
	DBConnectionMgr    dbMgr = null;
	ResultSet          rs    = null;
	
	public String login(String mem_id, String mem_pw) {
		String nick = null;
		try {
			con 	= DBConnectionMgr.getConnetion();
			cstmt	= con.prepareCall("{call proc_chatlogin(?,?,?)}"); //세번째 물읆표에는 커서를 이용해서 받아온 메세지 (?)
			cstmt.setString(1, mem_id);
			cstmt.setString(2, mem_pw);
			cstmt.registerOutParameter(3, OracleTypes.CURSOR);
			//실행 요청 메소드 호출
			cstmt.execute();
			//커서 조작을 위한 코딩
			ocstmt = (OracleCallableStatement)cstmt;
			//값 꺼내와야지~
			rs = ocstmt.getCursor(3);
			while(rs.next()) {
				nick=rs.getString("mem_nick");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nick;
	}

}
