//package com.pigeon.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//
//@WebFilter("/*")
//public class CharacterEncodingFilter implements Filter {
//
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//
//	}
//	
//	@Override
//	public void doFilter(ServletRequest request
//			, ServletResponse response
//			, FilterChain chain)
//			throws IOException, ServletException {
//
//		// 실행되기 전에 거치는 필터
//		System.out.println("before filter");
//		
//		// 이로써 필터를 거치는 모든 서블릿은 인코딩 "UTF-8" 환경이 설정되는 것이ㄷㅏ!
//		request.setCharacterEncoding("UTF-8");
//		
//		// 이 흐름을 다음으로 넘겨주는 것은 chain이 결정한다!
//		// 다음 필터/서블릿에게 넘김
//		chain.doFilter(request, response);
//		
//		// 넘겨준 후에 결과가 다시 필터로 돌아오게 되면 그 때 "after filter"가 출력된다.
//		// 콘솔창에만 출력된다!!!
//		System.out.println("after filter");
//		
////		현재 실행 html 파일 돌리면 after filter가 출력되는 상황이다.. filter를 가볍게 뛰어넘는.. 중이신..ㅠㅠ
////		아무래도 filter 없이 진행해야 할 것 같다는 생각이 들어요...
//	}
//
//	@Override
//	public void init(FilterConfig arg0) throws ServletException {
//		// TODO Auto-generated method stub
//
//	}
//
//}
