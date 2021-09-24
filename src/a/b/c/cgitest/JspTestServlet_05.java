package a.b.c.cgitest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JspTestServlet_05
 */
@WebServlet("/methods")
public class JspTestServlet_05 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Servlet</title></head><body>");
		out.println("<body><head></head>");

		String remoteAddr = request.getRemoteAddr();
		out.println("remoteAddr >>> : " + remoteAddr + "<br>");
		System.out.println("remoteAddr >>> : " + remoteAddr);

		String protocol = request.getProtocol();
		out.println("protocol >>> : " + protocol + "<br>");
		
		String method = request.getMethod();
		out.println("method >>> : " + method + "<br>");
		
		String uri = request.getRequestURI();
		out.println("uri >>> : " + uri + "<br>");
		
		String url = request.getRequestURL().toString();
		out.println("url >>> : " + url + "<br>");
		
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
