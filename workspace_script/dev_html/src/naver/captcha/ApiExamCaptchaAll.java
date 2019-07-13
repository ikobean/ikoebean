package naver.captcha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ApiExamCaptchaAll extends JFrame {
	JDialog jdl = new JDialog();
	JTextField jtf = new JTextField();
	String nKey = null;
	
	 String id="JGAjK7E5iTq5emPmn6y0";
	 String pw="VGsXvOSynA";
	
	/*
	 * JGAjK7E5iTq5emPmn6y0 VGsXvOSynA
	 */
	 //키발급 메소드
	 public void getKey() {
		  try {
		         String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
		         String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
		         //네이버 웹서버에서 제공하는 캡챠서비스를 이용하기 위해 키발급 URL을 선언하였다
		         //자바코드에서 웹서버에 페이지를 요청해야 하므로 URL객체를 생성함.
		         URL url = new URL(apiURL);
		         //요청객체를 활용하여 HTTP 통신 프로토콜 커넥션을 연결함
		         HttpURLConnection con = (HttpURLConnection)url.openConnection();
		         //전송 방식을 정함
		         con.setRequestMethod("GET");
		         //요청 속성에 아이디와 비밀번호 같이 넘김
		         con.setRequestProperty("X-Naver-Client-Id", id);
		         con.setRequestProperty("X-Naver-Client-Secret", pw);
		         //네이버 웹서버에서 요청을 받아서 처리하고 그 결과를 HTTP상태코드값 (200,400,500) 
		         int responseCode = con.getResponseCode();
		         BufferedReader br;
		         if(responseCode==200) { // 정상 호출
		        	 //네이버 서버에서 생성한 응답 메세지를 읽기 위해서  InputStreamReader생성
		             br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		         } else {  // 에러 발생
		             br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		         }
		         String inputLine; //읽어들인 한 줄을 담을 변수 선언
		         //String은 원본이 변하지 않아서 StringBuffer 생성
		         StringBuffer response = new StringBuffer();
		         //반복문에서 null이 아닐 때 까지 읽어서 저장
		         while ((inputLine = br.readLine()) != null) {
		        	 //StringBuffer에 담긴 문자열을 붙인다.
		             response.append(inputLine);
		         }
		         br.close();
		         //System.out.println(response.toString());
		         //우리가 필요한 값은 key뿐이니까 필요한 값만 썰어서 저장
		         nKey = response.toString(); 
		         nKey = nKey.substring(8, 24); 
		     } catch (Exception e) {
		         System.out.println(e);
		     } 
		  makeimg(nKey);
		 
	 }
	 //발급된 키로 캡차이미지 생성하기
	 public void makeimg(String nKey) {
		 System.out.println(nKey);
		 try {
	            String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + nKey;
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.setRequestProperty("X-Naver-Client-Id", id);
	            con.setRequestProperty("X-Naver-Client-Secret", pw);
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                InputStream is = con.getInputStream();
	                int read = 0;
	                //네이버 서버에서 생성한 이미지 정보를 받아옴
	                //저장할 공간 생성
	                byte[] bytes = new byte[1024];
	                // 랜덤한 이름으로 파일 생성
	                String tempname = Long.valueOf(new Date().getTime()).toString();
	                //File은 파일명을 클래스로 만들어주는 객체
	                //그래서 인스턴스를 해야함.
	                //그러나 파일만 생성되는 것이지 내용까지 담기는 것은 아님.
	                String captchaName = tempname+".jpg";
	                File f = new File(captchaName);
	                //파라미터로 받은 이름으로 파일 생성
	                f.createNewFile();
	                OutputStream outputStream = new FileOutputStream(f);
	                while ((read =is.read(bytes)) != -1) {
	                	//1번 파라미터: 읽어들인 내용을 담을 저장소 주소번지
	                	//2번 파라미터(0)
	                	//3번 파라미터 무엇을 담을거니?
	                    outputStream.write(bytes, 0, read);
	                }
	                is.close();
	                String imgPath="d:\\workspace_script\\dev_html\\";
	                jdl.setTitle("캡처이미지");
	                JLabel jlb_captcha = new JLabel(new ImageIcon(imgPath+captchaName));
	                jdl.add("Center", jlb_captcha);
	                jdl.pack();
	                jdl.add("South",jtf);
	                //jtf.setVisible(true);
	                jdl.setVisible(true);
	                //re = (String)JOptionPane.showInputDialog(this,"ㅇㅅㅇ");
	                //jdl.setVisible(false);
	                initDisplay();
	            } else {  // 에러 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	                String inputLine;
	                StringBuffer response = new StringBuffer();
	                while ((inputLine = br.readLine()) != null) {
	                    response.append(inputLine);
	                }
	                //정상(캡차이미지에 적힌 문자열과 사용자가 입력한 문자열이 같으면)적으로 처리가 되면
	                br.close();
	               
	                //만일 이미지 생성 실패하면 에러메세지가 출력
	                System.out.println(response.toString());
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
		 	
	 }
	 
	
	 //값을 비교해서 처리 결과를 받아오기
	 public void captchaAccount(String user_insert) {
		    
		 	
	        try {
	            String code = "1"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
	            String key = nKey; // 캡차 키 발급시 받은 키값
	            String value = user_insert; // 사용자가 입력한 캡차 이미지 글자값
	            String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code +"&key="+ key + "&value="+ value;

	            URL url = new URL(apiURL);
	            //네이버 웹서버와 통신하기 위한 클래스 생성 및 연결요청	
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.setRequestProperty("X-Naver-Client-Id", id);
	            con.setRequestProperty("X-Naver-Client-Secret", pw);
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            //서버에 요청한 결과가 정상적으로 처리되면 200번 반환 - HTTP상태
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  // 에러 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            //읽어들인 값이 NULL이 아닐때까지 반복
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	            }
	            br.close();
	            System.out.println(response.toString());
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        
	      
		 
	
	 }
	  public void initDisplay() {
      	jtf.addActionListener(new  ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String user_insert = jtf.getText();
				captchaAccount(user_insert);
			}
		});
      }
	 public static void main(String[] args) {
		 ApiExamCaptchaAll apiCaptcha = new ApiExamCaptchaAll();
		 apiCaptcha.getKey();
	
		 
	 }
	
}
