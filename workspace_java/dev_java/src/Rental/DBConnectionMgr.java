package Rental;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/*
 * 오라클은 동시 접속자들을 세션으로 관리하는데 
 * 일정 개수의 세션을 넘어서면 서버 접속 불가 - 연결불가
 * 자바단에서 사용한 자원 반드시 반납할 것. - 자바튜닝 권고사항
 * 물리적으로 떨어져 있는 오라클 서버에 접속할 때 - Connection
 * 연결통로를 통해서 DML구문을 가져가고 요청한다. 
 * PreparedStatement, CallableStatement, ResultSet
 * select -> 트랜잭션처리대상이 아님 - 테이블에 변화가 없다.  
 * pstmt.executeQuery():ResultSet -> Cursor조작 rs.next(), rs.isFirst()
 *                                           , rs.isLast(), rs.absolute(3);
 * insert,update,delete => 트랜잭션 처리 대상 - 물리적인 변화
 * pstmt.executeUpdate():int
 */
public class DBConnectionMgr {
	public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String _URL    = "jdbc:oracle:thin:@192.168.0.242:1521:orcl11";
	public static final String _USER   = "scott";
	public static final String _PW 	   = "tiger";	
	static DBConnectionMgr dbMgr = null;
	//EmpJDBC.java에서 직접 인스턴스화 하지 않는다.(결합도 낮아진다)
	public static DBConnectionMgr getInstance() {
		if(dbMgr == null) {
			dbMgr = new DBConnectionMgr();
		}
		return dbMgr;
	}
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(_DRIVER);
			con = DriverManager.getConnection(_URL, _USER, _PW);
		} catch (ClassNotFoundException ce) {
			System.out.println("드라이버 클래스를 찾을 수  없다.");
		} catch(Exception e) {
			System.out.println("오라클 서버 연결 실패!!!.");
		}
		return con;
	}
	//사용한 자원 반납하기 - 오라클 세션과 관련 있으므로 반드시 할 것.
	public void freeConnection(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void freeConnection(Connection con, CallableStatement cstmt) {
		try {
			if(cstmt!=null) {
				cstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	//사용한 자원 반납 순서는 생성된 역순으로 반납할 것.
	public void freeConnection(Connection con, CallableStatement cstmt, ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(cstmt!=null) {
				cstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
}





