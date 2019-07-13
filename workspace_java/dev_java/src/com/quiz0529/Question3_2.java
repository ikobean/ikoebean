package com.quiz0529;


public class Question3_2 {

	
	
	

		 int bootch;
		 String snootch;
		
		
		 public Question3_2() {  
		 this("snootchy");    
		 System.out.print("first ");   
		 }
		
		 public Question3_2(String snootch) {  // 3
		 this(420, "snootchy");  // 4 :
		 System.out.print("second ");  // 
		 }
		
		 public Question3_2(int bootch, String snootch) {  // 5
		 this.bootch = bootch;  // 6 : 420
		 this.snootch = snootch;  // 7 : snootchy
		 System.out.print("third ");  // 8 : third
		 }
		  /*33-34-14-19-24-[420,"snootchy"- 초기화]-27(third출력)-28
		  * 21(second출력)-22-16(first출력)-35 (snootchy울력 420출력)
		  * 
		  */
		 public static void main(String[] args) {
		 Question3_2 b = new Question3_2();
		 System.out.print(b.snootch +" " + b.bootch);  //
		 }
		 
		
		
		
	}


