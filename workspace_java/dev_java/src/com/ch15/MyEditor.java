package com.ch15;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class MyEditor extends JFrame {
	//선언부
	URL imgURL = getClass().getResource("memo.png");
	ImageIcon appIcon = new ImageIcon(imgURL);
	//컨테이너 객체 변수를 선언
	Container myCon = null;
	//메뉴바 추가하기
	//메뉴 아이템을 메뉴에 추가하고 메뉴를 메뉴바에 추가함.
	JMenuBar jmb = new JMenuBar();
	JMenu jm_file = new JMenu("File"); //new, open, save, exit
	JMenu jm_edit = new JMenu("Edit");//copy,paste, cut
	
	JMenuItem jmi_new = new JMenuItem("New");
	JMenuItem jmi_open = new JMenuItem("Open");
	JMenuItem jmi_save = new JMenuItem("Save");
	JMenuItem jmi_exit = new JMenuItem("Exit");
	
	JMenuItem jmi_copy = new JMenuItem("Copy");
	JMenuItem jmi_paste = new JMenuItem("Paste");
	JMenuItem jmi_cut = new JMenuItem("Cut");
	
	
	//입력용 텍스트 영역 작성하기
	JTextArea jta_text = new JTextArea();
	JScrollPane jsp_text = new JScrollPane(jta_text
										  ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
										  ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	JFileChooser jfc = new JFileChooser();
	String imgPath = ".//src//images//";
	//툴바 추가하기 - 북쪽에 배치함.
	JToolBar jtb = new JToolBar();
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_sel = new JButton("조회");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	//생성자
	public MyEditor() {
		
	}
	//화면처리부
	public void initDisplay() {
		jmi_cut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jta_text.cut();
			}
		});
		jmi_copy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jta_text.copy();
			}
		});
		jmi_paste.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jta_text.paste();
			}
		});
		
		jbtn_ins.setIcon(new ImageIcon(imgPath+"new.gif"));
		jbtn_sel.setIcon(new ImageIcon(imgPath+"detail.gif"));
		jbtn_upd.setIcon(new ImageIcon(imgPath+"update.gif"));
		jbtn_del.setIcon(new ImageIcon(imgPath+"delete.gif"));
		
		jtb.add(jbtn_ins);
		jtb.add(jbtn_sel);
		jtb.add(jbtn_upd);
		jtb.add(jbtn_del);
		
		jmi_save.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//저장 대화상자 오픈
					int ret = jfc.showSaveDialog(MyEditor.this); //내부클래스라서 this 안됨.
					if(ret==JFileChooser.APPROVE_OPTION) {
						//파일 저장 처리 - OutputStream
						try {
							File myFile = jfc.getSelectedFile();//파일객체 생성
							PrintWriter pwriter = new PrintWriter(
													new BufferedWriter(
															new FileWriter(
																	myFile.getAbsolutePath())));
							pwriter.write(jta_text.getText());
							pwriter.close();
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
					
				}
			});
		//익명클래스(내부 클래스의 일종) xxx.java xxx.class, xxx$1.class....
		//자바스크립트-내부에 메소드나 변수선언 처리
		//$("#dg").datagrid({프로그램 코딩부});
		//ActionListener 는 인터페이스이다. - 자신만으로 인스턴스화 불가, 구현체클래스 있어야 함.
		//캡차, 네아로, 카카오, UI, Spring Boot
		jmi_open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//열기 대화상자를 오픈
				int ret = jfc.showOpenDialog(MyEditor.this);
				//yes 나 혹은 ok 버튼을 클릭했을 때
				if(ret == JFileChooser.APPROVE_OPTION) {
					//파일을 여는 처리
					try {
						//읽어들이기용 String Gson, jsonObject, JsonArray
						String strLine;
						//파일명에 대한 객체생성만 됨. 내용은 담을 수 없다.
						File myFile = jfc.getSelectedFile();
						//선택한 파일에 절대경로를 지정해서 BufferedReader생성함.
						BufferedReader br = new BufferedReader(new FileReader(myFile.getAbsolutePath())); //절대경로를 가져와서 파일을 읽어들일 수 있게 됨.
						jta_text.setText(br.readLine());
						//2행부터는 행바꾸기 코드를 넣어줌.
						
						while((strLine=br.readLine())!=null) {
							jta_text.append("\n"+strLine);
						}
						br.close();
					} catch (IOException ie) {
						System.out.println(ie.toString());
					}
				}
				
			}/////////////end of actionPerformed
		});///////////////end of jmi_open
		
	
		//파일메뉴
		jm_file.add(jmi_new);
		jm_file.add(jmi_open);
		jm_file.add(jmi_save);
		jm_file.add(jmi_exit);
		
		jmb.add(jm_file);
		
		//에딧메뉴
		jm_edit.add(jmi_copy);
		jm_edit.add(jmi_paste);
		jm_edit.add(jmi_cut);
		
		jmb.add(jm_edit);
		
		
		jm_file.setMnemonic('F');
		jm_edit.setMnemonic('E');
		
		myCon = this.getContentPane();
		myCon.setLayout(new BorderLayout());
		myCon.add("Center",jsp_text);
		myCon.add("North",jtb);

		jmb.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		this.setJMenuBar(jmb);
		
		//Look & Feel 설정
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.setIconImage(appIcon.getImage());
		this.setTitle("메모장");
		this.setSize(500,300);
		this.setVisible(true);
	}
	
	//메인메소드
	public static void main(String[] args) {
		MyEditor myeditor = new MyEditor();
		myeditor.initDisplay();
		//System.out.println(myeditor.imgURL);
	}

}
