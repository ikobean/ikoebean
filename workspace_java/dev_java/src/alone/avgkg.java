package alone;

public class avgkg {

		int hap(int week1, int week2, int week3){
		int total = 0;
		total = week1 + week2 + week3;
		return total;
		
		
	}
	void average(int total, int weekno) {
		double avg = 0.0;
	    avg = total/(double)weekno;
		System.out.println(avg);
		
	}
	
	public static void main(String[] args) {
	
		avgkg keto = new avgkg();
		int total = keto.hap(68, 70, 80);
		
	keto.average(total, 3);
		
		
		

	}

}
