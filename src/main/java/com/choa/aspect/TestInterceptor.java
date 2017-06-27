package com.choa.aspect;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.choa.board.BoardDTO;
import com.choa.util.ListInfo;

public class TestInterceptor extends HandlerInterceptorAdapter{ //상속을 받아야 인터셉트를 사용할 수 있어

	@Override //컨트롤러에서 빠져나온 다음이니까 리턴 없어 무조건 dipatcher servlet으로 가는거야
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Controller 나온 후");
		Map<String, Object> map = modelAndView.getModel(); //모델에 있는 놈을 꺼내오는거야
		Object list = map.get("list");
		Object listInfo = map.get("listInfo");
		Object board = map.get("board");

		System.out.println(((List<BoardDTO>)list).get(0).getWriter());
		System.out.println(((ListInfo)listInfo).getCurBlock());
		System.out.println(board);
		
		//modelAndView.setViewName("home"); //지금이 디스패처 가지 전이니까 이렇게 치면 홈으로 가는거지
		
		
	}

	@Override //컨트롤러 가기 전
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Controller 들어가기 전");
		return true; //true라면 계속 가는거고 아니라면 false
	} 

}
