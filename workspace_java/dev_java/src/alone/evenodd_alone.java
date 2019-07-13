package alone;

public class evenodd_alone {

	public static void main(String[] args) {
		//1부터 50까지 5배수의 합을 구하시오.
		int i = 0;
		int sum=0;
		for(i = 0; i <=50; i++) {
				if(i%5==0) {
					sum += i;
				}
			}
		System.out.println(sum);
			
		}
		

	}



