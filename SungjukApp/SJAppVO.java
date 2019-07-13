package SungjukApp;

public class SJAppVO {
	//"이름","JAVA","Oracle","JSP","총점","평균","석차"
	private String name = null;
	private String java = null;
	private String oracle = null;
	private String jsp = null;
	private String total = null;
	private String avg = null;
	private String rank = null;
	
	private String command = null;//select, detail, insert, update, delete
	//오라클서버에서 반환되는 값을 담을 변수 - 1:성공(입력,수정,삭제), 0:실패
	private int status = -1;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJava() {
		return java;
	}
	public void setJava(String java) {
		this.java = java;
	}
	public String getOracle() {
		return oracle;
	}
	public void setOracle(String oracle) {
		this.oracle = oracle;
	}
	public String getJsp() {
		return jsp;
	}
	public void setJsp(String jsp) {
		this.jsp = jsp;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getAvg() {
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
