package Rental;

import java.util.List;

public class R_searchLogic {
	RentalInterface rDao = new RentalDao();
	public List<RentalVO>  getRentalSearch(RentalVO paVO) {
		List<RentalVO> rentalList = null;
		rentalList = rDao.getRentalSearch(paVO);
		return rentalList;
		
	}
}
