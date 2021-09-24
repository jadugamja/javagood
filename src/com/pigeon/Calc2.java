package com.pigeon;

import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request
						, HttpServletResponse response) 
						throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
//		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		
		// �ӽ� ���� x_, y_ : �߰� �ܰ迡�� ���̴� ����
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		try{
			// ����ڰ� �Է����� �ʴ� ����� ���� ����غ��� �Ѵ�!!
			// �� ���ڿ��� ��� �⺻�� 0�� �������� ���� ������ �ʱ�ȭ�ϴ� �۾� �����ּ�
			int v = 0;
			// �츮�� ó������� �ϴ�!!!
			if(!v_.equals("")) v = Integer.parseInt(v_);
	
			// ���
			if(op.equals("")) {
				
				// �տ��� �����ߴ� ��
				// getAttribute("Ű����") : ���� �� ����ߴ� Ű����� ������!
				// (Integer) ����ȯ : Object to int
//				int x = (Integer)application.getAttribute("value");
				int x = (Integer)session.getAttribute("value");
				// ����(���� �ֱ�) ����ڰ� ������ ��
				int y = v;
//				String operator = (String)application.getAttribute("op");
				String operator = (String)session.getAttribute("op");
				int result = 0;
				
				if(operator.equals("+"))
					result= x + y;
				else
					result = x - y;
				response.getWriter().printf("result is %d\n", result);
			}
			// ���� ����
			else {	
			
				// how to ����
				// setAttribute("Ű����", ��) : ���!
//				application.setAttribute("value", v);
//				application.setAttribute("op", op);
				session.setAttribute("value", v);
				session.setAttribute("value", v);
			}
		}
		catch(Exception e) {
			out.println("�ӳĸ�" + e);
		}
		// ���� respons.getWriter()�� ������ �������� �ʰ� �״�� ����Ʈf()�� �� �� �ִ� ��!!
	}

}
