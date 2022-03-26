package com.giltae.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.giltae.utils.ScriptAlertUtils;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;

	// 회원가입 시작
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public ModelAndView signUp(HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		String uId = null;
		uId = (String) session.getAttribute("uId");
		if (uId != null) {	
			String alertMsg = "이미 로그인 상태입니다.";
			ScriptAlertUtils.alertAndMovePage(response, alertMsg, "/");
		}
		
		return new ModelAndView("sign/Member");
	}

	@RequestMapping(value="/member", method = RequestMethod.POST)
	public ModelAndView memberPost(@RequestParam Map<String, Object> map, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		int affectRowCnt = this.memberService.signUp(map);
		if (affectRowCnt == 0) {
			String alertMsg = "회원가입 중 오류가 생겼습니다. 다시 시도해 주십시오";
			ScriptAlertUtils.alertAndMovePage(response, alertMsg, "/member");
		} else {
			String alertMsg = "회원가입을 완료하였습니다.";
			ScriptAlertUtils.alertAndMovePage(response, alertMsg, "/");
		}
		
		return mav;
	}
	// 회원가입 끝
	
	// 중복확인 시작
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	public ModelAndView checkId(@RequestParam Map<String, Object> map) {
		
		ModelAndView mav = new ModelAndView();	
		
		Map<String, Object> checkIdMap = this.memberService.checkId(map);
		
		mav.addObject("data", checkIdMap);

		mav.setViewName("/sign/IdCheck");
		return mav;
	}
	// 중복확인 끝
	

	// 로그인 시작
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return new ModelAndView("sign/Login");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost (@RequestParam Map<String, Object> map, HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> loginMap = this.memberService.login(map);
		
		if (loginMap == null) {
			
			String alertMsg = "아이디와 비밀번호를 확인해주세요.";
			ScriptAlertUtils.alertAndMovePage(response, alertMsg, "/login");
			
		} else {

			String alertMsg = "로그인 성공";
			
			HttpSession session = request.getSession();

			for (Map.Entry<String, Object> entry : loginMap.entrySet()) {
				String key = entry.getKey();
				String val = (String)entry.getValue();
				session.setAttribute(key, val);
				System.out.println(key + " " + val);
			}
			ScriptAlertUtils.alertAndMovePage(response, alertMsg, "/");
		}
		
		return mav;
	}
	// 로그인 끝
	
	//로그아웃
    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        session.invalidate();
        String alertMsg = "로그아웃 되었습니다.";
        ScriptAlertUtils.alertAndMovePage(response, alertMsg, "/");
        ModelAndView mav = new ModelAndView("redirect:/");
        return mav;
    }
    //로그아웃 끝

}
