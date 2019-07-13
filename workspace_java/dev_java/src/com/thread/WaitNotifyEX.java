package com.thread;
class ATMTwo implements Runnable{
	private long depositMoney = 10000;
	/*
	 * wait()와 notifyAll() 동기화 블록 안에서만 사용.
	 * 이 메소드를 제공하는 이유는 데드락 상태를 방지하기 위해서 사용.
	 * 
	 */
	@Override
	public void run() {
		synchronized(this){
			for(int i=0; i<10; i++) {//지연처리
				//if문 사용시 실행문이 한줄이면 { }생략가능
				if(getDepositMoney()<=0)  break;
				withDraw(1000);	
				//잔고가 짝수금액일 땐 강제로 지연을 시킴.
				if(getDepositMoney()%2000==0) {
					/* if(getDepositMoney()==2000
					 * ||(getDepositMoney()==4000
					 * ||(getDepositMoney()==6000
					 * ||(getDepositMoney()==8000
					 * )
					 */
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}else {
					this.notify();
				}
			}//////////////////end of for
		}
	}
	public void withDraw(long howMuch) {
		//잔고가 0보다 크니?
				if(getDepositMoney()>0) {
					depositMoney-=howMuch;
				System.out.println(Thread.currentThread().getName());
				//잔액을 반환하는 메소드에 리턴값으로 %d 자리를 채움
				System.out.printf("잔액 : %d원 %n", getDepositMoney());
				}
				else {
				//잔고가 0보다 작거나 요청 금액보다 작을 때 
					System.out.print(Thread.currentThread().getName()+" :");
				System.out.println("잔액이 부족합니다.");
				}
			}
		
	
	//insert here - withDraw()선언
	private long getDepositMoney() {
		return depositMoney;
	}
}
public class WaitNotifyEX {

	public static void main(String[] args) {
		ATMTwo atm = new ATMTwo();

		//insert here - 엄마와 아들 스레드 추가
		Thread mother = new Thread(atm,"mother");//엄마스레드 추가
		Thread son = new Thread(atm,"son");	//아들스레드 추가
		
		mother.start();
		son.start();
	}

}
