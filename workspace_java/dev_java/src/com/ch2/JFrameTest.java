package com.ch2;

import javax.swing.JFrame;

public class JFrameTest {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		int width = 500;
		int height = 400;
		jf.setSize(width, height); //열리는 창의 사이즈
        boolean isView = false;
        isView = true;
        jf.setVisible(isView);
	}

}

