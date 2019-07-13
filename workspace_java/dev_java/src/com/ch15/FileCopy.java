package com.ch15;

import java.io.FileReader;
import java.io.FileWriter;

public class FileCopy {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(".\\src\\com\\ch15\\scan.txt");
			fw = new FileWriter(".\\src\\com\\ch15\\scan_copy.txt");
			int data = 0;
			while((data=fr.read())!=-1) {//-1 ==end of file
				fw.write(data);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(fw!=null) fw.close();
				if(fr!=null) fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
