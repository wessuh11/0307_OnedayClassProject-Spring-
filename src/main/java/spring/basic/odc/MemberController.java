package spring.basic.odc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public ModelAndView signUp() {
		return new ModelAndView("sign/Member");
	}
	
	@Autowired
	MemberService memberService;
	
	// 회원가입 시작
	@RequestMapping(value="/member", method = RequestMethod.POST)
	public ModelAndView memberPost(@RequestParam Map<String, Object> map) {
		
		ModelAndView mav = new ModelAndView();
		
		String memberId = this.memberService.signUp(map);
		if (memberId == null) {
					mav.setViewName("redirect:/member");
		} else {
					mav.setViewName("redirect:/detail?memberId=" + memberId);
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
	
	/*
	 * // 인덱스 페이지 시작
	 * 
	 * @RequestMapping(value = "/") public ModelAndView index() {
	 * 
	 * ModelAndView mav = new ModelAndView(); mav.setViewName("/index"); return mav;
	 * } // 인덱스 페이지 끝
	 */	
}
