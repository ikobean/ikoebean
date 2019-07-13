package com.thread;
class ATM implements Runnable{
/*
 * 테스트 결과 보고서 
 * run 메소드가 동기화 처리 되어 있으므로 먼저 선정한 스레드가 작업을 마칠 때 까지 다른 스레드는 기회를 갖지 못함.
 * 금액이 부족하면 출금이 불가하므로 선정한 스레드가 작업이 끝나더라도 다른 스레드는 기회가 없음.
 * 어떤 스레드가 먼저 선정할 지는 예측할 수가 없음.
 * 다시 말해 먼저 start() 호출했다 하더라도 나중에 호출된 스레드가 먼저 진입할 수 있음.
 * 스레드에 가중치를 부여할 수 있지만 이것도 절대적이지는 않아서 어떤 스레드가 먼저 진행할 지 확신할 수 없음.
 * 
 * 어떻게 하나의 자원을 두 개 이상의 스레드가 사용하고자 하는데서 InterruptedException이 발생되는 것임.
 * 자바는 먼저 스레드가 클래스를 선정하게 되면 그 클래스에 락을 걸어서 관리홤.
 * 락을 해제해주지 않는 한 접근은 불가함.
 * 이 때 대기하는 상황에 놓이게 되고 이 시간이 지연으로 이루어질 수 있음.
 * 
 * 다음 예제에서는 엄마와 아들이 한번쯤은 선정할 수 있도록 코드를 변경해 본다.
 * 
 * WaitNotifyEX.java, ATMTwo.Class
 * 
 */
//상속받고 있는 클래스가 없기 때문에 이 방법이 가능!
//class ATM extends Thread{
	private long depositMoney = 10000;
	//지연, 경합이 벌어질 때, 순서대로 처리할 때...
	public void run() {
		//두 개의 스레드가 돈을 뽑기 위해 ATM기를 공유하는 상황
		//서로 인터셉트를 하거나 당할 수 있다.
		//먼저 선정한 스레드가 사용중이면 다른 스레드는 진입해서는 안됨.
		//그런 상황을 예방할 수 있는 예약어가 동기화 코드
		synchronized(this) {
			//10번의 인출 진행
			for(int i=0; i<10; i++) {//지연처리
				try {
					Thread.sleep(1000);//지연처리
				} catch (InterruptedException e) {
					//인터셉트가 일어나면 여기...
					System.out.println("어 제 차례 아닌가요?");
					e.printStackTrace();//기억
				}
				//잔고가 부족할 때 for문 탈출
				if(getDepositMoney()<=0) {
					break;
				}
				withDraw(1000);
			}//////////////////end of for
		}//////////////////////end of synchronized
	}
	//파라미터로 인출할 금액을 받는다.
	//전체 잔고에서 그 금액만큼 차감
	//잔액을 출력
	//스레드 출력
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
	//잔고를 가져오는 메소드 선언
	public long getDepositMoney() {
		return depositMoney;
	}
}
public class synchronizedEx {

	public static void main(String[] args) {
		ATM atm = new ATM();
		
		//insert here - 엄마와 아들 스레드 추가
		Thread mother = new Thread(atm,"mother");//엄마스레드 추가
		Thread son = new Thread(atm,"son");	//아들스레드 추가
		
		mother.start();
		son.start();
	}

}
