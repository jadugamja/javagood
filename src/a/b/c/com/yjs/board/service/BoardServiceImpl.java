package a.b.c.com.yjs.board.service;

import java.util.ArrayList;

import a.b.c.com.yjs.board.vo.BoardVO;
import a.b.c.com.yjs.board.dao.BoardDAO;
import a.b.c.com.yjs.board.dao.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {

	@Override
	public ArrayList<BoardVO> boardSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BoardVO> boardSelect(BoardVO bvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean boardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardServiceImpl.boardInsert() starts >>> : ");
		
		BoardDAO bdao = new BoardDAOImpl();
		
		return bdao.boardInsert(bvo);
	} // end of boardInsert()

	@Override
	public boolean boardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean boardDelete(BoardVO bvo) {
		// TODO Auto-generated method stub
		return false;
	}

}
