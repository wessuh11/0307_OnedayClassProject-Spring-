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
}
