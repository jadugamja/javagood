package a.b.c.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class StringReturnController {
	

	@RequestMapping("viewJsp_3_voidTest_find")
	public void voidTest(Model md) {
		md.addAttribute("mm", "������������"
							+ "void�� "
							+ "������ �־��"
							+ "��,"
							+ "��û url �̸���"
							+ "view �̸��� ���ƾ� ��!");
		
	}
}
