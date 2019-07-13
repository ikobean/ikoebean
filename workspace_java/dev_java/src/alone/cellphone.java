package alone;

public class cellphone {
	
       int hap(int jan, int feb, int mar) {
    	   int bill = 0;
    	   bill = jan + feb + mar;
    	   return bill;    	       	  
        }	
       
       void average(int bill, int quarter) {
    	   double avg = 0;
    	   avg = bill/ quarter;
    			System.out.println(avg);   
    	   
    	    	   
    	   
       }
       
	public static void main(String[] args) {
            cellphone iphone = new cellphone();
            int bill = iphone.hap(7002, 8900, 1234);
            
            iphone.average(bill, 3);
	

}
}