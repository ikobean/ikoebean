package com.network2;

public class Protocol {
	public static final int WAIT			 = 100;	//대기 상태
	public static final int ROOM_CREATE		 = 110; //톡방 개설
	public static final int ROOM_LIST		 = 120; //톡방 이름 목록
	public static final int ROOM_IN 		 = 130; //톡방 입장
	public static final int ROOM_INLIST 	 = 140; //톡방에 있는 사람 목록
	public static final int ROOM_OUT 		 = 190; //톡방 나가기
	public static final int MESSAGE 		 = 200; //일반대화
	public static final int WHISPER		     = 210; //1:1
	public static final int CHANGE 			 = 300; //대화명 변경
	public static final int EXIT 			 = 500; //종료
	//메시지 열에서 값에 대한 구분자를 선언
	public static String seperator = "|";
}

