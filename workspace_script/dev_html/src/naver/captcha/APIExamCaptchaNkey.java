package naver.captcha;

//네이버 캡차 API 예제 - 키발급
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
/*
JGAjK7E5iTq5emPmn6y0
VGsXvOSynA
 */

public class APIExamCaptchaNkey {

 public static void main(String[] args) {
     String clientId = "JGAjK7E5iTq5emPmn6y0";//애플리케이션 클라이언트 아이디값";
     String clientSecret = "VGsXvOSynA";//애플리케이션 클라이언트 시크릿값";
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
         String nKey = response.toString(); 
         //String result = nKey.substring(nKey.lastIndexOf("")+1);
         nKey.substring(8, 23); 
         System.out.println(nKey);
         
     } catch (Exception e) {
         System.out.println(e);
     }
 }
}
