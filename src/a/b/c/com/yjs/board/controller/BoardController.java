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
			
			// 게시글 등록
			if("I".equals(isud_Type)){
				System.out.println("게시판 글 등록 :: isud_Type >>> : " + isud_Type);

				String saveDirectory = CommonUtils.BOARD_IMG_UPLOAD_PATH;
                int maxPostSize = CommonUtils.BOARD_IMG_FILE_SIZE;
                String  encoding = CommonUtils.BOOK_IMG_ENCODE;
				
				// enctype(multipart/form-data) check!! (뭘 확인?? spells?)
				boolean bool = request.getContentType().toLowerCase().startsWith("multipart/form-data");				

				if (bool){
					System.out.println("게시판 글 등록 파일 업로드 루틴 :: bool >>> : " + bool);
					
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
						
						// 사진
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
						
						// 서비스 호출하기 (>DAOImpl())
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
							// RequestDispatcher 인터페이스 에서 사용하는 getRequestDispatcher 함수에서는 
							// Context 경로를 사용하지않음								
							RequestDispatcher rd = request.getRequestDispatcher("/yjs_jsp/board/boardInsert.jsp");
							// "/yjs_jsp/board/boardInsert.sjp"로 request와 response 객체 전송!
							rd.forward(request, response);						
						}
						else{
							out.println("<script>");				
							out.println("location.href='/testYjs/board/board.html'");
							out.println("</script>");
						}
						
					}
					catch(Exception e){
						System.out.println("게시글 등록 중 에러가 >>> :" + e.getMessage());
					}
				}
			} // end of "I"
			
			// 게시글 전체 조회
			if ("SALL".equals(isud_Type)){
				System.out.println("게시판 글 전체 조회 isud_Type >>> : " + isud_Type);
				
				// 서비스 호출하기 
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
			
			// 게시글 조건 조회 S
			if ("S".equals(isud_Type) || "U".equals(isud_Type) || "D".equals(isud_Type)){
				System.out.println("글 조건조회 : S U D isudType >>> : " + isud_Type);

				String bnum = request.getParameter("bnumCheck");				
				if (bnum !=null && bnum.length() > 0){
					System.out.println("글 번호 >>> :  " + bnum);
					
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
						out.println("alert('글 조회 실패')");
						out.println("location.href='/testYjs/board?ISUD_TYPE=S'");
						out.println("</script>");
					}									
				}
				else{
					System.out.println("글 번호가  없습니다. ");
				}		
			} // end of "S"
			
			// 게시글 수정
			if ("UOK".equals(isud_Type)){
				System.out.println("글 수정 isudType >>> : " + isud_Type);
				
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
					System.out.println("글 정보가  수정 되었습니다." + bUpdate);					
					request.setAttribute("bUpdate", new Boolean(bUpdate));										
					RequestDispatcher rd= request.getRequestDispatcher("/yjs_jsp/board/boardUpdate.jsp");
					rd.forward(request, response);
					
				}
				else {
					System.out.println("글 수정 실패 !!!!");
					out.println("<script>");	
					out.println("alert('글 수정 실패')");
					out.println("location.href='/testYjs/board?isudtype=U'");
					out.println("</script>");
				}
			} // end of "U"
			
			// 게시글 삭제
			if ("DOK".equals(isud_Type)){
				System.out.println("글 삭제 isud_Type >>> : " + isud_Type);
				
				String bnum = request.getParameter("bnum");
				System.out.println("bnum >>> : " + bnum);
				
				BoardService bs = new BoardServiceImpl();				
				BoardVO bvo = null;
				bvo = new BoardVO();
				
				bvo.setBnum(bnum);

				boolean bDelete = bs.boardDelete(bvo);
				
				if (bDelete) {
					System.out.println("글 정보가  삭제 되었습니다." + bDelete);					
					request.setAttribute("bDelete", new Boolean(bDelete));										
					RequestDispatcher rd= request.getRequestDispatcher("/yjs_jsp/board/boardDelete.jsp");
					rd.forward(request, response);
					
				}
				else {
					System.out.println("글 삭제 실패 !!!!");
					out.println("<script>");			
					out.println("alert('글 수정 실패')");
					out.println("location.href='/testYjs/board?isudtype=D'");
					out.println("</script>");
				}
			} // end of "D"
			
		} // end of if() Sentence
		else{
			System.out.println("<form>에서 hidden 타입 ISUD_TYPE 잘 넘기세요!");
		}

	} // end of doGet()


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	} // end of doPost()

} // END OF BoardController
