package com.choa.ex6;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //모든 Exception은 일로옴
public class ExceptionController {

	@ExceptionHandler(Exception.class) 
	public String exception(Exception e, Model model){
		model.addAttribute("e", e.getMessage()); //베포할때는 이건 필요없지
		return "error/notFound";
	}
	
}
