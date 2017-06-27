package com.choa.ex6;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.choa.table.TableADTO;
import com.choa.table.TableService;

public class TableTest extends MyAbstract{

	@Inject
	private TableService tableService;
	
	@Test
	public void test() throws Exception{
		
		TableADTO tableADTO = new TableADTO();
		tableADTO.setNum(2);
		tableADTO.setTitle("T2");
		tableADTO.setWriter("T2");
		
		int result = tableService.insertTable(tableADTO, 1);
	
		assertEquals(1, result);
		
	}

}
