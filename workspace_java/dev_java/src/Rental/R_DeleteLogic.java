package Rental;
//삭제
public class R_DeleteLogic {
	RentalInterface rDao = new RentalDao();
	
	public RentalVO RentalDelete(RentalVO paVO) {
		System.out.println(paVO);
		RentalVO rVO = new RentalVO();
		System.out.println(" R_DeleteLogic update 호출 성공");
		rVO = rDao.RentalDelete(paVO);
		return rVO;
		
	}

}

