package a.b.c.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class StringReturnController {
	

	@RequestMapping("viewJsp_3_voidTest_find")
	public void voidTest(Model md) {
		md.addAttribute("mm", "스프링에서는"
							+ "void도 "
							+ "리턴이 있어요"
							+ "단,"
							+ "요청 url 이름과"
							+ "view 이름이 같아야 함!");
		
	}
}
