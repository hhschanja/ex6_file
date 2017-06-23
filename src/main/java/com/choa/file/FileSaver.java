package com.choa.file;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileSaver { //오직 파일을 저장만 해주는 놈이야
	
	//첫번째 방법
	public String fileSave(String realPath, String oriname, byte [] fileData) throws Exception{ 
		
		File f = new File(realPath);
		
		if(!f.exists()){
			f.mkdirs();
		}
		
		//중복되는 이름이 없도록 랜덤하게 이름을 만들어주는 놈이야
		String fileName = UUID.randomUUID().toString()+"_"+oriname; //실제 업로드 폴더에 저장되는 실제 파일 이름 -> DB에 저장해야지
		//랜덤이름_진짜이름.jpg 확장자를 알기 위해서 여기서 filename을 다루고 리턴 그걸 받아서
		
		//parent는 경로, child는 파일명
		File target = new File(f, fileName); //실제경로를 f가 가지고 있으니 f라 해도돼 
		
		//springFramework에서 제공하는 저장하는 클래스
		FileCopyUtils.copy(fileData, target); // target에다가 저장하겠습니다
		//앞에가 꺼내는 데이터 그대로 넣는다는 뜻이고 고거를 file에다가 보내겠다. file이 보내는 위치
		
		return fileName; //리턴하는 얘가 DB에 저장하는 이름이 되는거야
		
		
		//파일네임이 upload에서 구분해주기 위해 넣는 이름인데 확장자도 알아야하니까 original 더해서 만들어주고 이놈을 리턴해서
		//DB에 저장해야지
	}
	
	//2번째 방법 transfer
	public String fileSave(String realPath, MultipartFile multi) throws Exception{
		
		File f = new File(realPath);
		
		if(!f.exists()){
			f.mkdirs();
		}
		System.out.println(realPath);
		
		//String fileName = UUID.randomUUID().toString(); //uuid클래스를 만들때는 new 가아니라 .random으로 만들어주는거야 Calecder 객체 만들때 처럼
		
		//시간으로 네임을 잡아줘도 겹치지는 않겠지
		Calendar ca = Calendar.getInstance();
		String fileName = ca.getTimeInMillis()+"_"+multi.getOriginalFilename();
		
		File target = new File(f,fileName);
		
		multi.transferTo(target); //target으로 전달하겠습니다
		
		return fileName;
		
	}
	
	
	
	
	
}
