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
		out.println("<h3>LocationServlet :: ������ �̵� �׽�Ʈ</h3>");
		out.println("<hr>");
		
		String isudtype = req.getParameter("isudtype");
		String empno = req.getParameter("empno");
		String ename = req.getParameter("ename");
		
		if (isudtype !=null && isudtype.length() > 0){
			isudtype = isudtype.toUpperCase();
			
			if ("SALL".equals(isudtype)){
				
				out.println("��ü��ȸ isudtype >>> : " + isudtype);
				
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
					out.println("������ >>> : " + e.getMessage());
				}
				
				if (aList !=null && aList.size() > 0){
					
					// dispatcher.jsp �� ������ ArrayList ��ü ����
					req.setAttribute("aList", aList);
					
					/*
					 	WebContent ���丮�� ���Ե� ��δ�! Dynamic Web Project build framework���� ���� ���� ���~
					 
					 	RequestDispatcher���� ����ϴ� getRequestDispatcher()��
					 	��context(������Ʈ��/�۾� ���丮/������) ������� �ʴ´�!��
					 	���� ������ �����ּ� 
					 */			
					RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispatcher.jsp");
					rd.forward(req, res);
				}
				else{
					out.println("<script>");
					out.println("alert('������ ��ȸ ����')");
					out.println("location.href='/testYjs/location'");
					out.println("</script>");
				}				
			
			}	
			if ("S".equals(isudtype)){
				out.println("������ȸ isudtype >>> : " + isudtype);				
				out.println("<h3>������ȸ ���� ��</h3><br>");

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
					System.out.println("���� >>> : " + e.getMessage());
				}
				
				if (1 == nCnt){					
					// dispatcherS.jsp �� ������ ArrayList ��ü ����
					req.setAttribute("nCnt", new Integer(nCnt));
					// RequestDispatcher �������̽� ���� ����ϴ� getRequestDispatcher �Լ������� 
					// Context ��θ� �������  ����
					RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispatcherSelect.jsp");
					rd.forward(req, res);								
				}
				else{
					out.println("<script>");
					out.println("alert('������ ��ȸ ����')");
					out.println("location.href='/testYjs/cgiTest/dispatcher.html'");
					out.println("</script>");
				}			
			}
			
		}
		else{
			out.println("isudtype�� �� ��������!!!! ");
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
