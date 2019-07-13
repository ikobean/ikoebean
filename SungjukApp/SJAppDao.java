package SungjukApp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConnectionMgr;

public class SJAppDao  {

	java.sql.Connection con = null;
	java.sql.PreparedStatement pstmt = null;
	java.sql.ResultSet rs = null;
	com.util.DBConnectionMgr dbMgr=null;
	
	public SJAppVO sjInsert(SJAppVO paVO) {
		System.out.println("dao호출성공");
		SJAppVO raVO = new SJAppVO();
		dbMgr=DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		int status = 0;
		
		try {
			sql.append(" INSERT INTO SJAPP(NAME,JAVA,ORACLE,JSP,TOTAL,AVG,RANK) ");
			sql.append(" VALUES(?,?,?,?,?,?,?) ");
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int i=0;
			pstmt.setString(++i, paVO.getName());
			pstmt.setString(++i, paVO.getJava());
			pstmt.setString(++i, paVO.getOracle());
			pstmt.setString(++i, paVO.getJsp());
			pstmt.setString(++i, paVO.getTotal());
			pstmt.setString(++i, paVO.getAvg());
			pstmt.setString(++i, paVO.getRank());
			status=pstmt.executeUpdate();
			raVO.setStatus(status);
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbMgr.freeConnection(con, pstmt);
		}return raVO;
	}
	public List<SJAppVO> sjSelect(SJAppVO paVO) {
		List<SJAppVO> listAll = new ArrayList<SJAppVO>();
		SJAppVO raVO = new SJAppVO();
		dbMgr=DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		int status = 0;
		try {
			sql.append(" SELECT NAME,JAVA,ORACLE,JSP,TOTAL,AVG,RANK FROM SJAPP");
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			for(;rs.next();) {
				raVO = new SJAppVO();
				raVO.setName(rs.getString("name"));
				raVO.setJava(rs.getString("java"));
				raVO.setOracle(rs.getString("oracle"));
				raVO.setJsp(rs.getString("jsp"));
				raVO.setTotal(rs.getString("total"));
				raVO.setAvg(rs.getString("avg"));
				raVO.setRank(rs.getString("rank"));
				listAll.add(raVO);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {//사용한 자원 반납하기 . con, pstmt, rs
			dbMgr.freeConnection(con, pstmt, rs);
		} return listAll;
	}
}
