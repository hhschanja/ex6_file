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
	
	@RequestMapping(value="getMemoList/${curPage}/${kind}/{search}")
	@ResponseBody//주소가 다른애들인데 중간과정이 필요없을 경우 (에이잭스나 이런경우)
	//지금 리턴하는 데이터를 돌아가는 리스트의 내용으로 보내겠다. 제이슨 타입으로 바로 data로 들어감, 파싱 안해도됌
	public List<MemoDTO> memoList(@PathVariable int curPage, @PathVariable String kind, @PathVariable String search, Model model){
		
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(curPage);
		listInfo.setKind(kind);
		listInfo.setSearch(search);
		
		return memoService.list(listInfo);
		
	}
	
	@RequestMapping(value="memoWrite", method=RequestMethod.POST)
	@ResponseBody
	public String memoWrite(MemoDTO memoDTO, Model model) throws Exception{
		
		memoService.write(memoDTO);
		
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(1);
		listInfo.setRow();
		
		List<MemoDTO> lar = memoService.list(listInfo); //메소드를 한번 더 해서 보내는거지
		
		model.addAttribute("list", lar);
		
		return "memo/getMemoList"; //jsp 페이지로 가겠지 그놈을 DATA로 들고오겠지
	}
	
	@RequestMapping(value="memoView/{num}") //rest press방식 주소에 데이터가 들어가서 오는거야
	@ResponseBody
	public MemoDTO memoView(@PathVariable("num") int num) throws Exception{
		MemoDTO memoDTO = memoService.view(num);
		return memoDTO;
	}
	
	
}
