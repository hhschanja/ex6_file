package com.choa.aspect;

import org.springframework.stereotype.Component;

@Component
public class Transport {

	public void bus(){ //핵심 코드
		System.out.println("자리 뺏기");
		System.out.println("옆사람 핸드폰 보기");
		System.out.println("BUS");
	}
	
	public void subway(){
		System.out.println("두리번두리번");
		System.out.println("지하철 노선도 보기");
		System.out.println("Subway");
	}
	
}
