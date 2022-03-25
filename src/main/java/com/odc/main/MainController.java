package com.odc.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	// 메인 페이지 시작
	@RequestMapping(value = "/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/Index");
		return mav;
	}
	// 메인 페이지 끝
	
	// 헤더 시작
	@RequestMapping(value = "/header")
	public ModelAndView header(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		
		String uId = null;
		uId = (String) session.getAttribute("uId");
		if (uId != null) {			
			String uName = (String) session.getAttribute("uName");
			String uLevel = (String) session.getAttribute("uLevel");
			
			mav.addObject("uId", uId);
			mav.addObject("uName", uName);
			mav.addObject("uLevel", uLevel);
		} 
		
		mav.setViewName("/include/Header");
		return mav;
	}
	// 헤더 끝
	
	// 푸터 시작
	@RequestMapping(value = "/footer")
	public ModelAndView footer() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/include/Footer");
		return mav;
	}
	// 푸터 끝
}
