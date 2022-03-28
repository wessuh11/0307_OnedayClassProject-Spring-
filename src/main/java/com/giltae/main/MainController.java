package com.giltae.main;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.giltae.utils.SessionMgr;

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
		
		// 세션안의 있는 모든 값을 Map자료형으로 return
		Map<String, Object> sessMap = SessionMgr.outputData(request);
		
		// sessMap에 자료가 있을 경우 = 로그인이 되어있을 경우
		if ( sessMap != null && !sessMap.isEmpty()) {
			mav.addObject("sessData", sessMap);
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
	
	// 마이페이지 시작
	@RequestMapping(value = "/myPage")
	public ModelAndView myPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		// 세션안의 있는 모든 값을 Map자료형으로 return
		Map<String, Object> sessMap = SessionMgr.outputData(request);
		
		// sessMap에 자료가 있을 경우 = 로그인이 되어있을 경우
		if ( sessMap != null && !sessMap.isEmpty()) {
			mav.addObject("sessData", sessMap);
		}
		
		mav.setViewName("/sign/MyPage");
		return mav;
	}
	// 마이페이지 끝
}
