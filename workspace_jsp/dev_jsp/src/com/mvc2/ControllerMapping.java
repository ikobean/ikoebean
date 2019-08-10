package com.mvc2;

import com.mvc1.TestController;

public class ControllerMapping {
	static String crud = "";
	/************************************************************
	 * @param command onlineTest/getSubjectList.nb?work=select
	 * @param crud = select
	 * @return
	 ************************************************************/
	public static Controller getController(String command, String crud) {
		ControllerMapping.crud=crud;
		Controller controller = null;
		String commands[] = command.split("/"); //  /이걸 기준으로 짤라서 리턴해줌
		String work = commands[0]; //onlineTest
		String requestName = commands[1]; //test.nb?crud="select"
		if("onlineTestVer2".equals(work)) {
			controller = new Test2Controller(requestName, ControllerMapping.crud);
		}
		else if("member".equals(work)) {
			controller = new Member2Controller(requestName, ControllerMapping.crud);
		}
		return controller;
	}
}
