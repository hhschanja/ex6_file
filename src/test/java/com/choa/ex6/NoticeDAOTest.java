package com.choa.ex6;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDAOImpl;

public class NoticeDAOTest extends MyAbstract{

	@Inject
	private NoticeDAOImpl noticeDAOImpl;
	
	@Test
	public void test() throws Exception{
		
		BoardDTO b = noticeDAOImpl.view(31);
		
		assertNotNull(b);
		
	}

}
