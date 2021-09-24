package com.pigeon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
					throws IOException, ServletException{

		request.setCharacterEncoding("UTF-8");
		// ����ڿ��� ������ ���ڵ� ��� ����
		response.setCharacterEncoding("UTF-8");
		// ����ڰ� �޴� ���ڵ� ���
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		// �����ϴ� ��(reg.html)������ �� ���� key�� �ִ�. "title", "content"
		// �� �� String���� �޾���.
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		out.println("title : " + title);
		out.println("content : " + content);
	
	} // end of service()
	
} // End OF NoticeReg
