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
		
		// 임시 변수 x_, y_ : 중간 단계에서 쓰이는 변수
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		
		String op = request.getParameter("operator");
		
		// 사용자가 입력하지 않는 경우의 수를 고려해봐야 한다!!
		// 빈 문자열의 경우 기본값 0이 나오도록 먼저 변수를 초기화하는 작업 거쳐주쇼
		int x = 0;
		int y = 0;
		
		// 우리가 처리해줘야 하는!!!
		if(!x_.equals("")) x = Integer.parseInt(x_);
		if(!y_.equals("")) y = Integer.parseInt(y_);
		
		// 연산 결과 변수를 초기화ㅇㅇ
		int result = 0;

		// 두 가지 경우의 수밖에 없으므로 if-else로 받으면 됨ㅇㅇ
		if(op.equals("덧셈"))
			result= x + y;
		else
			result = x - y;
		
		// 굳이 respons.getWriter()를 변수로 설정하지 않고 그대로 프린트f()를 쓸 수 있는 것!!
		response.getWriter().printf("result is %d\n", result);
	}

}
