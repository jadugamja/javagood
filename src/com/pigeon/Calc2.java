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
		
		// 임시 변수 x_, y_ : 중간 단계에서 쓰이는 변수
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		try{
			// 사용자가 입력하지 않는 경우의 수를 고려해봐야 한다!!
			// 빈 문자열의 경우 기본값 0이 나오도록 먼저 변수를 초기화하는 작업 거쳐주쇼
			int v = 0;
			// 우리가 처리해줘야 하는!!!
			if(!v_.equals("")) v = Integer.parseInt(v_);
	
			// 계산
			if(op.equals("")) {
				
				// 앞에서 저장했던 값
				// getAttribute("키워드") : 담을 때 사용했던 키워드로 꺼내기!
				// (Integer) 형변환 : Object to int
//				int x = (Integer)application.getAttribute("value");
				int x = (Integer)session.getAttribute("value");
				// 지금(가장 최근) 사용자가 저장한 값
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
			// 값을 저장
			else {	
			
				// how to 저장
				// setAttribute("키워드", 값) : 담기!
//				application.setAttribute("value", v);
//				application.setAttribute("op", op);
				session.setAttribute("value", v);
				session.setAttribute("value", v);
			}
		}
		catch(Exception e) {
			out.println("머냐면" + e);
		}
		// 굳이 respons.getWriter()를 변수로 설정하지 않고 그대로 프린트f()를 쓸 수 있는 것!!
	}

}
