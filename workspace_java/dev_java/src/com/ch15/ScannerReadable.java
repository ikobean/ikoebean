package com.ch15;

import java.io.FileReader;
import java.util.Scanner;

public class ScannerReadable {

	public static void main(String[] args) {
		Scanner scan = null;
		FileReader fr = null;
		try {
			fr=new FileReader(".\\src\\com\\ch15\\scan.txt");
			scan = new Scanner(fr);
			//더블타입만 찾음
			while(scan.hasNextDouble()) {
				System.out.println("double:"+scan.nextDouble());
			}
			//다찾음
			while(scan.hasNext()) {
				System.out.println("다:"+scan.next());
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(fr!=null) fr.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}