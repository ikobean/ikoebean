package com.ch7;

public class TwoArray {
   int a[] = new int[3];
   int a2[][]= new int[2][3];
   String names[]= {"정지우","유승기","정재현"};
   int a3[][]= {
		   {70,80}
          ,{90,75}
          ,{85,60} 
            };
   
   //세 친구의 총점을 담을 1차 배열 선언하기
   int tots[] = new int[3];
   double avgs[] = new double[tots.length];

   //총점을 구해서 tots 배열 초기화하기 구현
   
   public void totsInit() {
	   for(int i=0; i<tots.length;i++) {
		   tots[i]= a3[i][0]+a3[i][1];    //i는 학생수
		   System.out.println("tots["+i+"]="+tots[i]);
		   
	   }
       avgsInit(a3[0].length);
}
       
   public void avgsInit(int inwon) {
	   for(int i=0;i<tots.length;i++) {
		   avgs[i] = tots[i]/inwon;
	
		   System.out.println("avgs["+i+"]="+avgs[i]); 
	   }
	  
	      }
   
   
   //석차를 구해서 출력해 보시오.
    public void ranking() {
    	
    int rnks[] = {1,1,1}; //순위는 0부터가 아니고 1부터 이므로 3개방에 1로 초기화 한다.
    for(int i=0; i<rnks.length;i++) {
    	for(int j=0;j<rnks.length;j++) {
    		//총점을 비교하여 총점이 작은 편이 순위를 1증가 시킨다.
    		if(tots[i]>tots[j]) {
    			rnks[j]++;    		

    	   }
       }
    } 
    System.out.println("========[[석차 출력]]========");
    for(int rnk:rnks) {System.out.println(rnk);
    }
    }
	public static void main(String[] args) {
		TwoArray ta = new TwoArray();
		ta.totsInit();
		ta.ranking();
		System.out.println(ta.a[0]);  //0
		System.out.println(ta.a2[0]); //0
		for(int i=0; i<ta.a2.length;i++) { //행이 두개. i<2
		  for(int j=0; j<ta.a2[i].length;j++){ //j<3	
		      System.out.println("a2["+i+"]["+j+"]="+ta.a2[i][j]);
		      
		      
		  }
		

		  
	}

	}}

