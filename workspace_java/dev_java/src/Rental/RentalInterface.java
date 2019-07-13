package Rental;

import java.util.List;


import Rental.RentalVO;

public interface RentalInterface {
	
	//상세조회 처리를 위한 추상 메소드 선언
	public RentalVO getRentalDetail(RentalVO paVO);
	//입력 처리를 위한 추상 메소드 선언
	public RentalVO RentalInsert(RentalVO paVO);
	//수정처리를 위한 추상 메소드 선언
	public RentalVO RentalUpdate(RentalVO paVO);
	//삭제처리를 위한 추상 메소드 선언
	public RentalVO RentalDelete(RentalVO paVO);
	//전체조회 처리를 위한 추상 메소드 선언
	public List<RentalVO>  getRentalAll();
	public List<RentalVO> getRentalSearch(RentalVO paVO);
	
	
}
