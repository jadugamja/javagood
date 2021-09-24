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
		// 임시 변수!! 중간 단계에서 쓰이는 변수!!
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		
		// 사용자가 입력하지 않을 경우의 수를 고려해봐야 한다!!
		// 빈 문자열의 경우 기본값 0이 나오도록 먼저 변수를 초기화하는 작업 거쳐주쇼
		int x = 0;
		int y = 0;
		
		// 우리가 처리해줘야 하는!!!
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

		// 아예 덧셈한 결과를 변수로 받아주자!!
		int sum = x + y;
		
		// 굳이 respons.getWriter()를 변수로 설정하지 않고 그대로 프린트f()를 쓸 수 있는 것!!
		response.getWriter().printf("sum is %d\n", sum);
	}

}
