package com.pigeon;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request
						, HttpServletResponse response) 
						throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// �ӽ� ���� x_, y_ : �߰� �ܰ迡�� ���̴� ����
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		
		String op = request.getParameter("operator");
		
		// ����ڰ� �Է����� �ʴ� ����� ���� ����غ��� �Ѵ�!!
		// �� ���ڿ��� ��� �⺻�� 0�� �������� ���� ������ �ʱ�ȭ�ϴ� �۾� �����ּ�
		int x = 0;
		int y = 0;
		
		// �츮�� ó������� �ϴ�!!!
		if(!x_.equals("")) x = Integer.parseInt(x_);
		if(!y_.equals("")) y = Integer.parseInt(y_);
		
		// ���� ��� ������ �ʱ�ȭ����
		int result = 0;

		// �� ���� ����� ���ۿ� �����Ƿ� if-else�� ������ �ʤ���
		if(op.equals("����"))
			result= x + y;
		else
			result = x - y;
		
		// ���� respons.getWriter()�� ������ �������� �ʰ� �״�� ����Ʈf()�� �� �� �ִ� ��!!
		response.getWriter().printf("result is %d\n", result);
	}

}
