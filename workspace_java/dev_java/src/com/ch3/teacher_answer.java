package com.ch3;

public class teacher_answer {
public double getTotal (int jumsu1, int jumsu2, double jumsu3) {
	double tot = 0.0;  //초기화를 꼭 해줘야함
	tot = jumsu1 + jumsu2 + jumsu3; 
	return tot;
			
	
}

public double getAverage(double tot, int inwon) {
	double avg = 0.0;
	avg = tot/inwon;
	return avg;
	
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		teacher_answer p74 = new teacher_answer();
	    double tot = p74.getTotal(85,80, 82.5);
		int inwon = 3;
		double avg = p74.getAverage(tot, inwon);
		System.out.println(tot);
		System.out.println(avg);
		
		
	}

}

