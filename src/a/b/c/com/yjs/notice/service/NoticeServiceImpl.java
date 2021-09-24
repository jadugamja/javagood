package a.b.c.com.yjs.notice.service;

import java.util.ArrayList;

import a.b.c.com.yjs.book.vo.BookVO;
import a.b.c.com.yjs.book.dao.BookDAO;
import a.b.c.com.yjs.book.dao.BookDAOImpl;

public class NoticeServiceImpl implements NoticeService {

	// ��ü ��ȸ
	@Override
	public ArrayList<BookVO> bookSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("BookServiceImpl.bookSelectAll() >>> : ");
		
		BookDAO bdao = new BookDAOImpl();		
		return bdao.bookSelectAll();
		
	} // end of bookSelectAll()

	// ���� ��ȸ
	@Override
	public ArrayList<BookVO> bookSelect(BookVO bvo) {
		// TODO Auto-generated method stub	
		System.out.println("BookServiceImpl.bookSelect(bvo) >>> : ");
		
		BookDAO bdao = new BookDAOImpl();				
		return bdao.bookSelect(bvo);
		
	} // end of bookSelect(bvo)

	// ���� ���� ���
	@Override
	public int bookInsert(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookServiceImpl.bookInsert(bvo) >>> : ");
		
		BookDAO bdao = new BookDAOImpl();
		return bdao.bookInsert(bvo);

	} // end of bookInsert(bvo)
	
	// ���� ���� ����
	@Override
	public int bookUpdate(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookServiceImpl.bookUpdate(bvo) >>> : ");
		
		BookDAO bdao = new BookDAOImpl(); 
		return bdao.bookUpdate(bvo);

	} // end of bookUpdate(bvo)

	// ���� ���� ����
	@Override
	public int bookDelete(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookServiceImpl.bookDelete(bvo) >>> : ");
		
		BookDAO bdao = new BookDAOImpl();
		return bdao.bookDelete(bvo);

	} // end of bookDelete()

} // END OF BookServiceImpl
