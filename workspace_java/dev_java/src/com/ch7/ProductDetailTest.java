package com.ch7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import oracle.net.aso.e;

public class ProductDetailTest {

	public static void main(String[] args) {
		Product_detail pro = new Product_detail();    //인스턴스화
		Product_detail abc[] = new Product_detail[9]; //객체 배열을 인스턴스화 한 것.
		abc[0] = pro;	//두 번 접근
		pro.setColor("white");
		pro.getColor();
		System.out.println(pro.getColor());
		
		pro.setNation("Vietnam");
		pro.getNation();
		System.out.println(pro.getNation());
		
		
		
		
   for (Product_detail ppp : abc) {
	   System.out.println(ppp);
   }
	
		}
		
		
	
		}

	

