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
//		// ����Ǳ� ���� ��ġ�� ����
//		System.out.println("before filter");
//		
//		// �̷ν� ���͸� ��ġ�� ��� ������ ���ڵ� "UTF-8" ȯ���� �����Ǵ� ���̤���!
//		request.setCharacterEncoding("UTF-8");
//		
//		// �� �帧�� �������� �Ѱ��ִ� ���� chain�� �����Ѵ�!
//		// ���� ����/�������� �ѱ�
//		chain.doFilter(request, response);
//		
//		// �Ѱ��� �Ŀ� ����� �ٽ� ���ͷ� ���ƿ��� �Ǹ� �� �� "after filter"�� ��µȴ�.
//		// �ܼ�â���� ��µȴ�!!!
//		System.out.println("after filter");
//		
////		���� ���� html ���� ������ after filter�� ��µǴ� ��Ȳ�̴�.. filter�� ������ �پ�Ѵ�.. ���̽�..�Ф�
////		�ƹ����� filter ���� �����ؾ� �� �� ���ٴ� ������ ����...
//	}
//
//	@Override
//	public void init(FilterConfig arg0) throws ServletException {
//		// TODO Auto-generated method stub
//
//	}
//
//}
