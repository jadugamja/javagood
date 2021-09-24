package a.b.c.com.yjs.notice.service;

import java.util.ArrayList;

import a.b.c.com.yjs.book.vo.BookVO;

public interface NoticeService {

	public ArrayList<BookVO> bookSelectAll();
	public ArrayList<BookVO> bookSelect(BookVO bvo);
	public int bookInsert(BookVO bvo);
	public int bookUpdate(BookVO bvo);
	public int bookDelete(BookVO bvo);
	
}
