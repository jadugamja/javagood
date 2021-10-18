package a.b.c.com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.vo.FormDataVO;

@Controller
public class FormDataController {

	@RequestMapping(value="formdata_find", method=RequestMethod.GET)
	public String formdata() {
		
		// "/mvc/formdata_return"�� �ƴ� ����!
		// bean �±� in spring-servlet.xml
		// <property name="prefix" value="/WEB-INF/view/" /> <- ��������!!!
		// �տ� slash xx
		return "mvc/formdata_return";
	}
	
	// ���� �������
	// �� ���������� ������ �޾ƿ��� : request.getParameter()
	// controller���� jsp�� ������ ������ : request.setAttribute()
	@RequestMapping(value="formdata_get", method=RequestMethod.GET)
	public String formdataget(HttpServletRequest req, Model m) {
		
		System.out.println("�Ŷ� ��");
		
		String datanum = req.getParameter("datanum");
		System.out.println("FormDataController.formdata_get_servlet().datanum >>> : " + datanum);
		req.setAttribute("req.datanum", datanum);
		m.addAttribute("el_datanum", datanum);
		
		String dataid = req.getParameter("dataid");
		System.out.println("FormDataController.formdata_get_servlet().dataid >>> : " + dataid);
		req.setAttribute("req.dataid", dataid);
		m.addAttribute("el_dataid", dataid);
		
		String datapw = req.getParameter("datapw");
		System.out.println("FormDataController.formdata_get_servlet().datapw >>> : " + datapw);
		req.setAttribute("req.datapw", datapw);
		m.addAttribute("el_datapw", datapw);
		
		String dataname = req.getParameter("dataname");
		System.out.println("FormDataController.formdata_get_servlet().dataname >>> : " + dataname);
		req.setAttribute("req.dataname", dataname);
		m.addAttribute("el_dataname", dataname);
		
		return "mvc/formdata_get_servlet";
	}
	
	// Spring Web MVC ������� 
	@RequestMapping(value="formdata_get_spring", method=RequestMethod.GET)
	public String formdata_get_spring(FormDataVO fvo, Model m) {
		System.out.println("FormDataController formdata_get_spring() �Լ� ����");
		
		System.out.println("formdata_get_spring >>> : fvo ::: " + fvo);
		System.out.println("formdata_get_spring >>> : fvo.getDatanum() ::: " + fvo.getDatanum());
		System.out.println("formdata_get_spring >>> : fvo.getDataid() ::: " + fvo.getDataid());
		System.out.println("formdata_get_spring >>> : fvo.getDatapw() ::: " + fvo.getDatapw());
		System.out.println("formdata_get_spring >>> : fvo.getDataname() ::: " + fvo.getDataname());
		
		m.addAttribute("m_fvo", fvo);
		
		return "mvc/formdata_get_spring_return";
	}
	
	// ???????????
	@RequestMapping(value="formdata_post_spring", method=RequestMethod.POST)
	public String formdata_post_model_attribute(@ModelAttribute("ma_fdvo") FormDataVO fdvo) {
		/*
		 * the NUMBER of form input name == the NUMBER of fields in VO
			name="datanum"  ---> private String datanum
			name="dataid"   ---> private String dataid
			name="datapw"   ---> private String datapw
			name="dataname" ---> private String datapw
		 */
		
		System.out.println("formdata_post_model_attribute >>> fdvo :: " + fdvo);
		System.out.println("formdata_post_model_attribute >>> fdvo.getDatanum() :: " + fdvo.getDatanum());
		System.out.println("formdata_post_model_attribute >>> fdvo.getDataid() :: " + fdvo.getDataid());
		System.out.println("formdata_post_model_attribute >>> fdvo.getDatapw() :: " + fdvo.getDatapw());
		System.out.println("formdata_post_model_attribute >>> fdvo.getDataname() :: " + fdvo.getDataname());
		
		return "mvc/formdata_post_model_attribute_return";
	} 

	@RequestMapping(value="formdata_post_valueobject", method=RequestMethod.POST)
	public String formdata_post_valueobject() {
		
		return "mvc/formdata_post_valueobject_return";
	}
}
