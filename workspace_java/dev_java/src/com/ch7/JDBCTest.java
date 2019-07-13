package com.ch7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import oracle.net.aso.e;

public class JDBCTest {

	public static void main(String[] args) {
		StringBuilder sb_sql = new StringBuilder();
		try {
			sb_sql.append("SELECT model_no, color, pro_code " );
			sb_sql.append(" FROM product_detail" );
			
		    Class.forName(ZizonOracleServer._DRIVER); //제조사 정보 수집
			//물리적으로 떨어져 있는 서버와 연결통로
		 Connection con = DriverManager.getConnection(ZizonOracleServer._URL ,ZizonOracleServer._USER,ZizonOracleServer._PW);
	     PreparedStatement pstmt = con.prepareStatement(sb_sql.toString());
	     ResultSet rs =  pstmt.executeQuery();
	     
	//     DVDVO dvos[] =null;
	  //   DVDVO dvo = null;
	     
	     
	     JDBCTestVO rents[]=null; //배열
	     JDBCTestVO rent = null; //인스턴스화 원래 NEW 생성자 이름이 들어가야 되는거 
	     Vector<e> v = new Vector();
	     
	     while(rs.next()) {
	    	 rent = new product_detail();
	    	 rent.setColor(rs.getString("COLOR"));
	    	 rent.setPro_code()(rs.getString("PRO_CODE"));
	    	 //테이블안에 몇건이 있는지 while문이 끝나야 알 수 있다.
	    	 dvos = new dvdvo[4];
	    	 
	    	System.out.println(rs.getString("color")+ "," + rs.getString("pro_code"));
	    	//System.out.println(rs.getInt("pro_code"));
	        // dvo = new DVDVO();
	    	// dvo.setXXX(rs.getString("dvd_no");
	    	 //dvo.setXXX(rs.getString("dvd_title");
	    	 //dvo.setXXX(rs.getString("dvd_price");
	    	
	    	//rent = new JDBCTestVO();
	    	//rent.setColor("White");
	    	//rent.setPro_code(15935713);
	    	
	
	  
	     }
	     dvos = new DVDVO[v.size()]; //4
	     //Vector 안에 담긴 정보를 DVDVO 배열 안에 복제하는 메소드 호출
	     //copyTnto 메소드의 소유주는 Vector 클래스 이고 
	     //파라미터에는 정보를 담을 배열을 주소번지를 써줌.
	     v.copyInto(dvos);
	     for(int i =0; i<dvos.length;i++) {
	    	 DVDVO dVO = dvos[i];
	    	 System.out.println(dVO.getDVD_NO()+","+DVO.GETDVD_TITLE);
	     }
		}catch (Exception e) {
			System.out.println("Exception: "+ e.toString());

		}

		
		
	  	//오라클 데이터 베이스에서 우리꺼 테이블에 있는 데이터 뽑는 거 
	}

}
