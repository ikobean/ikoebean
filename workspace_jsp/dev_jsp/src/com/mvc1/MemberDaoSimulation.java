package com.mvc1;

import com.mybatis.MemberDao;

public class MemberDaoSimulation {

	public static void main(String[] args) {
		MemberDao mDao = new MemberDao();
		String time = mDao.currentTime();
		System.out.println(time);
	}

}
