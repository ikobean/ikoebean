package Rental;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConnectionMgr;


public class RentalDao implements RentalInterface {
	java.sql.Connection 			con		 = null;
	java.sql.PreparedStatement		pstmt	 = null;
	java.sql.ResultSet 				rs 		 = null;
	java.sql.CallableStatement 		cstmt 	 = null;         // 얘네 java.sql 기억! (다른 곳에 같은 이름있음)
	com.util.DBConnectionMgr 		dbMgr	 = null;
	@Override
	
	public RentalVO getRentalDetail(RentalVO paVO) {
		System.out.println("DAO rentalDetail");
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT RENT_NO,ORDER_DATE, PAY_MET, PAY_DATE  			");
		sql.append("  ,RENT_TERM,VISIT_DATE,DEPOSIT,FIRST_INSTALL_DATE	");                                             
		sql.append("    ,MEM_ID,RENT_FEE,PRO_CODE,RENT_FEE_SUM,RENT_QUAN     ");  
		sql.append(" FROM RENT 												");            
		sql.append(" WHERE RENT_NO=?											");
		RentalVO rVO = null;
		try {
	        	 con = dbMgr.getConnetion();
	        	 pstmt = con.prepareStatement(sql.toString());
	        	 pstmt.setString(1,paVO.getMem_id());
	        	 rs = pstmt.executeQuery();
	        	if(rs.next()) {
	        		rVO = new RentalVO();
					rVO.setRent_no(rs.getString("Rent_no"));                             
					rVO.setOrder_date(rs.getString("Order_date"));                      
					//rVO.//setPaylist("0");         
					rVO.setPay_date(rs.getString("Pay_date"));                          
					rVO.setRent_term(rs.getString("Rent_term"));                        
					rVO.setVisit_date(rs.getString("Visit_date"));                      
					rVO.setDeposit(rs.getString("Deposit"));                            
					rVO.setFirst_install_date(rs.getString("First_install_date"));      
					rVO.setMem_id(rs.getString("Mem_id"));                              
					rVO.setRent_fee(rs.getString("Rent_fee"));                          
					rVO.setPro_code(rs.getString("Pro_code"));                          
					rVO.setRent_fee_sum(rs.getString("Rent_fee_sum"));                  
					rVO.setRent_quan(rs.getString("Rent_quan"));                        
				
	        	 }
	          }
	     	  catch(Exception e) {
	     		  e.printStackTrace();
	     	  }
	          finally {//사용한 자원 반납하기. con,pstmt,rs
	   		  dbMgr.freeConnection(con, pstmt);
	   	  }
	          return rVO;
		}

	

