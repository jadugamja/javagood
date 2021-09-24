package com.pigeon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request
					, HttpServletResponse response) 
					throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 브라우저에 출력하기 위한 객체...
		PrintWriter out = response.getWriter();
		
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		out.println("계산한 결과는 : ");
		out.println(x + y);
		
	} // end of service() doGet()과의 차이는....

} // End Of Add
