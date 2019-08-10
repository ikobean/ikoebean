package com.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/*
 * 사용자가 입력한 값을 읽을 때마다 반복되는 request.getParameter()를 대신해서
 * 사용할 수 있는 bind 메소드 추가하기
 * 리턴 타입은 void로 하지만 파라미터를 Map 타입으로 하여 
 */
public class HashMapBinder {
	HttpServletRequest req = null;
	//req 객체를 서블릿에서 받아와야 하니까.
	public HashMapBinder(HttpServletRequest req) {
		//??
		this.req = req;
	}
	//get방식 요청시 사용할 것
	/*********************************************************
	 * @param target Map<String,Object> 객체생성해서 넘길 것.
	 *	주의 : NullPointerException 맞기 싫으면...
	 *********************************************************/
	public void bind(Map<String,Object> target) {
		//p77의 11-15행 대신 쓰려는 것
		//파라미터로 넘어온 target 안에 다른 정보가 담겨있다면 제거
		target.clear();
		Enumeration er = req.getParameterNames(); //name,address,pet
		while(er.hasMoreElements()) {
			String name = (String)er.nextElement(); //name,address,pet
			if("pet".equals(name)) {
				String values[] = req.getParameterValues(name); //선택한 dog/cat/pig
				String myPet="";
				if(values!=null) {
					for(int i=0;i<values.length;i++) {
						myPet+=values[i]+" ";
					}
					target.put("pet", myPet);
				}
			}
			//key에는  name,address,pet이 와야 함
			//value에는 각 key가 가리키는 값이 오면 됨.
			else {
				target.put(name,req.getParameter(name)); //address,주소 . name,이름이 들어감
			}
			//HangulConversion.toUTF(req.getParameter(name)) post 방식에만 가능함. 
			//get일때는 req.getParameter(name)
			//target.put(address,req.getParameter(address));
			//target.put(pet,req.getParameter(pet));
			
		}
	}
	//post방식으로 요청시 사용할 것. 한글처리 인코딩 타입은 UTF-8로 하였음.
	public void bindPost(Map<String,Object> target) {
		//p77의 11-15행 대신 쓰려는 것
		//파라미터로 넘어온 target 안에 다른 정보가 담겨있다면 제거
		target.clear();
		Enumeration er = req.getParameterNames(); //name,address,pet
		while(er.hasMoreElements()) {
			String name = (String)er.nextElement(); //name,address,pet
				target.put(name,HangulConversion.toUTF(req.getParameter(name))); //address,주소 . name,이름이 들어감
			//HangulConversion.toUTF(req.getParameter(name)) post 방식에만 가능함. 
			//get일때는 req.getParameter(name)
			//target.put(address,req.getParameter(address));
			//target.put(pet,req.getParameter(pet));
		}
	}
}


