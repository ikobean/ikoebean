package com.network2;

import java.util.List;
import java.util.Vector;

public class Room {
	List<TalkServerThread> userList = new Vector<>(); //전체 다 (global)
	List<String>		   nameList = new Vector<>(); //방에 있는 애들만
	String title	=null; //단톡방 이름
	String state	=null; //대기상태, 참여중...
	int	   max		=0;
	int	   current	=0;	   //현재원
	
	public Room() {
		
	}
	public Room(String title, String state, int current) {
		this.title		= title;
		this.state		= state;
		this.current	= current;
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
}
