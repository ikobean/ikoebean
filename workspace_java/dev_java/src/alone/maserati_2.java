package alone;

public class maserati_2 {

	String maserati = "dream car"; //전역벽수
	
	int boong() {
		int boong = 0;
		boong = boong + 1;
		return boong;
	}
		
		int wheel() {
			int wheel = 4;
			wheel = wheel + 1 ;
			return wheel;
						
	}
	
	
		void factory() {
			int mac = 0;
			int factory = mac +1;
			for(mac=0; mac<10; mac=mac+1){
			factory = mac +1;					
			System.out.println(factory);
			}			
			
			
			
		}
	public static void main(String[] args) {
	
		maserati_2 dc = new maserati_2();
		
		dc.wheel();
		System.out.println(dc.wheel());
        System.out.println(dc.maserati);	
		
	}

}
