package a.b.c.com.yjs.board.dao;

import java.util.ArrayList;
import a.b.c.com.yjs.board.vo.BoardVO;

public interface BoardDAO {

	public ArrayList<BoardVO> boardSelectAll();
	public ArrayList<BoardVO> boardSelect(BoardVO bvo);
	public boolean boardInsert(BoardVO bvo);
	public boolean boardUpdate(BoardVO bvo);
	public boolean boardDelete(BoardVO bvo);
	
}
