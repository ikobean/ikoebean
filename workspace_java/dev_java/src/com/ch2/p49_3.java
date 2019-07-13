package com.ch2;

public class p49_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
float f1 = 3.14f;
double d1 = 3.14d;
//f1 = d1; //float는 4바이트기 때문에 더블이 들어갈 수가 없음. !!에러!!
d1=f1; //더블은 8바이트기 때문에 float가 들어갈 수 있음!
System.out.println(f1);
System.out.println("babo:"+f1);
System.out.println(f1);
System.out.println(f1);

	//대입연산자 기준으로 오른쪽에 오는 타입은 
    //반드시 왼쪽 타입보다 작은 타입 이어야 합니다.
    //
    //*
    //*byte<short<int<long<float<double
    //*
    //*
    //
    
int wg1=3;
int wg2=6;
int wg3=9;
int total = wg1+wg2+wg3;
double avg = total/3.0;
System.out.println(avg);
	
   //int+int=int
   //int+string=string
   //int-int=int
   //int/int=int
   //int*int=int

//""+avg2+avg3
//" "+(avg2+avg3)); 글씨 나오게 하는 거


	
	}

}
