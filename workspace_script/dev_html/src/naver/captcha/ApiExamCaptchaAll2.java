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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ApiExamCaptchaAll2 extends JFrame{
	JDialog jdl = new JDialog();
	JTextField jtf = new JTextField();
	JButton jbtn = new JButton("새로고침");
	String nKey = null;
	
	
	//키발급
   	 String clientId = "JGAjK7E5iTq5emPmn6y0";//애플리케이션 클라이언트 아이디값";
     String clientSecret = "VGsXvOSynA";//애플리케이션 클라이언트 시크릿값";
     
     
     public void key() {
     
     try {
         String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
         String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
         URL url = new URL(apiURL);
         HttpURLConnection con = (HttpURLConnection)url.openConnection();
         con.setRequestMethod("GET");
         con.setRequestProperty("X-Naver-Client-Id", clientId);
         con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
         int responseCode = con.getResponseCode();
         BufferedReader br;
         if(responseCode==200) { // 정상 호출
             br = new BufferedReader(new InputStreamReader(con.getInputStream()));
         } else {  // 에러 발생
             br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
         }
         String inputLine;
         StringBuffer response = new StringBuffer();
         while ((inputLine = br.readLine()) != null) {
             response.append(inputLine);
         }
         br.close();
        // System.out.println(response.toString());
         nKey = response.toString(); 
         nKey=nKey.substring(8, 24); 
         //System.out.println(nKey);
         
     } catch (Exception e) {
         System.out.println(e);
     }
     img(nKey);
     }
	//발급된 키로 캡차이미지 생성하기
	public void img(String nKey) {
		System.out.println(nKey);
		try {
            String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + nKey;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                InputStream is = con.getInputStream();
                int read = 0;
                byte[] bytes = new byte[1024];
                // 랜덤한 이름으로 파일 생성
                String tempname = Long.valueOf(new Date().getTime()).toString();
                String captchaName = tempname+".jpg";
                File f = new File(captchaName);
                f.createNewFile();
                OutputStream outputStream = new FileOutputStream(f);
                while ((read =is.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                is.close();
                String imgPath="d:\\workspace_script\\dev_html\\"; 
                jdl.setTitle("캡처이미지");
                JLabel jlb_captcha = new JLabel (new ImageIcon(imgPath + captchaName));
                jdl.add("Center", jlb_captcha);
                jdl.setSize(500,500);
                jdl.add("South",jtf);
                jdl.setVisible(true);
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
                System.out.println(response.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
	}
	//값을 비교해서 처리 결과를 받아오기
	public void result(String user_input) {
		   try {
	            String code = "1"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
	            String key = nKey; // 캡차 키 발급시 받은 키값
	            String value = user_input; // 사용자가 입력한 캡차 이미지 글자값
	            String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code +"&key="+ key + "&value="+ value;

	            URL url = new URL(apiURL);
	            //네이버 웹서버와 통신하기 위한 클래스 생성 및 연결요청	
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.setRequestProperty("X-Naver-Client-Id", clientId);
	            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
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
	//initDisplay
	public void initDisplay() {
		jdl.add("East",jbtn);
		jbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jlb_captcha
			}
		});
		
		jtf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String user_input = jtf.getText();
				result(user_input);
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApiExamCaptchaAll2 apiCaptcha = new ApiExamCaptchaAll2();
		 apiCaptcha.key();
	}

}
