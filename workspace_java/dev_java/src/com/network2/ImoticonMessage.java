package com.network2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class ImoticonMessage extends JDialog implements ActionListener{
	MessageRoom mr = null;
	JPanel jp_imo = new JPanel();
	JButton jbtn_imo0 = new JButton();
	JButton jbtn_imo1 = new JButton();
	JButton jbtn_imo2 = new JButton();
	JButton jbtn_imo3 = new JButton();
	JButton jbtn_imo4 = new JButton();
	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
	
	ImageIcon img[] = new ImageIcon[5];
	String imgFiles[] = {
							"hi.png","good.png","letsgo.png","question.png","shit.png"
						};
	JButton imgButton[] = {
							jbtn_imo0, jbtn_imo1,jbtn_imo2,jbtn_imo3,jbtn_imo4
						  };
	
	//이미지 정보 담을 변수
	String imgChoice = "default";
	public ImoticonMessage(MessageRoom mr) {
		this.mr = mr;
		initDisplay();
		
	}
	public void initDisplay() {
		jbtn_imo0.addActionListener(this);
		jbtn_imo1.addActionListener(this);
		jbtn_imo2.addActionListener(this);
		jbtn_imo3.addActionListener(this);
		jbtn_imo4.addActionListener(this);
		
		this.setLayout(null);
		this.setBounds(new Rectangle(3,3,486,146));
		jp_imo.setBackground(Color.white);
		jp_imo.setBorder(BorderFactory.createEtchedBorder());
		jp_imo.setBounds(new Rectangle(6,6,480,150));
		jp_imo.setLayout(new GridLayout(1,5));
		for(int i=0; i<img.length;i++) {
			img[i] = new ImageIcon(imgPath+imgFiles[i]);
			imgButton[i].setIcon(img[i]);
			//imgButton[i].setBorderPainted(false);
			imgButton[i].setFocusPainted(false);
			imgButton[i].setContentAreaFilled(false);
			
		}
		
		jp_imo.add(jbtn_imo0);
		jp_imo.add(jbtn_imo1);
		jp_imo.add(jbtn_imo2);
		jp_imo.add(jbtn_imo3);
		jp_imo.add(jbtn_imo4);
		
		this.getContentPane().setBackground(new Color(125,144,177));
		this.getContentPane().add(jp_imo);
		
		this.add(jp_imo);
		this.setLocation(50,50);
		this.setResizable(false);
		this.setSize(510,205);
		this.setVisible(false);
	}
	public static void main(String[] args) {
		ImoticonMessage im =  new ImoticonMessage();

	}
	public ImoticonMessage() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jbtn_imo0) {
			imgChoice = "hi.png";
			mr.message_process(null,imgChoice);
			this.setVisible(false);
		}
		if(obj==jbtn_imo1) {
			imgChoice = "good.png";
			mr.message_process(null,imgChoice);
			this.setVisible(false);
		}
		if(obj==jbtn_imo2) {
			imgChoice = "letsgo.png";
			mr.message_process(null,imgChoice);
			this.setVisible(false);
		}
		if(obj==jbtn_imo3) {
			imgChoice = "question.png";
			mr.message_process(null,imgChoice);
			this.setVisible(false);
		}
		if(obj==jbtn_imo4) {
			imgChoice = "shit.png";
			mr.message_process(null,imgChoice);
			this.setVisible(false);
		}
	}
}
