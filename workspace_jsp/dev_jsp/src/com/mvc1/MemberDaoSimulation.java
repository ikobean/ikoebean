package com.mvc1;

import java.util.List;

import com.vo.ZipCodeVO;

public class MemberDaoSimulation {

	public static void main(String[] args) {
		MemberDaoo mDao = new MemberDaoo();
		String time = mDao.currentTime();
		//System.out.println(time);
		ZipCodeDao zDao = new ZipCodeDao();
		ZipCodeVO zVO = new ZipCodeVO();
		zVO.setDong("가산동");
		List<ZipCodeVO> zipList = zDao.zipcodeList(zVO);
		for(ZipCodeVO rVO:zipList) {
			System.out.println(rVO);
		}
	}

}
