<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mvc1.MemberDaoo,com.vo.MemberVO" %>
<%@ page import="java.util.List,java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map,java.util.HashMap,com.google.gson.Gson" %>



<%
	MemberDaoo mDao = new MemberDaoo();
	//MemberVO mVO = new MemberVO();
/* 	mDao.my_proc(mVO);
	ArrayList aList = mVO.getKey();
 	Iterator iter = aList.iterator();
	//ArrayList 안에는 어떤 타입이 들어있지? MemberVO
	while(iter.hasNext()){
		mVO = (MemberVO)iter.next();
		out.print(mVO.getMem_id()+", "+mVO.getMem_name()+", "+mVO.getMem_pw());
	} 
	 */
	
	Map<String, Object> pMap = new HashMap<>();
	mDao.my_proc2(pMap);
	//out.print("<br>");
	List list = (List)pMap.get("key");
	//out.print(list.size());
/* 	for(int i=0; i<list.size();i++){
		mVO = (MemberVO)list.get(i);
		out.print(mVO.getMem_id()+""+mVO.getMem_pw()+mVO.getMem_name());
	}
	 */
	
	//out.print(mVO);
	//주소번지. 실제 값에 접근할 수 있는 게 아님.
	//out.print(mVO.getKey());
	//out.print(mVO.getMem_id()+", "+mVO.getMem_name()+", "+mVO.getMem_pw());
	//위와 같은 방법으로는 아이디나 이름, 비번을 꺼낼 수 없다.
	//out.print(mVO.getKey().getClass());//클래스 타입
	//out.print(aList+", "+aList.get(0)); 
/* 	for(int i=0; i<aList.size();i++){
		mVO = aList.get(i);
		out.print(mVO.getMem_id()+", "+mVO.getMem_name()+", "+mVO.getMem_pw());
	} */
/* 	if(mVO.getKey().getClass()){ 
		
	}else{
		
	} */
	Gson g = new Gson();
	String imsi = g.toJson(list);
	out.print(imsi);
%>
