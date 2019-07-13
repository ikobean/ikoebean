package Rental;

//업데이트
public class R_ModifyLogic {
		RentalInterface rDao = new RentalDao();
		public RentalVO RentalUpdate(RentalVO paVO) {
			RentalVO rVO = null;
			System.out.println(" R_ModifyLogic update 호출 성공");
			rVO = rDao.RentalUpdate(paVO);
			return rVO;
		}
		
		public RentalVO RentalDetail(RentalVO paVO) {
			//상세조회
			RentalVO rVO = null;
			System.out.println("RetrieveLogic Detail 호출 성공");
			rVO= rDao.getRentalDetail(paVO);
			return rVO;
			}
			
	}

