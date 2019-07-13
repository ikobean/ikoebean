package com.util;

import java.sql.CallableStatement;
import java.sql.Connection;
/*
 * 오라클은 동시 접속자들을 세션으로 관리하는데
 * 일정 개수의 세션을 넘어서면 서버 접속 불가 - 연결불가
 * 자바단에서 사용한 자원 반드시 반납할 것. - 자바튜닝 권고사항(무조건 지켜야함)
 * 물리적으로 떨어져있는 오라클 서버에 접속할 때 - Connection
 * 연결 통로를 통해서 DML 구문을 가져가고 요청한다.
 *  PreparedStatement, CallableStatement, ResultSet
 * select ->트랜잭션 처리 대상이 아님 - 테이블에 변화가 없다.  
 * pstmt.executeQuery():ResultSet-> Cursor조작  rs.next(), rs.isFirst(),
 * 											 rs.isLast(), rs.absolute(3); 요청(셀렉트문 처리해줘)
 * insert, update, delete => 트랜잭션 처리 대상 - 물리적인 변화
 * pstmt.executeUpdate():int (리턴타입이 int라서 )
 *
 */
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DBConnectionMgr {
	static final String _DRIVER  = "oracle.jdbc.driver.OracleDriver";
	//1)드라이버 연결 방식(thin: 멀티 tier에서 사용하는데 적합, oci)
	//2)서버의 네트워크 정보 - 1521(디폴트) -SID명 (orcl11)
	//3)user, pw
    static final String _URL     = "jdbc:oracle:thin:@192.168.0.187:1521:orcl11";
    static final String _USER    = "scott";
    static final String _PW      = "tiger";
    //하나의 객체로 사용하기 위해 static으로 선언하였다. 
    static DBConnectionMgr dbMgr = null;
    
    //EmpJDBC.java에서 직접 인스턴스화 하지 않는다.(결합도가 낮아진다.)
    //복제본이 아닌 원본 하나를 사용하기 위해서  null체크해서 객체 생성
    public static DBConnectionMgr getInstance() {
    	if(dbMgr==null) {
    		dbMgr = new DBConnectionMgr();
    	}
    		return dbMgr;
    }
    //연결통로 - Tomcat서버와 오라클서버 연결 
    public static Connection getConnection() { //커넥션을 얻어오는 메소드를 설계하자
    	Connection con = null;
    	try {
    		//외부의 클래스이름을 로딩 - 오라클서버에 대한 정보를 얻기 - ojdbc6.jar build path 메뉴
    		Class.forName(_DRIVER); //드라이버 클래스 메모리 로딩 
    		con = DriverManager.getConnection(_URL, _USER, _PW);
    	}catch(ClassNotFoundException ce) {
    		System.out.println("드라이버 클래스를 찾을 수 없다.");
    		
    	}catch(Exception e) {
    		System.out.println("오라클 서버 연결 실패!!!.");
    	}
 
    	return con;
    }
    //사용한 자원 반납하기 - 오라클 세션과 관련 있으므로 반드시 할 것.
    //사용한 자원 반납 순서는 생성된 역순으로 반납할 것
    public void freeConnection(Connection con, PreparedStatement pstmt) {
    	if(pstmt!=null) {
    		try {
				pstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
    	}
    	if(con!=null) {
    		try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
    	}
    		
    }
    	
    
    public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
    	if(rs!=null) {
    		try {
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
    	}
    	if(pstmt!=null) {
    		try {
				pstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
    	}
    	if(con!=null) {
    		try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
    	}
    	
    	
    }
    public void freeConnection(Connection con, CallableStatement cstmt) {
    	if(cstmt!=null) {
    		try {
				cstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
    	}
    	if(con!=null) {
    		try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
    	}
    	
    }
    public void freeConnection(Connection con, CallableStatement cstmt, ResultSet rs) {
    	
    	if(rs!=null) {
    		try {
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
    	}
    	if(cstmt!=null) {
    		try {
				cstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
    	}
    	if(con!=null) {
    		try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
    	}
    	
    }
}






