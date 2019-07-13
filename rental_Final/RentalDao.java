package rental;

import java.sql.SQLException;

import com.address.AddressVO;
import com.util.DBConnectionMgr;
public class RentalDao implements RentalInterface {
	java.sql.Connection 			con		 = null;
	java.sql.PreparedStatement		pstmt	 = null;
	java.sql.ResultSet 				rs 		 = null;
	java.sql.CallableStatement 		cstmt 	 = null;         // 얘네 java.sql 기억! (다른 곳에 같은 이름있음)
	com.util.DBConnectionMgr 		dbMgr	 = null;
	
	@Override
	public RentalVO getRentalDetail(RentalVO paVO) {
		//RentalVO raVO = null;
		//return raVO;
		
		System.out.println("DAO addressDetail호출 성공");
		return null;
	}

	
	@Override
	
	public RentalVO RentalInsert(RentalVO paVO) {
		//RentalVO raVO = null;
		//return raVO;
		System.out.println("DAO addressInsert호출 성공");
		RentalVO raVO = new RentalVO();
		dbMgr= DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		
		int status = 0; //0이면 입력 실패, 1이면 입력 성공
		try {
			                                           
		sql.append("INSERT INTO RENT(RENT_NO, ORDER_DATE,  PAY_DATE, RENT_TERM, VISIT_DATE, DEPOSIT  ");
		sql.append(" ,FIRST_INSTALL_DATE, MEM_ID, RENT_FEE,PRO_CODE, RENT_FEE_SUM, RENT_QUAN)   ");
        sql.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)   ");
                con = dbMgr.getConnetion();
        		pstmt = con.prepareStatement(sql.toString());
        		int i=0;
        		/*
        		 * java.sql.SQLException: 인덱스에서 누락된 IN 또는 OUT 매개변수:: 1
        		 * 원인: PreaparedStatement 사용시 인덱스 값 치환 누락
        		 * 해결방법: ? 물음표 자리에 대응되는 값을 설정할 것.
        		 */
        		pstmt.setString(++i, paVO.getRent_no());
        		pstmt.setString(++i, paVO.getOrder_date());
        		pstmt.setString(++i, paVO.getPay_met());
        		pstmt.setString(++i, paVO.getPay_date ());
        		pstmt.setString(++i, paVO.getRent_term());
        		pstmt.setString(++i, paVO.getVisit_date ());
        		pstmt.setDouble(++i, paVO.getDeposit ());
        		pstmt.setString(++i, paVO.getFirst_install_date ());
        		pstmt.setString(++i, paVO.getMem_id ());
        		pstmt.setDouble(++i, paVO.getRent_fee ());
        		pstmt.setDouble(++i, paVO.getPro_code  ());
        		pstmt.setDouble(++i, paVO.getRent_fee_sum ());
        		pstmt.setDouble(++i, paVO.getRent_quan ());
        		
         
        		 //입력된 후에 오라클 서버로부터 응답 받은 값 - int
        		status = pstmt.executeUpdate();
        		System.out.println(status);
        		//Dao 계층에서 처리된 결과를 리턴타입인 raVO(addressVO)에 담자
        		raVO.setStatus(status);//AddressVO status 변수에 1 저장
			
		} catch (SQLException se) { //ORA-XXXX
			// TODO: handle exception 
			System.out.println(se.toString());
			System.out.println(sql.toString());
		} catch (Exception e) { //ORA-XXXX
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			dbMgr.freeConnection(con, pstmt);
		}
		return raVO;
		
	
		
	}

	@Override
	public RentalVO RentalUpdate(RentalVO paVO) {
		RentalVO raVO = null;
		return raVO;
	}

	@Override
	public RentalVO RentalDelete(RentalVO paVO) {
		RentalVO raVO = null;
		return raVO;
	}

	@Override
	public RentalVO getRental(RentalVO paVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
