package com.ch12;

import java.util.List;
import java.util.Vector;

import com.google.gson.Gson;

public class JsonFormatPrint {

	public static void main(String[] args) {
	
			List<ChatVO> list = new Vector();
			ChatVO cVO = new ChatVO();
			
			cVO.setNickName("바나나");
			cVO.setAge(25);
			list.add(cVO);
			
			cVO = new ChatVO();
			cVO.setNickName("나초");
			cVO.setAge(20);
			list.add(cVO);
			
			cVO = new ChatVO();
			cVO.setNickName("치즈");
			cVO.setAge(30);
			list.add(cVO);
			
			Gson g = new Gson();
			String jsonChat = g.toJson(list);
			System.out.println(jsonChat);
	}

}

