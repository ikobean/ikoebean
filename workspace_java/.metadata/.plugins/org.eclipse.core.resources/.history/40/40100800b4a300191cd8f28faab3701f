package com.test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.util.DBConnectionMgr;

public class RecieveMsg extends JFrame {
	
	String nick = "스티브 잡";
	
	String cols[] = {"보낸사람","제목","내용"};
	String data[][] = new String[0][];
	
	DefaultTableModel dtm_msg = new DefaultTableModel(data,cols);
	JTable jt_msg = new JTable(dtm_msg);
	JTableHeader jth_msg = jt_msg.getTableHeader();
	JScrollPane jsp_msg = new JScrollPane(jt_msg
						,JScrollPane.VERTICAL_SCROLLBAR_NEVER
						,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	JButton jbtn_clear = new JButton("새로고침");
	
	
	public void initDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		jsp_msg.setBounds(10, 10, 360, 600);
		jth_msg.setBackground(Color.GRAY);
		jth_msg.setForeground(Color.WHITE);
		jth_msg.setReorderingAllowed(false);
		jth_msg.setResizingAllowed(false);
		jt_msg.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jt_msg.getColumnModel().getColumn(0).setPreferredWidth(80);
		jt_msg.getColumnModel().getColumn(1).setPreferredWidth(80);
		jt_msg.getColumnModel().getColumn(2).setPreferredWidth(200);
		jt_msg.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()==2){
					openMsg();
				}
			}
		});
		jbtn_clear.setBounds(150, 610, 100, 30);
		jbtn_clear.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshMsg();
			}
		});
		add(jsp_msg);
		add(jbtn_clear);
		refreshMsg();
		setSize(400,700);
		setVisible(true);
	}
	
	public void openMsg() {
		
	}
	
	public void refreshMsg() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnectionMgr.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select reg_nick,msg_title,msg_cont from t_msg	");
			sql.append("where rec_nick=?								");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, nick);
			rs = pstmt.executeQuery();
			dtm_msg.setRowCount(0);
			while(rs.next()) {
				Vector<String> msg = new Vector<>();
				msg.add(rs.getString("reg_nick"));
				msg.add(rs.getString("msg_title"));
				msg.add(rs.getString("msg_cont").substring(0, 15)+"...");
				dtm_msg.addRow(msg);
			}
			revalidate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		RecieveMsg rm = new RecieveMsg();
		rm.initDisplay();
	}

}
