package com.Oracle;

import java.sql.Connection;

import com.util.DBConnectionMgr;

public class ConnetionTest {

	public static void main(String[] args) {
		Connection con = null;
		//insert here
		 //DBConnectionMgr dbMgr2 = new  DBConnectionMgr(); //이렇게 하지 말자!
		                                                  //결합도가 높은 코드가 되는 것이다.
		 DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		 DBConnectionMgr dbMgr2 = DBConnectionMgr.getInstance();
		 System.out.println(dbMgr);
		 System.out.println(dbMgr2);
		 con = dbMgr.getConnetion(); //객체주입을 con에 받음
		 System.out.println(con);
	}
	

}

