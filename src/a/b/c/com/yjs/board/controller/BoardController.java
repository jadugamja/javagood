package a.b.c.com.yjs.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

import a.b.c.com.common.CommonUtils;
import a.b.c.com.common.GetChabun;
import a.b.c.com.yjs.board.service.BoardService;
import a.b.c.com.yjs.board.service.BoardServiceImpl;
import a.b.c.com.yjs.board.vo.BoardVO;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();

		String isud_Type = request.getParameter("ISUD_TYPE");
		
		if(isud_Type != null && isud_Type.length() > 0){
			isud_Type = isud_Type.toUpperCase();
			
			// �Խñ� ���
			if("I".equals(isud_Type)){
				System.out.println("�Խ��� �� ��� :: isud_Type >>> : " + isud_Type);

				String saveDirectory = CommonUtils.BOARD_IMG_UPLOAD_PATH;
                int maxPostSize = CommonUtils.BOARD_IMG_FILE_SIZE;
                String  encoding = CommonUtils.BOOK_IMG_ENCODE;
				
				// enctype(multipart/form-data) check!! (�� Ȯ��?? spells?)
				boolean bool = request.getContentType().toLowerCase().startsWith("multipart/form-data");				

				if (bool){
					System.out.println("�Խ��� �� ��� ���� ���ε� ��ƾ :: bool >>> : " + bool);
					
					try {
						MultipartRequest mr = new MultipartRequest(  request  
													                ,saveDirectory
													                ,maxPostSize
													                ,encoding
													                ,new DefaultFileRenamePolicy());
						
						String bsubject = mr.getParameter("bsubject");
						String bwriter = mr.getParameter("bwriter");
						String bcontents = mr.getParameter("bcontents");
						String bpw = mr.getParameter("bpw");
						
						// ����
						// String bphoto = mr.getParameter("bsubject");
						@SuppressWarnings("unchecked")
						Enumeration<String> e = mr.getFileNames();
						String imgName = e.nextElement();
						String bphoto = mr.getFilesystemName(imgName);
						
						System.out.println("bsubject >>> : " + bsubject);
						System.out.println("bwriter >>> : " + bwriter);
						System.out.println("bcontents >>> : " + bcontents);
						System.out.println("bpw >>> : " + bpw);
						System.out.println("bphoto >>> : " + bphoto);
						
						// ���� ȣ���ϱ� (>DAOImpl())
						BoardService bs = new BoardServiceImpl();
						BoardVO bvo = null;
						bvo = new BoardVO();
						
						String bnum = GetChabun.getBoardChabun("BD202109010001");
						System.out.println(bnum);
						bvo.setBsubject(bsubject);
						bvo.setBwriter(bwriter);
						bvo.setBpw(bpw);
						bvo.setBcontents(bcontents);
						bvo.setBphoto(bphoto);
						
						boolean bInsert = bs.boardInsert(bvo);
						
						if (bInsert){						
							request.setAttribute("bInsert", new Boolean(bInsert));				
							// RequestDispatcher �������̽� ���� ����ϴ� getRequestDispatcher �Լ������� 
							// Context ��θ� �����������								
							RequestDispatcher rd = request.getRequestDispatcher("/yjs_jsp/board/boardInsert.jsp");
							// "/yjs_jsp/board/boardInsert.sjp"�� request�� response ��ü ����!
							rd.forward(request, response);						
						}
						else{
							out.println("<script>");				
							out.println("location.href='/testYjs/board/board.html'");
							out.println("</script>");
						}
						
					}
					catch(Exception e){
						System.out.println("�Խñ� ��� �� ������ >>> :" + e.getMessage());
					}
				}
			} // end of "I"
			
			// �Խñ� ��ü ��ȸ
			if ("SALL".equals(isud_Type)){
				System.out.println("�Խ��� �� ��ü ��ȸ isud_Type >>> : " + isud_Type);
				
				// ���� ȣ���ϱ� 
				BoardService bs = new BoardServiceImpl();
				ArrayList<BoardVO> aListAll = bs.boardSelectAll();
				
				if (aListAll !=null && aListAll.size() > 0) {
					
					request.setAttribute("aListAll", aListAll);					
					RequestDispatcher rd= request.getRequestDispatcher("/yjs_jsp/board/boardSelectAll.jsp");
					rd.forward(request, response);
					
				}
				else {
					out.println("<script>");					
					out.println("location.href='/testYjs/board?ISUD_TYPE=SALL'");
					out.println("</script>");
				}		
			} // end of "Sall"
			
			// �Խñ� ���� ��ȸ S
			if ("S".equals(isud_Type) || "U".equals(isud_Type) || "D".equals(isud_Type)){
				System.out.println("�� ������ȸ : S U D isudType >>> : " + isud_Type);

				String bnum = request.getParameter("bnumCheck");				
				if (bnum !=null && bnum.length() > 0){
					System.out.println("�� ��ȣ >>> :  " + bnum);
					
					BoardService bs = new BoardServiceImpl();				
					BoardVO bvo = null;
					bvo = new BoardVO();
					
					bvo.setBnum(bnum);					
					ArrayList<BoardVO> aListS = bs.boardSelect(bvo);
					
					if (aListS !=null && aListS.size() > 0) {
						System.out.println("aListS.size() >>> : " + aListS.size());						
						request.setAttribute("aListS", aListS);					
						RequestDispatcher rd= request.getRequestDispatcher("/yjs_jsp/board/boardSelect.jsp");
						rd.forward(request, response);
						
					}
					else {
						out.println("<script>");
						out.println("alert('�� ��ȸ ����')");
						out.println("location.href='/testYjs/board?ISUD_TYPE=S'");
						out.println("</script>");
					}									
				}
				else{
					System.out.println("�� ��ȣ��  �����ϴ�. ");
				}		
			} // end of "S"
			
			// �Խñ� ����
			if ("UOK".equals(isud_Type)){
				System.out.println("�� ���� isudType >>> : " + isud_Type);
				
				String bnum = request.getParameter("bnum");
				String bsubject = request.getParameter("bsubject");
				String bcontents = request.getParameter("bcontents");				
				System.out.println("bnum >>> : " + bnum);
				System.out.println("bsubject >>> : " + bsubject);
				System.out.println("bcontents >>> : " + bcontents);
				
				BoardService bs = new BoardServiceImpl();				
				BoardVO bvo = null;
				bvo = new BoardVO();
				
				bvo.setBnum(bnum);
				bvo.setBsubject(bsubject);
				bvo.setBcontents(bcontents);
				
				boolean bUpdate = bs.boardUpdate(bvo);
				
				if (bUpdate) {
					System.out.println("�� ������  ���� �Ǿ����ϴ�." + bUpdate);					
					request.setAttribute("bUpdate", new Boolean(bUpdate));										
					RequestDispatcher rd= request.getRequestDispatcher("/yjs_jsp/board/boardUpdate.jsp");
					rd.forward(request, response);
					
				}
				else {
					System.out.println("�� ���� ���� !!!!");
					out.println("<script>");	
					out.println("alert('�� ���� ����')");
					out.println("location.href='/testYjs/board?isudtype=U'");
					out.println("</script>");
				}
			} // end of "U"
			
			// �Խñ� ����
			if ("DOK".equals(isud_Type)){
				System.out.println("�� ���� isud_Type >>> : " + isud_Type);
				
				String bnum = request.getParameter("bnum");
				System.out.println("bnum >>> : " + bnum);
				
				BoardService bs = new BoardServiceImpl();				
				BoardVO bvo = null;
				bvo = new BoardVO();
				
				bvo.setBnum(bnum);

				boolean bDelete = bs.boardDelete(bvo);
				
				if (bDelete) {
					System.out.println("�� ������  ���� �Ǿ����ϴ�." + bDelete);					
					request.setAttribute("bDelete", new Boolean(bDelete));										
					RequestDispatcher rd= request.getRequestDispatcher("/yjs_jsp/board/boardDelete.jsp");
					rd.forward(request, response);
					
				}
				else {
					System.out.println("�� ���� ���� !!!!");
					out.println("<script>");			
					out.println("alert('�� ���� ����')");
					out.println("location.href='/testYjs/board?isudtype=D'");
					out.println("</script>");
				}
			} // end of "D"
			
		} // end of if() Sentence
		else{
			System.out.println("<form>���� hidden Ÿ�� ISUD_TYPE �� �ѱ⼼��!");
		}

	} // end of doGet()


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	} // end of doPost()

} // END OF BoardController