	@Override
	public RentalVO RentalInsert(RentalVO paVO) {
		RentalVO rVO = new RentalVO();
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		int status = 0;
		try {
			 sql.append(" Insert into RENT (RENT_NO,ORDER_DATE, PAY_MET, PAY_DATE            ");
			 sql.append("                ,RENT_TERM,VISIT_DATE,DEPOSIT,FIRST_INSTALL_DATE  ");
			 sql.append("              ,MEM_ID,RENT_FEE,PRO_CODE,RENT_FEE_SUM,RENT_QUAN)   ");
			 sql.append(" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)          ");
			 
			 
			 con = DBConnectionMgr.getConnetion();
			 pstmt = con.prepareStatement(sql.toString());
			 int i = 0;
			 pstmt.setString(++i, paVO.getRent_no());
			 pstmt.setString(++i, paVO.getOrder_date());
			 pstmt.setString(++i, paVO.getPay_met());
			 pstmt.setString(++i, paVO.getPay_date());
			 pstmt.setString(++i, paVO.getRent_term());
			 pstmt.setString(++i, paVO.getVisit_date());
			 pstmt.setString(++i, paVO.getDeposit());
			 pstmt.setString(++i, paVO.getFirst_install_date());
			 pstmt.setString(++i, paVO.getMem_id());
			 pstmt.setString(++i, paVO.getRent_fee());
			 pstmt.setString(++i, paVO.getPro_code());
			 pstmt.setString(++i, paVO.getRent_fee_sum());
			 pstmt.setString(++i, paVO.getRent_quan());
			 
			 status = pstmt.executeUpdate();
			 System.out.println(status);
			 rVO.setStatus(status);
			 
			 
		} catch (SQLException se) {
			System.out.println(sql.toString());
		} catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			dbMgr.freeConnection(con, pstmt);
		}
		return rVO;
		
	}
	
	@Override
	public RentalVO RentalUpdate(RentalVO paVO) {
		RentalVO rVO = new RentalVO();
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		int status = 0;
			 sql.append(" UPDATE RENT SET ORDER_DATE=?, PAY_MET=?, PAY_DATE=?            ");
			 sql.append("                ,RENT_TERM=?,VISIT_DATE=?,DEPOSIT=?,FIRST_INSTALL_DATE=?  ");
			 sql.append("              ,RENT_FEE=?,RENT_FEE_SUM=?,RENT_QUAN=?   ");
			 sql.append(" WHERE MEM_ID=?         ");
	     try { 
	    	 con = dbMgr.getConnetion();
			 pstmt = con.prepareStatement(sql.toString());
			 int i = 0;
			 pstmt.setString(++i, paVO.getOrder_date());
			 pstmt.setString(++i, paVO.getPay_met());
			 pstmt.setString(++i, paVO.getPay_date());
			 pstmt.setString(++i, paVO.getRent_term());
			 pstmt.setString(++i, paVO.getVisit_date());
			 pstmt.setString(++i, paVO.getDeposit());
			 pstmt.setString(++i, paVO.getFirst_install_date());
			 pstmt.setString(++i, paVO.getRent_fee());
			 pstmt.setString(++i, paVO.getRent_fee_sum());
			 pstmt.setString(++i, paVO.getRent_quan());
			 pstmt.setString(++i, paVO.getMem_id());
			 
			 status = pstmt.executeUpdate();
			 rVO.setStatus(status);
			 
		} catch (SQLException se) {
			System.out.println(se.toString());
			System.out.println(sql.toString());
		} catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			dbMgr.freeConnection(con, pstmt);
		}
		return rVO;
	}

	@Override
	public RentalVO RentalDelete(RentalVO paVO) {
		StringBuilder sql = new StringBuilder();
		RentalVO rVO = new RentalVO(); //안하면 nullpointerexception
		sql.append(" DELETE from RENT where MEM_ID = ? " ); //?는 1번부터.
		dbMgr = DBConnectionMgr.getInstance();
		int status = 0;
		try {
			con = dbMgr.getConnetion(); //연결
			pstmt = con.prepareStatement(sql.toString()); //쿼리문 담기
			pstmt.setString(1, paVO.getMem_id()); //아이디넣어주기
			System.out.println(paVO.getMem_id());
			status = pstmt.executeUpdate();
			System.out.println(status);
			rVO.setStatus(status);
		} catch (SQLException se) {
			System.out.println(se.toString());
		}catch (Exception e) {
			e.printStackTrace();
			
		} 
		finally {
			dbMgr.freeConnection(con, pstmt);
		}
		return rVO;
	}
	
	
	@Override
	public List<RentalVO> getRentalAll() {
		List<RentalVO> list = new ArrayList<RentalVO>();
		dbMgr = DBConnectionMgr.getInstance();
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT RENT_NO,ORDER_DATE, PAY_MET,PAY_DATE	  ");
		sql.append(" ,RENT_TERM,VISIT_DATE,DEPOSIT,FIRST_INSTALL_DATE" );
		sql.append(" ,MEM_ID, RENT_FEE,PRO_CODE,RENT_FEE_SUM,RENT_QUAN");
		sql.append(" FROM RENT order by RENT_NO" );
				
		try {
			con = dbMgr.getConnetion();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			RentalVO rVO = null;
			while(rs.next()) {
				rVO= new RentalVO();
				rVO.setRent_no(rs.getString("RENT_NO"));
				rVO.setOrder_date(rs.getString("ORDER_DATE"));
				rVO.setPay_met(rs.getString("PAY_MET"));
				rVO.setPay_date(rs.getString("PAY_DATE"));
				rVO.setRent_term(rs.getString("RENT_TERM"));
				rVO.setVisit_date(rs.getString("VISIT_DATE"));
				rVO.setDeposit(rs.getString("DEPOSIT"));
				rVO.setFirst_install_date(rs.getString("FIRST_INSTALL_DATE"));
				rVO.setMem_id(rs.getString("MEM_ID"));
				rVO.setRent_fee(rs.getString("RENT_FEE"));
				rVO.setPro_code(rs.getString("PRO_CODE"));
				rVO.setRent_fee_sum(rs.getString("RENT_FEE_SUM"));
				rVO.setRent_quan(rs.getString("RENT_QUAN"));
				list.add(rVO);				
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			dbMgr.freeConnection(con, pstmt);
		}
		System.out.println(list);
		 return list;
	}		 
		 
		 		@Override
				public List<RentalVO> getRentalSearch(RentalVO paVO) {
				dbMgr = DBConnectionMgr.getInstance();
				StringBuilder sql = new StringBuilder();
				sql.append("SELECT RENT_NO,ORDER_DATE, PAY_MET, PAY_DATE,RENT_TERM,VISIT_DATE,DEPOSIT,FIRST_INSTALL_DATE,MEM_ID,RENT_FEE,PRO_CODE,RENT_FEE_SUM, RENT_QUAN FROM RENT");
				if(paVO.getCombobox()=="렌트번호") {
				sql.append("   WHERE RENT_NO LIKE '%'||?||'%'  " );
				}else if(paVO.getCombobox()=="주문날짜") {
				sql.append("   WHERE ORDER_DATE LIKE '%'||?||'%'  " );
				}
				else if(paVO.getCombobox()=="지불방법") {
				sql.append("   WHERE PAY_MET LIKE '%'||?||'%'  " );
				}else if(paVO.getCombobox()=="지불날짜") {
				sql.append("   WHERE PAY_DATE LIKE '%'||?||'%'  " );
				}else if(paVO.getCombobox()=="렌트기간") {
				sql.append("   WHERE RENT_TERM LIKE '%'||?||'%'  " );
				}else if(paVO.getCombobox()=="방문날짜") {
				sql.append("   WHERE VISIT_DATE LIKE '%'||?||'%'  " );
				}else if(paVO.getCombobox()=="디파짓") {
					sql.append("   WHERE DEPOSIT LIKE '%'||?||'%'  " );
				}else if(paVO.getCombobox()=="설치날짜") {
					sql.append("   WHERE FIRST_INSTALL_DATE LIKE '%'||?||'%'  " );
				}else if(paVO.getCombobox()=="아이디") {
					sql.append("   WHERE MEM_ID LIKE '%'||?||'%'  " );
				}else if(paVO.getCombobox()=="월별렌트비") {
					sql.append("   WHERE RENT_FEE LIKE '%'||?||'%'  " );
				}else if(paVO.getCombobox()=="제품코드") {
					sql.append("   WHERE PRO_CODE LIKE '%'||?||'%'  " );
				}else if(paVO.getCombobox()=="총렌트비") {
					sql.append("   WHERE RENT_FEE_SUM LIKE '%'||?||'%'  " );
				}else if(paVO.getCombobox()=="렌트수량") {
					sql.append("   WHERE RENT_QUAN  LIKE '%'||?||'%'  " );
				}else if(paVO.getCombobox()=="전체") {
				sql.append("   WHERE RENT_NO LIKE '%'||?||'%' " );
				sql.append("   OR ORDER_DATE LIKE '%'||?||'%' " );
				sql.append("   OR PAY_MET LIKE '%'||?||'%' " );
				sql.append("   OR PAY_DATE LIKE '%'||?||'%' " );
				sql.append("   OR RENT_TERM  LIKE '%'||?||'%' " );
				sql.append("   OR VISIT_DATE LIKE '%'||?||'%' " );
				sql.append("   OR DEPOSIT LIKE '%'||?||'%' " );
				sql.append("   OR FIRST_INSTALL_DATE LIKE '%'||?||'%' " );
				sql.append("   OR MEM_ID LIKE '%'||?||'%' " );
				sql.append("   OR RENT_FEE LIKE '%'||?||'%' " );
				sql.append("   OR PRO_CODE LIKE '%'||?||'%' " );
				sql.append("   OR RENT_FEE_SUM LIKE '%'||?||'%' " );
				sql.append("   OR RENT_QUAN LIKE '%'||?||'%' " );
				}
				List<RentalVO> rentalList = new ArrayList<RentalVO>();
				RentalVO rVO = null;
				try {
				con = dbMgr.getConnetion();
				pstmt = con.prepareStatement(sql.toString());
				int i =0;
				if(paVO.getCombobox()=="전체") {
				pstmt.setString(++i,paVO.getKeyword() );
				pstmt.setString(++i,paVO.getKeyword() );
				pstmt.setString(++i,paVO.getKeyword() );
				pstmt.setString(++i,paVO.getKeyword() );
				pstmt.setString(++i,paVO.getKeyword() );
				pstmt.setString(++i,paVO.getKeyword() );
				pstmt.setString(++i,paVO.getKeyword() );
				pstmt.setString(++i,paVO.getKeyword() );
				pstmt.setString(++i,paVO.getKeyword() );
				pstmt.setString(++i,paVO.getKeyword() );
				pstmt.setString(++i,paVO.getKeyword() );
				pstmt.setString(++i,paVO.getKeyword() );
				pstmt.setString(++i,paVO.getKeyword() );
				}else {
				i=0;
				pstmt.setString(++i,paVO.getKeyword() );
				}
				rs = pstmt.executeQuery();
				while(rs.next()) {
				rVO = new RentalVO();
				rVO.setRent_no			  (rs.getString("RENT_NO"));
				rVO.setOrder_date         (rs.getString("ORDER_DATE"));
				rVO.setPay_met            (rs.getString("PAY_MET"));
				rVO.setPay_date           (rs.getString("PAY_DATE"));
				rVO.setRent_term          (rs.getString("RENT_TERM"));
				rVO.setVisit_date         (rs.getString("VISIT_DATE"));
				rVO.setDeposit            (rs.getString("DEPOSIT"));
				rVO.setFirst_install_date (rs.getString("FIRST_INSTALL_DATE"));
				rVO.setMem_id             (rs.getString("MEM_ID"));
				rVO.setRent_fee           (rs.getString("RENT_FEE"));
				rVO.setPro_code           (rs.getString("PRO_CODE"));
				rVO.setRent_fee_sum       (rs.getString("RENT_FEE_SUM"));
				rVO.setRent_quan          (rs.getString("RENT_QUAN"));
				rentalList.add(rVO);       
				}
				}catch (SQLException se) {
				System.out.println(se.toString());
				System.out.println(sql.toString());
				se.printStackTrace();
				} catch (Exception e) {
				System.out.println(e.toString());
				} finally {
				dbMgr.freeConnection(con, pstmt);
				}
				
				return rentalList;
				}

	}


