package com.ch4;

import javax.sound.midi.SysexMessage;

public class switchTest {

	public static void main(String[] args) {
		int i = 1;
		switch(i) {
		case 1:System.out.println(i);
		break;
		case 2:System.out.println(i);
		break;
		case 3:System.out.println(i);
		break;
		default :System.out.println(i);
		break;
		}////////end of switch
		System.out.println("여기");
		int j = ++i;
		System.out.println("j는"+j);
	}/////////end of main
}/////////////end of SwitchTest


