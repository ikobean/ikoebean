package com.ch2;

public class practice_190508 {
//전역변수
	
	void movie() {
	int movie;
	for(movie=0; movie<=3; movie++){
		System.out.println("어벤저스"+(movie+1));
		
	}
			
   
	//int genre = 5;
	//String theater = "CGV";
	}
	void region(String SEOUL) {
		SEOUL = "대한민국 수도 서울특별시";
		System.out.println(SEOUL);
	}
			
	
	public static void main(String[] args) {
      practice_190508 vt = new practice_190508();
      vt.region("SEOUL");
vt.movie();
      //System.out.println(vt.theater);

      

      
		
	}

}
