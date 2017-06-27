package com.choa.ex6;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;
import com.choa.util.ListInfo;




@Controller 
@RequestMapping("/memo/**")
public class MemoController {

	@Inject
	private MemoService memoService;
	
	//list
	@RequestMapping(value="memoList")
	public void memoList(){
		
	}
	
	@RequestMapping(value="getMemoList")
	@ResponseBody//주소가 다른애들인데 중간과정이 필요없을 경우 (에이잭스나 이런경우)
	//지금 리턴하는 데이터를 돌아가는 리스트의 내용으로 보내겠다. 제이슨 타입으로 바로 data로 들어감, 파싱 안해도됌
	public List<MemoDTO> memoList(Model model, ListInfo listInfo){
		
		return memoService.list(listInfo);
		
	}
	
	@RequestMapping(value="memoWrite", method=RequestMethod.POST)
	@ResponseBody
	public List<MemoDTO> memoWrite(MemoDTO memoDTO) throws Exception{
		
		memoService.write(memoDTO);
		
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(1);
		listInfo.setRow();
		
		List<MemoDTO> lar = memoService.list(listInfo); //메소드를 한번 더 해서 보내는거지
		
		return lar;
	}
	
	
	
	@RequestMapping(value="memoView") 
	@ResponseBody
	public MemoDTO memoView(int num) throws Exception{
		MemoDTO memoDTO = memoService.view(num);
		return memoDTO;
	}
	
	
}
