package com.choa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component //이거는 spring에서 인식하는 객체생성 어너테이션이야 
@Aspect //얘는 aspect입니다라는 어너테이션이라 spring은 인식을 못해 그래서 scan을 더 때려줘야해
public class CardCheck {
	
	@Before("execution(* com.choa.aspect..Trip.*(..))") //이거 하기 before에 이걸 하겠다
	public void reservation(){
		System.out.println("예약완료");
		System.out.println("======================");
	}

	@Around("execution(* com.choa.aspect..Transport.*(..))") //이거 일 때는 어라운드를 하겠다
	public Object check(ProceedingJoinPoint join){ //만약 bus라면 join에 버스가 들어가서 오브젝트 실행하는거야 그리고 out찍는거야
		System.out.println("Card check IN");
		
		Object obj = null;
		
		try {
			obj = join.proceed();
			
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Card check OUT");
		
		return obj;
	}
	
}
