package com.choa.memo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.util.ListInfo;

@Service
public class MemoService {

	@Inject
	private MemoDAO memoDAO;
	
	public List<MemoDTO> list(ListInfo listInfo){
		
		int totalCount = memoDAO.count(listInfo);
		listInfo.setRow();
		listInfo.pageResult(totalCount);
		
		return memoDAO.list(listInfo);
	}
	
	public int write(MemoDTO memoDTO) throws Exception{
		return memoDAO.write(memoDTO);
		
	}
	
	public int update(MemoDTO memoDTO) throws Exception{
		return memoDAO.update(memoDTO);
	}
	
	public int delete(int num){
		return memoDAO.delete(num);
	}
	
	public MemoDTO view(int num){
		return memoDAO.view(num);
	}
	
}
