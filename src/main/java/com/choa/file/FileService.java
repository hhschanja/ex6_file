package com.choa.file;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.choa.util.SeDTO;

@Service
public class FileService {
	
	public String flieSave(MultipartFile m, HttpSession session)throws Exception{
		FileSaver fileSaver = new FileSaver();
		
		return fileSaver.fileSave(session.getServletContext().getRealPath("resources/upload"), m);
	}

	//delete
	public Boolean fileDelete(String fileName, HttpSession session) throws Exception{
		String realPath = session.getServletContext().getRealPath("/resources/upload");
		File f = new File(realPath,fileName);
	
		boolean check = f.delete();
		
		return check;
	}
	
	public String seUpload(SeDTO seDTO, HttpSession session) throws Exception{
		
		String file_result = "";
		
		if(seDTO.getFiledata() != null && seDTO.getFiledata().getOriginalFilename() != null && !seDTO.getFiledata().getOriginalFilename().equals("")){//파일이 없는경우,넣었는데 파일명이 없는경우
			FileSaver fs = new FileSaver();
			String defaultPath = session.getServletContext().getRealPath("resources/upload");
			String realName = fs.fileSave(defaultPath, seDTO.getFiledata());
			
			file_result = "&bNewLine=true&sFileName="+seDTO.getFiledata().getOriginalFilename()+"&sFileURL=/ex6/resources/upload/"+realName;
		
		}else{
			file_result="&errstr=ERROR";
		}
		
		return "redirect:"+seDTO.getCallback()+"?callback_func="+seDTO.getCallback_func()+file_result;
	}
	
}
