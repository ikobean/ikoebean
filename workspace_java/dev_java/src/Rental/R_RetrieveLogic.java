package Rental;
//상세조회 전체조회
import java.util.List;

public class R_RetrieveLogic {

	RentalInterface rDao = new RentalDao();
	RentalVO paVO = new RentalVO();
	
	
	public RentalVO RentalDetail(RentalVO paVO) {
		RentalVO rVO = null;
		rVO = rDao.getRentalDetail(paVO);
		return rVO;
	}
	//전체조회
	public List<RentalVO> getRentalAll(){
		System.out.println("RetrieveLogic all 호출 성공");
		List<RentalVO> rentalList = null;
		rentalList =  rDao.getRentalAll();
		return rentalList;
		
	}
}
