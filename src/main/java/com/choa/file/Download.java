package com.choa.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class Download extends AbstractView{ //요놈이 이제 일반 클래스가 아니라 view객체 역할을 해야해 그런데 지금 뷰가 없는데 만들어야하잖아 그래서 스프링에서 제공하는 앱스트랙 뷰를 상속받아야해

	public Download() { //어떤 놈을 다운로드와 연결해주려고 //abstract view 에 있는 메소드인거지
		setContentType("application/download;charset=UTF-8"); //컴퓨터한테 메세지를 보내는거야 컴퓨터가 이걸 보고 준비하니까, 이걸보고 다운로드 준비를 하는거지, 만약 음악파일이어서 재생해야하면 음악에 대한걸 적어주는거지  
		
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			File f = (File)model.get("downloadFile"); //해쉬로 키를 넣어서 객체를 들고오는거야
			
			//response가 받는거니까 여기다가
			response.setCharacterEncoding(getContentType()); //위에 선언했잖아 그걸 그대로 쓰자
			response.setContentLength((int)f.length()); //파일 크기
			
			String filename = URLEncoder.encode(f.getName(), "UTF-8"); //파일 명을 꺼내오는거야 //한글이면 깨질 수 있으니까 한글로 만들어주는 놈이있어
			filename = filename.substring(filename.lastIndexOf("_")+1);
			
			response.setHeader("Content-Disposition", "attachment;filename=\""+filename+"\"");
			response.setHeader("Content-Transfer-Encoding", "binary"); //전송할때는 이진수로 날아가야지 컴퓨터니까
			
			//내보내줘야지 컴퓨터에서
			OutputStream out = response.getOutputStream(); // client가 response를 받잖아
			
			FileInputStream fi = null;
			
			fi = new FileInputStream(f);
			
			FileCopyUtils.copy(fi, out);
			
			fi.close();
			out.close();
	
	}
	
}
