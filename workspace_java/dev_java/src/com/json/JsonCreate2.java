package com.json;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.util.DBConnectionMgr;

import address.AddressVO;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.internal.OracleCallableStatement;
public class JsonCreate2 {
	//물리적으로 떨어져있는 서버에 연결통로 확보하는 인터페이스
	Connection con = null; //
	//오라클 서버의 쿼리문을 전달할 객체를 생성 --pstmt
	//프로시저 가져올 때 쓰는애들
	CallableStatement cstmt = null;  
	//SYS_REFCURSOR를 지원하는 인터페이스 - ojdbc6.jar
	OracleCallableStatement ocstmt = null;
	//오라클 응답을 받아서 커서를 조작하는 클래스
	ResultSet rs = null;
	DBConnectionMgr dbMgr = null;
	public JsonCreate2() {
		dbMgr = DBConnectionMgr.getInstance();//객체주입
		try {
			con = dbMgr.getConnetion(); //dbMgr 클래스의 getConnection 메소드를 con에 담아줘
			cstmt = con.prepareCall("{call proc_mkaddrtb(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute(); //excuteQuery():ResultSet :커서를 움직이면서 한 행씩 끌어내야 함, executeUpdatE():int,Delete,Insert,Update
			ocstmt = (OracleCallableStatement)cstmt; //형전환
			ResultSet cursor = ocstmt.getCursor(1);//OUT ref_addr
			AddressVO aVO = null;
			List<AddressVO> memList = new ArrayList<>();
			while(cursor.next()) {//true이면 값이 존재함
				aVO = new AddressVO();
				aVO.setId(cursor.getString("id"));
				aVO.setName(cursor.getString("name"));
				aVO.setAddress(cursor.getString("address"));
				aVO.setHp(cursor.getString("hp"));
				//반복문 안에서 인스턴스화가 진행되므로 오버라이트가 발생함.
				//그 주소번지가 가리키는 정보를 보존하기 위해 List사용함.
				//add하는 만큼 늘어나니깐~
				memList.add(aVO);
			}
			Gson g = new Gson();//List -> JSON 형태로 변환을 해주기 때문에~
			String jsonMember = g.toJson(memList);
			System.out.println(jsonMember);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		new JsonCreate2();
	}

	
}

