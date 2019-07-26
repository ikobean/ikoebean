package com.mvc1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;
import com.vo.DeptVO;

public class MyProcSimulation {
	static SqlSessionFactory sqlSessionFactory = null;
	static {sqlSessionFactory 
				=MyBatisCommonFactory.getSqlSessionFactory();
	}
	public MyProcSimulation(){
		/*
		 * 저장 프로시저의 특이사항은 파라미터로 넘긴 주소번지의 OUT 속성의 값이 담긴다는 사실이다.
		 */
		/*
		 * 참조변수가 참조하고 있는 인스턴스의 실제 타입을 알아보기 위해 instanceof 연산자를 사용합니다.
		 *  주로 조건문에 사용되며, instanceof의 왼쪽에는 참조변수를 오른쪽에는 타입(클래스명)이 피연산자로 위치합니다. 
		 *  그리고 연산의 결과로 boolean값인 true, false 중의 하나를 반환 합니다.
		 */
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			Map<String,Object> pMap = new HashMap<>();
			
			sqlSession.selectOne("my_proc",pMap);
			
			if(pMap instanceof HashMap) {
				System.out.println("여기");
			}
			System.out.println(pMap.getClass());//실제 타입을 확인
			System.out.println(pMap);
			/*
			 * sys_refcursor가 어떤 자료형으로 담아주는지를 반드시 체크
			 * 파라미터 타입을 Map으로 하였으나 그 안에 자료구조가  List 형인지 반드시 점검 
			 *
			 */
			
			
//			//리스트 타입일 때 가능 
//			Iterator iter = pMap.get("key").iterator();
//			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
//			// {mem_name="김유신", key[com.vo.DeptVO]}
//			//위와 같은 패턴일 때 아래처럼 꺼내면 됨
//			Iterator iter2 = list.iterator();
//			while(iter2.hasNext()) {
//				String s=(String)iter2.next();
//				DeptVO dVO = (DeptVO)iter2.next();
//				System.out.println(dVO.getDeptno());
//				System.out.print(dVO.getDname()+"||");
//				System.out.print(dVO.getLoc());
//				System.out.println("");
//			}
//			
//			
//			Object keys[] = pMap.keySet().toArray();//키값을 배열로 담아줌
//			for(int i=0;i<keys.length;i++) {
//				String value = (String)pMap.get(keys[i]);
//				System.out.println(value); //Object 출력 or 주소번지 출력 =>잘못된 것
//			}
//			
			
			List<DeptVO> dlist = (List<DeptVO>) pMap.get("key");
			for(DeptVO dVO:dlist) {				
				System.out.print(dVO.getDeptno()+"||");
				System.out.print(dVO.getDname()+"||");
				System.out.print(dVO.getLoc());
				System.out.println("");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new MyProcSimulation();
	}

}
