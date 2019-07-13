package alone;

public class coffee {
// 삼일동안 마신 카페인 총합과 평균
	
	int cofftotal(int a, int b, int c) {
		int caff = 0;
		caff = a + b + c;
		return caff;
	}
	
	int average(int caff, int day) {
	     int avg = 0;
	     avg = caff/day;
	     return avg;
		
	}
		
	public static void main(String[] args) {
		coffee abc = new coffee();
		int total = abc.cofftotal(70, 80, 90);
		int day=3;
		int pg = abc.average(total, day);
          System.out.println(total);
          System.out.println(pg);
                 
          
	
		
		
		
		
		}
		

	}


