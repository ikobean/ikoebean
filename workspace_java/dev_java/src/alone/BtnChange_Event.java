package alone;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnChange_Event implements ActionListener {
    BtnChange btbt = null;
    
	public BtnChange_Event () {
		
	}
	
	public BtnChange_Event (BtnChange i){
		this.btbt = i ; //i값을 btbt에 담아줘! i가 뭔데? BtnChange의 디폴트 생성자를 인스턴스화 헀어!
		                //결과적으로 i = BtnChange 의 디폴트 생성자 주소고 btbt에 담은거야!
		 				//왜냐하면 i로 그냥 두면 액션 퍼폼 메소드에서 못쓰니까. 우리는 BtnChange 에 가서 버튼을 불러올거야!
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		if("내복이".equals(label)){
			System.out.println("예뻐죽겠어");
			btbt.jbtn.setBackground(new Color(100,200,200));
			btbt.jbtn.setText("사랑해");
			
			
		}
		
	}
	
	
	
	
}
