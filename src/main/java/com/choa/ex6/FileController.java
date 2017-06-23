package com.choa.ex6;

import java.io.File;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.choa.file.FileSaver;
import com.choa.file.FileService;
import com.choa.util.SeDTO;


@Controller
@RequestMapping(value="/file/**")
public class FileController {

	//★★★★★ 폼으로 가기
	@RequestMapping(value="fileUpload",method=RequestMethod.GET)
	public void fileUpload() throws Exception{
		
	}
	
	//★★★★★  개념
/*	@RequestMapping(value="seUpload",method=RequestMethod.POST)
	public void seUpload(MultipartHttpServletRequest request){
		
	Enumeration<Object> o = request.getParameterNames(); ///파라미터 이름 구하는거야 그걸 알아야 주소에 파라미터를 입력하지
		
		while(o.hasMoreElements()){
			System.out.println(o.nextElement());
		}
		
	Iterator<String> it = request.getFileNames(); //멀티파트파일??
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}*/
	
	
	//★★★★★파일 다운로드
	@RequestMapping(value="fileDown",method=RequestMethod.GET) //A태그니까 get이야
	public ModelAndView fileDown(String fileName, HttpSession session){
		
		String realPath = session.getServletContext().getRealPath("resources/upload");
	
		File f = new File(realPath, fileName);
		
		//다운로드 할 수 있게 해줘야해 그런데 String으로 해서 .jsp로 가잖아..
		ModelAndView mv = new ModelAndView();
		mv.setViewName("download"); //클래스 이름과 동일하게 맞춰줘야함 다만 소문자로~ 
		mv.addObject("downloadFile",f); //모델에다가 file 객체를 집어넣은거지 이게 맵타입으로 키랑 밸류로 들어가는거야
		return mv;
	
	}
	
	
	
	
	//★★★★★SmartEditor
	@RequestMapping(value="seUpload",method=RequestMethod.POST)
	public String seUpload(SeDTO seDTO, HttpSession session) throws Exception{ //seDTO에 알아서 다 들어가겠지 파라미터 이름이 같으니까
		
		
		FileService fs = new FileService();
		return fs.seUpload(seDTO, session); //redirect 구문이 리턴되서 오니까 그대로 주소로 쓰면되지
		
		/*//callBack
		String callback = seDTO.getCallback();
		
		//callBack_func
		String callback_func = seDTO.getCallback_func();
		
		//Oriname
		String original_name = seDTO.getFiledata().getOriginalFilename();

		//realPath
		String defaultPath = session.getServletContext().getRealPath("resources/upload");
		
		//디렉터리가 존재하지 않을 경우 디렉토리 생성
		File f = new File(defaultPath); //이거는 디렉토리만 만드는거니까 파일이름까지는 없어 그래서 밑에서 파일을 또만드는거야
		if(!f.exists()){
			f.mkdirs();
		}
		
		//디렉토리에 저장할 파일명
		String realName = UUID.randomUUID().toString()+"_"+original_name;
		
		//서버에 저장
		seDTO.getFiledata().transferTo(new File(f, realName)); //f에 경로가 들어있는거고 그 경로에서 realName파일명까지! 
		
		//네이버에서 요구하는 파라미터를 입력
		String file_result = "&bNewLine=true&sFileName="+original_name+"&sFileURL=/ex6/resources/upload/"+realName;
	
		return "redirect:"+callback+"?callback_func="+callback_func+file_result; //callback은 주소가 되겠지
*/	}

	
	//★★★★★삭제
	@RequestMapping(value="fileDelete", method=RequestMethod.GET)
	public void fileDelete(String fileName, HttpSession session)throws Exception{
		FileService fileService = new FileService();
		Boolean result = fileService.fileDelete(fileName, session);
		System.out.println(result);
		
	}

	
	//★★★★ 다중파일 업로드 - 파라미터 이름이 다를때(몇개가 넘어올지 모르는 경우) - 얘는 DTO랑 multiFIle은 안돼

	/*	@RequestMapping(value="sameMultiFileUpload", method=RequestMethod.POST) //DTO에서 배열로~
	public void multiFileUpload(MultipartHttpServletRequest request){
		
		Iterator<String> ar = request.getFileNames();
		ArrayList<MultipartFile> multi = new ArrayList<MultipartFile>();
		
		while(ar.hasNext()){//몇개 인지 모르니까 while을 돌리는거야
			MultipartFile m = request.getFile(ar.next());
			multi.add(m);
		}
		
		for(MultipartFile haha:multi){
			System.out.println(haha.getOriginalFilename());
		}
		
	}*/
	
	//★★★★다중파일 업로드 - 파라미터 이름이 같을때 (몇개가 넘어올지 모르는 경우)
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
	
	
	//★★★★다중파일 업로드 - 파라미터 이름이 다를때 (몇개가 넘어올지 아는경우)
	
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
	@RequestMapping(value="fileUpload",method=RequestMethod.POST)
	public ModelAndView fileUpload(MultipartFile f1, HttpSession session) throws Exception{ //파라미터 이름 매개변수 이름이 같아야해
		FileService fileService = new FileService();
		String fileName = fileService.flieSave(f1, session);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("fileName", fileName);
		mv.addObject("oriName", f1.getOriginalFilename());
		mv.setViewName("file/fileView");
		
		return mv;
	}
	/*	@RequestMapping(value="fileUpload",method=RequestMethod.POST)
	public void fileUpload(FileDTO fileDTO){
		
	}*/
	
}
