package com.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class viewTest extends JFrame{
	
	class panelTest extends JPanel{
		Shape rr = new RoundRectangle2D.Float(110,10,70,80,10,10);
		@Override
		public void paintComponents(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponents(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setColor(Color.BLACK);
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.draw(rr);
			
		}
		
	}
	
	
	public viewTest() {
		setSize(500,500);
		setBackground(Color.WHITE);
		JPanel test = new panelTest();
		add("Center",test);
		setVisible(true);
	}


	public static void main(String[] args) {
		viewTest test = new viewTest();
	}

}
