package com.pigeon;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Add2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request
						, HttpServletResponse response) 
						throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// Parameter 여럿 받을 때! -> 배열로 받는다!!!
		String[] num_ = request.getParameterValues("num");
		
		int result = 0;
		
		for(int i=0; i<num_.length; i++){
			// 반복하기 전에 한 번만 만들어지고 선언은 반복되지 않는다!
			// ★연산은 반복되지만 선언은 반복되지 않음★
			// num은 for문 안에서만 도는 지역변수가 되므로 더 바람직하다!!
			int num = Integer.parseInt(num_[i]);
			result+=num;
		}
		
		// 굳이 respons.getWriter()를 변수로 설정하지 않고 그대로 프린트f()를 쓸 수 있는 것!!
		response.getWriter().printf("result is %d\n", result);
	}

}
