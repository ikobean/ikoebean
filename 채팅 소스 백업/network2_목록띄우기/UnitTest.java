package com.network2;

public class UnitTest {

	public static void main(String[] args) {

		ChatDao cDao = new ChatDao();
		String nick=cDao.login("ikobean", "123");
		
		System.out.println(nick);
	}

	
}
