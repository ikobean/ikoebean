package com.ch12;

import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class ChatVO{
	
	private String nickName= null;
	private int age =0;
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
public class VectorTest extends JFrame {
	String cols[] = {"닉네임","나이"};
	String data[][] = new String[0][2];
	DefaultTableModel dtm = new DefaultTableModel(data, cols);	
	JTable jt = new JTable(dtm);
	JScrollPane jsp= new JScrollPane(jt);
	
	public VectorTest() {
		List<ChatVO> list = new Vector();
		ChatVO cVO = new ChatVO();
		
		cVO.setNickName("바나나");
		cVO.setAge(25);
		list.add(cVO);
		
		cVO = new ChatVO();
		cVO.setNickName("나초");
		cVO.setAge(20);
		list.add(cVO);
		
		cVO = new ChatVO();
		cVO.setNickName("치즈");
		cVO.setAge(30);
		list.add(cVO);
	
		Vector<ChatVO> vec = new Vector();
		ChatVO cVO1 = new ChatVO();
		
		cVO1.setNickName("딸기");
		cVO1.setAge(37);
		vec.add(cVO1);
		cVO1 = new ChatVO();
		cVO1.setNickName("베리");
		cVO1.setAge(35);
		vec.add(cVO1);
		cVO1 = new ChatVO();
		cVO1.setNickName("스윗");
		cVO1.setAge(32);
		vec.add(cVO1);
		
		//Vector안에 제네릭 타입 ChatVO를 세 건을 넣었기 때문에 반복문으로 하나씩 꺼낸다.
		for(int i=0; i<vec.size();i++) {
			//제네릭 타입 안에 들은 정보를 가진 주소번지를 대입
			ChatVO rcVO = vec.get(i);
			//실제 데이터를 갖는 DefaultTableModel 객체 로우값들을 하나씩 담기 위해서
			//벡터를 추가로 인스턴스화 했음
			//반복문이 돌 때 마다 새로 값을 초기화 해야하므로 반복문 안에서 인스턴스화를 함
			Vector<String> rowData = new Vector<>();
			//실제 데이터를 가진 건 제네릭 타입인 ChatVO 이므로 멤버변수에 담긴 값을 하나씩 저장
			rowData.add(rcVO.getNickName());
			//나이를 담음 - 컬렉션은 모두 객체타입만 담을 수 있으므로 String 타입으로 변경
			rowData.add(String.valueOf(rcVO.getAge()));
			dtm.addRow(rowData);
			
		}
			for(int j=0; j<list.size();j++) {
				ChatVO rcVO0 = list.get(j);
				List<String> rowData1 = new Vector();
				rowData1.add(rcVO0.getNickName());
				rowData1.add(String.valueOf(rcVO0.getAge()));
				dtm.addRow((Vector)rowData1);
			}
		
		//vec.copyInto(anArray);
		//list.copyInto(); 불가. 자식한테만 있는 건 못갖다 씁니다!
		
		
		this.add("Center", jsp);
		this.setSize(500,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new VectorTest();
	}

	}
