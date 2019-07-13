package com.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;

public class Mentor_t1 extends JPanel{
	Page_t1 		page 			= null;	//전체화면 객체주입되는 변수
	JLabel 			jlb 			= new JLabel(); //상단 제목 라벨
	Font 			myfont 			= new Font("HY견고딕",Font.PLAIN,26);
	JPanel			jp_page			= new JPanel();
	JScrollPane 	jsp_bubble		= new JScrollPane(jp_page
											,JScrollPane.VERTICAL_SCROLLBAR_NEVER
											,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel			jp_bubble		= new JPanel();
	JButton jbtn_rank = new JButton(new ImageIcon(".\\src\\images\\medal01.png"));
	JButton jbtn_list = new JButton(new ImageIcon(".\\src\\images\\list01.png"));
	JButton jbtn_search = new JButton(new ImageIcon(".\\src\\images\\search01.png"));
	public Mentor_t1(Page_t1 page,String name) {
		this.page = page;
		setLayout(null);
		jlb.setIcon(new ImageIcon(".\\src\\images\\people01.png"));
		jlb.setBounds(15, 15, 200, 50);
		jlb.setText(name);
		jlb.setFont(myfont);
		initGroup();
		initButton();
		initMouseDrag();
		setBackground(new Color(255,224,200));
		add(jlb);
		add(jbtn_rank);
		add(jbtn_list);
		add(jbtn_search);
	}
	public void initGroup() {
		jp_page = (JPanel)page.jp_rank;
		jp_bubble.setLayout(null);
		GroupLayout layout = new GroupLayout(jp_bubble);
		jp_bubble.setLayout(layout);
		layout.setHorizontalGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(this)
				.addComponent(jp_page)
			)
		);
		layout.setVerticalGroup(layout.createSequentialGroup()
			.addComponent(this,75,75,75)
			.addComponent(jp_page)
		);
	}
	public void initMouseDrag() {
		MouseAdapter ma = new MouseAdapter() {
            Point origin;
            @Override
            public void mousePressed(MouseEvent e) {
                origin = new Point(e.getPoint());
            }
            @Override
            public void mouseDragged(MouseEvent e) {
                if (origin != null) {
                    JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, jp_page);
                    if (viewPort != null) {
                        int deltaY = origin.y - e.getY();

                        Rectangle view = viewPort.getViewRect();
                        view.y += deltaY;
                        jp_page.scrollRectToVisible(view);
                    }
                }
            }
        };
        jp_page.addMouseListener(ma);
        jp_page.addMouseMotionListener(ma);
	}
	public void initButton() {
		jbtn_rank.setBounds(230, 20, 50, 40);
		jbtn_rank.setBackground(new Color(255,224,200));
		jbtn_rank.setRolloverEnabled(false);
		jbtn_rank.setBorder(null);
		jbtn_list.setBounds(280, 20, 50, 40);
		jbtn_list.setBackground(new Color(255,224,200));
		jbtn_list.setRolloverEnabled(false);
		jbtn_list.setBorder(null);
		jbtn_search.setBounds(330, 20, 50, 40);
		jbtn_search.setBackground(new Color(255,224,200));
		jbtn_search.setRolloverEnabled(false);
		jbtn_search.setBorder(null);
		jbtn_rank.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				page.remove(page.jp_page);
				initGroup();
				page.jp_page = jp_bubble;
				page.add(page.jp_page);
				page.revalidate();
				page.repaint();
			}
		});
		jbtn_list.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				page.remove(page.jp_page);
				initGroup();
				page.jp_page = jp_bubble;
				page.add(page.jp_page);
				page.revalidate();
				page.repaint();
			}
		});
		jbtn_search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				page.remove(page.jp_page);
				initGroup();
				page.jp_page = jp_bubble;
				page.add(page.jp_page);
				page.revalidate();
				page.repaint();
			}
		});
	}
}
