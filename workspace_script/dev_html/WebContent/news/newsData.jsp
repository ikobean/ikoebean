<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	int x= 1;
	public String newsList(String news[]){
		StringBuilder sb = new StringBuilder();
		sb.append("<table width='500px' border='1'>");
		sb.append("<tr><td>"+news[0]+" > "+news[1]+"</td></tr>"); //news[0] =>연합뉴스 news[1]=>헤드라인 
		sb.append("</table>");
		return sb.toString();
	}
	%>  
	<%
	String news1[] = {"연합뉴스","'미니 재건축' 쉬워진다…도시재생 뉴딜사업 속도"};
	String news2[] = {"연합뉴스","15년 이상 노후차 새차로 바꾸면 개소세 70% 감면"};
	String news3[] = {"연합뉴스","'10조+α' 투자 프로젝트…화성 테마파크 내후년 착공"};
	String news4[] = {"연합뉴스","전세금 떼일 위험 없앤다…보증특례 전국 확대"};
	String news5[] = {"연합뉴스","고효율 가전 사면 구매액 10% 환급…대가족 등 335만가구"};
	
	String datas = "";
	switch(x){
	case 1:
		datas = newsList(news1);
		x++;
		break;
		
	case 2:
		datas = newsList(news2);
		x++;
		break;
		
	case 3:
		datas = newsList(news3);
		x++;
		break;
		
	case 4:
		datas = newsList(news4);
		x++;
		break;
		
	case 5:
		datas = newsList(news5); //메소드 호출시 파라미터로 뉴스 정보 넘김.
		x++;	//기사 내보낸 후 다음 기사 정보를 가져오기 위해서 1씩 증가시킴.
		break;	//case문을 탈출함. 다음 조건으로 넘어가면 안되니까
		default: //x가 6이 되면 다시 1번 기사를 내보낼 것임.
			x=1; //따라서 초기화가 필요함.
			break;
	
	}/////////////end of switch
	//이전 요청에서 가지고 있던 정보 지우기
	//아래코드를 생략하면 이전 정보를 계속 유지하므로 새로운 기사 처리 안됨.
	out.clear();
	out.print(datas);
%>                    