package com.util;

import java.io.File;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/*
 * 사용자가 입력한 값을 읽을 때마다 반복되는 request.getParameter()를 대신해서
 * 사용할 수 있는 bind 메소드 추가하기
 * 리턴 타입은 void로 하지만 파라미터를 Map 타입으로 하여 
 */
public class HashMapBinder {
	Logger logger = Logger.getLogger(HashMapBinder.class);
	HttpServletRequest req = null;
	//첨부 파일 추가
	MultipartRequest multi = null;
	String realFolder = "";
	//첨부파일의 한글처리
	String encType = "utf-8";
	//첨부파일의 크기
	int maxSize = 5*1024*1024;
	//req 객체를 서블릿에서 받아와야 하니까.
	public HashMapBinder(HttpServletRequest req) {
		//??
		this.req = req;
		realFolder = "D:\\workspace_jsp\\dev_jsp\\WebContent\\pds";
	}
	//첨부파일 처리시 사용할 메소드
	public void multiBind(Map<String,Object> pMap) {
		pMap.clear();
		try {
			multi = new MultipartRequest(req,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
		} catch (Exception e) {
			
		}
		Enumeration<String> en = multi.getParameterNames();
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			pMap.put(key, multi.getParameter(key));
			logger.info("MpaBinder - 값 :"+pMap.get(key)+"키 이름 :"+key);
		}
		logger.info("pMap.size==>"+pMap.size());
		//첨부파일에 대한 정보를 받아오기
		Enumeration<String> files = multi.getFileNames();
		if(files!=null) {
			//읽어온 파일 이름을 객체로 만듦 - 파일크기를 계산할 때 메소드를 지원
			File file = null;
			while(files.hasMoreElements()) {
				String fname = files.nextElement();
				logger.info("fname 이거머야? :"+fname); //bs_file
				String filename = multi.getFilesystemName(fname);
				pMap.put("bs_file", filename);
				logger.info("여기서 조지는거같아 :"+pMap.get("bs_file"));
				if(filename!=null && filename.length()>1) {
					file = new File(realFolder+"\\"+filename);
				}
			}
			//첨부파일 크기 계산. 여러개 할 거면 while문 안에서 돌리기
			double size = 0;
			if(file !=null) {
				size = file.length(); //파일의 크기 계산
				//size = size/(1024.0);
				pMap.put("bs_size", size);
			
			}
		}
	}
	//get방식 요청시 사용할 것
	/*********************************************************
	 * @param target Map<String,Object> 객체생성해서 넘길 것.
	 *	주의 : NullPointerException 맞기 싫으면...
	 *********************************************************/
	public void bind(Map<String,Object> target) {
		//p77의 11-15행 대신 쓰려는 것
		//파라미터로 넘어온 target 안에 다른 정보가 담겨있다면 제거
		target.clear();
		Enumeration er = req.getParameterNames(); //name,address,pet
		while(er.hasMoreElements()) {
			String name = (String)er.nextElement(); //name,address,pet
			if("pet".equals(name)) {
				String values[] = req.getParameterValues(name); //선택한 dog/cat/pig
				String myPet="";
				if(values!=null) {
					for(int i=0;i<values.length;i++) {
						myPet+=values[i]+" ";
					}
					target.put("pet", myPet);
				}
			}
			//key에는  name,address,pet이 와야 함
			//value에는 각 key가 가리키는 값이 오면 됨.
			else {
				target.put(name,req.getParameter(name)); //address,주소 . name,이름이 들어감
			}
			//HangulConversion.toUTF(req.getParameter(name)) post 방식에만 가능함. 
			//get일때는 req.getParameter(name)
			//target.put(address,req.getParameter(address));
			//target.put(pet,req.getParameter(pet));
			
		}
	}
	//post방식으로 요청시 사용할 것. 한글처리 인코딩 타입은 UTF-8로 하였음.
	public void bindPost(Map<String,Object> target) {
		//p77의 11-15행 대신 쓰려는 것
		//파라미터로 넘어온 target 안에 다른 정보가 담겨있다면 제거
		target.clear();
		Enumeration er = req.getParameterNames(); //name,address,pet
		while(er.hasMoreElements()) {
			String name = (String)er.nextElement(); //name,address,pet
				target.put(name,HangulConversion.toUTF(req.getParameter(name))); //address,주소 . name,이름이 들어감
			//HangulConversion.toUTF(req.getParameter(name)) post 방식에만 가능함. 
			//get일때는 req.getParameter(name)
			//target.put(address,req.getParameter(address));
			//target.put(pet,req.getParameter(pet));
		}
	}
}


