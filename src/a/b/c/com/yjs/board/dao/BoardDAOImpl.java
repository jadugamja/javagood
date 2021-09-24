package a.b.c.com.yjs.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import a.b.c.com.common.ConnProperty;
import a.b.c.com.yjs.board.vo.BoardVO;
import a.b.c.com.yjs.board.sql.BoardSqlMap;

public class BoardDAOImpl implements BoardDAO {

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

	// 게시글 등록!
	@Override
	public boolean boardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardDAOImpl.boardInsert() go >>> :");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardInsertQuery());
			System.out.println("등록 :: \n" + BoardSqlMap.getBoardInsertQuery());

			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBnum());
			pstmt.setString(2, bvo.getBsubject());
			pstmt.setString(3, bvo.getBwriter());
			pstmt.setString(4, bvo.getBcontents());
			pstmt.setString(5, bvo.getBpw());
			pstmt.setString(6, bvo.getBphoto());

			nCnt = pstmt.executeUpdate();
			if(!conn.getAutoCommit()) conn.commit();
			System.out.println("nCnt >>> : " + nCnt + "건 등록됨!");
			
			if(nCnt > 0) bool = true;
			
			ConnProperty.conClose(conn, pstmt);
		}
		catch(Exception e){
			System.out.println("insert DB error >>> : " +e.getMessage());
			System.out.println("error >>> : " + e);
		}
		finally{
			ConnProperty.conClose(conn, pstmt);
		}
		
		return bool;
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
