package a.b.c.com.yjs.notice.service;

import java.util.ArrayList;

import a.b.c.com.yjs.book.vo.BookVO;
import a.b.c.com.yjs.book.dao.BookDAO;
import a.b.c.com.yjs.book.dao.BookDAOImpl;

public class NoticeServiceImpl implements NoticeService {

	// 전체 조회
	@Override
	public ArrayList<BookVO> bookSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("BookServiceImpl.bookSelectAll() >>> : ");
		
		BookDAO bdao = new BookDAOImpl();		
		return bdao.bookSelectAll();
		
	} // end of bookSelectAll()

	// 조건 조회
	@Override
	public ArrayList<BookVO> bookSelect(BookVO bvo) {
		// TODO Auto-generated method stub	
		System.out.println("BookServiceImpl.bookSelect(bvo) >>> : ");
		
		BookDAO bdao = new BookDAOImpl();				
		return bdao.bookSelect(bvo);
		
	} // end of bookSelect(bvo)

	// 도서 정보 등록
	@Override
	public int bookInsert(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookServiceImpl.bookInsert(bvo) >>> : ");
		
		BookDAO bdao = new BookDAOImpl();
		return bdao.bookInsert(bvo);

	} // end of bookInsert(bvo)
	
	// 도서 정보 수정
	@Override
	public int bookUpdate(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookServiceImpl.bookUpdate(bvo) >>> : ");
		
		BookDAO bdao = new BookDAOImpl(); 
		return bdao.bookUpdate(bvo);

	} // end of bookUpdate(bvo)

	// 도서 정보 삭제
	@Override
	public int bookDelete(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookServiceImpl.bookDelete(bvo) >>> : ");
		
		BookDAO bdao = new BookDAOImpl();
		return bdao.bookDelete(bvo);

	} // end of bookDelete()

} // END OF BookServiceImpl
