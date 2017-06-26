package com.choa.ex6;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.choa.memo.MemoDAO;
import com.choa.memo.MemoDTO;
import com.choa.util.ListInfo;

public class MemoDAOTest extends MyAbstract{

	@Inject
	private MemoDAO memoDAO;
	
	@Test
	public void test() throws Exception{
		
		MemoDTO memoDTO = new MemoDTO();
		
		memoDTO.setContents("handsome");
		memoDTO.setNum(999);
		
		int result = memoDAO.update(memoDTO);
		
		assertEquals(1, result);
	}

}
