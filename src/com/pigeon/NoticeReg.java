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
		// 사용자에게 보내는 인코딩 방식 설정
		response.setCharacterEncoding("UTF-8");
		// 사용자가 받는 인코딩 방식
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		// 전달하는 쪽(reg.html)에서는 두 개의 key가 있다. "title", "content"
		// 둘 다 String으로 받앗음.
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		out.println("title : " + title);
		out.println("content : " + content);
	
	} // end of service()
	
} // End OF NoticeReg
