package a.b.c.cgitest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import a.b.c.cgitest.EmpVO;

/**
 * Servlet implementation class LocationServlet
 */
@WebServlet("/location")
public class LocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("EUC-KR");
		res.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = res.getWriter();
		
		// html tag start
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("<h3>LocationServlet :: 페이지 이동 테스트</h3>");
		out.println("<hr>");
		
		String isudtype = req.getParameter("isudtype");
		String empno = req.getParameter("empno");
		String ename = req.getParameter("ename");
		
		if (isudtype !=null && isudtype.length() > 0){
			isudtype = isudtype.toUpperCase();
			
			if ("SALL".equals(isudtype)){
				
				out.println("전체조회 isudtype >>> : " + isudtype);
				
				ArrayList<EmpVO> aList = null;
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclJSY", "scott","tiger");
					Statement stmt = conn.createStatement();
					ResultSet rts = stmt.executeQuery("SELECT * FROM EMP");
					aList = new ArrayList<EmpVO>();
					while (rts.next()){
						EmpVO evo = new EmpVO();
						evo.setEmpno(rts.getString(1));
						evo.setEname(rts.getString(2));
						evo.setJob(rts.getString(3));
						evo.setMgr(rts.getString(4));
						evo.setHiredate(rts.getString(5));
						evo.setSal(rts.getString(6));
						evo.setComm(rts.getString(7));
						evo.setDeptno(rts.getString(8));
						
						aList.add(evo);
						
					}
					//aList = null;
				} 
				catch (Exception e) {
					// e.printStackTrace();
					out.println("에러가 >>> : " + e.getMessage());
				}
				
				if (aList !=null && aList.size() > 0){
					
					// dispatcher.jsp 로 보내는 ArrayList 객체 세팅
					req.setAttribute("aList", aList);
					
					/*
					 	WebContent 디렉토리가 포함된 경로는! Dynamic Web Project build framework에서 쓰는 가상 경로~
					 
					 	RequestDispatcher에서 사용하는 getRequestDispatcher()는
					 	★context(프로젝트명/작업 디렉토리/도메인) 사용하지 않는다!★
					 	상위 폴더만 적어주셈 
					 */			
					RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispatcher.jsp");
					rd.forward(req, res);
				}
				else{
					out.println("<script>");
					out.println("alert('데이터 조회 실패')");
					out.println("location.href='/testYjs/location'");
					out.println("</script>");
				}				
			
			}	
			if ("S".equals(isudtype)){
				out.println("조건조회 isudtype >>> : " + isudtype);				
				out.println("<h3>조건조회 실행 블럭</h3><br>");

				int nCnt = 0;
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclJSY", "scott","tiger");
					Statement stmt = conn.createStatement();
					ResultSet rsRs = stmt.executeQuery("SELECT COUNT(EMPNO) NCNT FROM EMP WHERE EMPNO = " + empno + " AND ENAME = " + "'" + ename + "'");
					while (rsRs.next()){
						nCnt = rsRs.getInt(1);					
					}
				}
				catch (Exception e) {
					System.out.println("에러 >>> : " + e.getMessage());
				}
				
				if (1 == nCnt){					
					// dispatcherS.jsp 로 보내는 ArrayList 객체 세팅
					req.setAttribute("nCnt", new Integer(nCnt));
					// RequestDispatcher 인터페이스 에서 사용하는 getRequestDispatcher 함수에서는 
					// Context 경로를 사용하지  않음
					RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispatcherSelect.jsp");
					rd.forward(req, res);								
				}
				else{
					out.println("<script>");
					out.println("alert('데이터 조회 실패')");
					out.println("location.href='/testYjs/cgiTest/dispatcher.html'");
					out.println("</script>");
				}			
			}
			
		}
		else{
			out.println("isudtype을 잘 보내세요!!!! ");
		}
		
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
