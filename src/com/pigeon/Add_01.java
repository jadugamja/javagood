package com.pigeon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/add01")
public class Add_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request
						, HttpServletResponse response) 
						throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		// �ӽ� ����!! �߰� �ܰ迡�� ���̴� ����!!
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		
		// ����ڰ� �Է����� ���� ����� ���� ����غ��� �Ѵ�!!
		// �� ���ڿ��� ��� �⺻�� 0�� �������� ���� ������ �ʱ�ȭ�ϴ� �۾� �����ּ�
		int x = 0;
		int y = 0;
		
		// �츮�� ó������� �ϴ�!!!
		try{
			if(!x_.equals("")){
				x = Integer.parseInt(x_);
			}
			if(!y_.equals("")) {
				y = Integer.parseInt(y_);
			}
		}
		catch(Exception e){
			out.println("What suck error happened? : " + e);
		}

		// �ƿ� ������ ����� ������ �޾�����!!
		int sum = x + y;
		
		// ���� respons.getWriter()�� ������ �������� �ʰ� �״�� ����Ʈf()�� �� �� �ִ� ��!!
		response.getWriter().printf("sum is %d\n", sum);
	}

}
