package alone;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Subject extends JFrame {
	
	public Subject() {
		
	}
		
		@Override
		public void setDefaultCloseOperation(int operation) {
			// TODO Auto-generated method stub
			super.setDefaultCloseOperation(operation);
		}
	public static void initdisplay() {
		
		JFrame jf = new JFrame();
		String cols[]= {"이름","자바점수","오라클점수","html점수"};
		String content[][] 
				= {
				  {"황현영","100","100","100"}
				 ,{"내복쓰","999","990","9990"}
				 ,{"박병태","0","10","70"}
				 ,{"이경애","100","100","100"}};
		DefaultTableModel dtm = new DefaultTableModel(content, cols);
		JPanel jp_center = new JPanel();
		jp_center.setLayout(new BoxLayout(jp_center, BoxLayout.X_AXIS));
		
		JPanel jp_SOUTH = new JPanel();
		JTable jt = new JTable(dtm);
		
	    	
	    JTextField name = new JTextField(5);
	    JTextField sb1 = new JTextField(3);
	    JTextField sb2 = new JTextField(3);
	    JTextField sb3 = new JTextField(3);
	    
	    	
	    	
		JButton ins = new JButton("입력");
		JButton del = new JButton("삭제");
		
		JScrollPane jsp = new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
											,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jp_center.setBackground(new Color(100,30,70));
		ins.setBackground(new Color (200,3,200));
		del.setBackground(new Color (100,100,100));

		
		ins.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String inputStr[] = new String[4];
			inputStr[0] = name.getText();
			inputStr[1] = sb1.getText();
			inputStr[2] = sb2.getText();
			inputStr[3] = sb3.getText();
			dtm.addRow(inputStr);
			
			name.setText("");
			sb1.setText("");
			sb2.setText("");
			sb3.setText("");
			
		}
		});
		del.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(jt.getSelectedRow() == -1) {
					return;
				}
				else {
					dtm.removeRow(jt.getSelectedRow());
				}
				
			}
			
			
			
			
		});
		
		//붙이는 순서==쓰는 순서 바부~~
		jp_center.add(jt);
		jp_SOUTH.add(name);
		jp_SOUTH.add(sb1);
		jp_SOUTH.add(sb2);
		jp_SOUTH.add(sb3);		
		jp_SOUTH.add(ins);
		jp_SOUTH.add(del);
		
		
		
	
		jp_center.add(jsp);
		jf.add(jp_SOUTH, BorderLayout.SOUTH);
		jf.add(jp_center, BorderLayout.CENTER);
		jf.setSize(500, 200);
		jf.setVisible(true);
		jf.setTitle("우리반 똘똘이들");
		//jf.pack();
		
		
		
	}
		
		
	public static void main(String[] args) {
		
		initdisplay();
		
		
		

	}
	

}
