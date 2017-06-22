package com.choa.ex6;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.choa.file.FileDTO;
import com.choa.file.MultiFileDTO;
import com.choa.file.SameMultiFileDTO;

@Controller
@RequestMapping(value="/file/**")
public class FileController {

	
	@RequestMapping(value="fileUpload",method=RequestMethod.GET)
	public void fileUpload() throws Exception{
		
	}
	
	//★★★★ 파라미터 이름을 모르거나 갯수를 모를 때
	
	
	
	//★★★★같은 파라미터 이름이 여러개일 경우 
/*	@RequestMapping(value="sameMultiFileUpload", method=RequestMethod.POST) //DTO에서 배열로~
	public void multiFileUpload(MultipartHttpServletRequest request){
		List<MultipartFile> ar = request.getFiles("f1");
		
		for(MultipartFile f:ar){
			System.out.println(f.getOriginalFilename());
		}
		
	}*/
	
/*	@RequestMapping(value="sameMultiFileUpload", method=RequestMethod.POST) //DTO에서 배열로~
	public void multiFileUpload(SameMultiFileDTO f1){
		for(int i=0;i<f1.getF1().length;i++){
		  System.out.println(f1.getF1()[i].getOriginalFilename());
		}
	}*/
	
/*	@RequestMapping(value="sameMultiFileUpload", method=RequestMethod.POST) //애초에 배열로~
	public void multiFileUpload(MultipartFile [] f1){
		for(int i=0;i<f1.length;i++){
		  System.out.println(f1[i].getOriginalFilename());
		}
	}
	*/
	
	
	//★★★★다중파일 업로드 - 파라미터 이름이 다를때
	
/*	@RequestMapping(value="multiFileUpload", method=RequestMethod.POST)
	public void multiFileUpload(MultipartHttpServletRequest request){
		MultipartFile f1 = request.getFile("f1");
		MultipartFile f2 = request.getFile("f2");
	}*/
	
/*	@RequestMapping(value="multiFileUpload", method=RequestMethod.POST)
	public void multiFileUpload(MultipartFile f1,MultipartFile f2){
		System.out.println(f1.getOriginalFilename());
		System.out.println(f2.getOriginalFilename());
	}
	
	@RequestMapping(value="multiFileUpload", method=RequestMethod.POST)
	public void multiFileUpload(MultiFileDTO multi){
		System.out.println(multi.getF1().getOriginalFilename());
		System.out.println(multi.getF2().getOriginalFilename());
	}*/

	
	
	
	//★★★★단일파일 업로드
	
/*	@RequestMapping(value="fileUpload",method=RequestMethod.POST)
	public void fileUpload(MultipartHttpServletRequest multi){
		
	}*/
/*	@RequestMapping(value="fileUpload",method=RequestMethod.POST)
	public void fileUpload(MultipartFile f1){ //파라미터 이름과 동일
		
	}
	@RequestMapping(value="fileUpload",method=RequestMethod.POST)
	public void fileUpload(FileDTO fileDTO){
		
	}*/
	
}
