package pack.spring.gth;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

	//인덱스 페이지 시작
	@RequestMapping(value = "/")
	public ModelAndView index() {
		
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("/index");
	    return mav;
	}
	//인덱스 페이지 끝

}
