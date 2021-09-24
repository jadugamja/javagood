package a.b.c.com.yjs.notice.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import a.b.c.com.yjs.book.vo.BookVO;
import a.b.c.com.yjs.book.sql.BookSqlMap;
import a.b.c.com.common.ConnProperty;

public class NoticeDAOImpl implements NoticeDAO {

	// 전체 조회
	@Override
	public ArrayList<BookVO> bookSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("BookDAOImpl.bookSelectAll() >>> : ");
		
		Connection 			conn = null;
		PreparedStatement 	pstmt = null;
		ResultSet 			rsRs = null;
		ArrayList<BookVO> 	aList = null;
		try {			

			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BookSqlMap.getBookSelectAllQuery());
			System.out.println("전체 조회 >>> : \n"+ BookSqlMap.getBookSelectAllQuery());
  
			rsRs = pstmt.executeQuery();
			
			if (rsRs !=null) {
				aList = new ArrayList<BookVO>();
				
				while (rsRs.next()) {
					
					BookVO _bvo = new BookVO();
					
					_bvo.setBnum(rsRs.getString(1));
					_bvo.setBtitle(rsRs.getString(2));
					_bvo.setBauth(rsRs.getString(3));
					_bvo.setIsbn(rsRs.getString(4));						
					_bvo.setBcomp(rsRs.getString(5));	
					_bvo.setBprice(rsRs.getString(6));	
					_bvo.setBqty(rsRs.getString(7));
					_bvo.setBcover(rsRs.getString(8));
					_bvo.setDeleteyn(rsRs.getString(9));
					_bvo.setInsertdate(rsRs.getString(10));
					_bvo.setUpdatedate(rsRs.getString(11));

					aList.add(_bvo);
				}
			}	
			
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		catch(Exception e) {
			System.out.println("디비연동에 문제가 생겼습니다. >>> : " + e);
		}
		finally {
			try {
				ConnProperty.conClose(conn, pstmt, rsRs);				
			}
			catch(Exception e2) {}
		}
				
		return aList;
	
	} // end of bookSelectAll()

	// 조건 조회
	@Override
	public ArrayList<BookVO> bookSelect(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookDAOImpl.bookSelect(bvo) >>> : ");
		
		Connection		  conn = null;
		PreparedStatement pstmt = null;
		ResultSet		  rsRs = null;
		ArrayList<BookVO> aList = null;
		
		try {			

			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BookSqlMap.getBookSelectQuery());
			System.out.println("조건 조회 >>> : \n"+ BookSqlMap.getBookSelectQuery());
  
			pstmt.setString(1, bvo.getBnum());
			rsRs = pstmt.executeQuery();					
			
			if (rsRs !=null) {
				aList = new ArrayList<BookVO>();
				
				while (rsRs.next()) {
					
					BookVO _bvo = new BookVO();
					
					_bvo.setBnum(rsRs.getString(1));
					_bvo.setBtitle(rsRs.getString(2));
					_bvo.setBauth(rsRs.getString(3));
					_bvo.setIsbn(rsRs.getString(4));						
					_bvo.setBcomp(rsRs.getString(5));	
					_bvo.setBprice(rsRs.getString(6));	
					_bvo.setBqty(rsRs.getString(7));
					_bvo.setBcover(rsRs.getString(8));
					_bvo.setDeleteyn(rsRs.getString(9));
					_bvo.setInsertdate(rsRs.getString(10));
					_bvo.setUpdatedate(rsRs.getString(11));

					aList.add(_bvo);
				}
			}	
			
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		catch(Exception e) {
			System.out.println("디비연동에 문제가 생겼습니다. >>> : " + e);
		}
		finally {
			try {
				ConnProperty.conClose(conn, pstmt, rsRs);				
			}
			catch(Exception e2) {}
		}
				
		return aList;		
	} // end of bookSelect(bvo)

	
	// 도서 정보 등록
	@Override
	public int bookInsert(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookDAOImpl.bookInsert(bvo) >>> : ");

		Connection			conn = null;
		PreparedStatement	pstmt = null;
		int nCnt = 0;
		try {			

			conn = ConnProperty.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			pstmt = conn.prepareStatement(BookSqlMap.getBookInsertQuery());
			System.out.println("입력하기 >>> : \n"+ BookSqlMap.getBookInsertQuery());
  			
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBnum());
			pstmt.setString(2, bvo.getBtitle());
			pstmt.setString(3, bvo.getBauth());
			pstmt.setString(4, bvo.getIsbn());
			pstmt.setString(5, bvo.getBcomp());
			pstmt.setString(6, bvo.getBprice());
			pstmt.setString(7, bvo.getBqty());
			pstmt.setString(8, bvo.getBcover());
			
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();			
			System.out.println("nCnt >>> : " + nCnt + " 건 등록되었음 ");
			
			ConnProperty.conClose(conn, pstmt);
		}
		catch(Exception e) {
			System.out.println("입력 디비연동에 문제가 생겼습니다. >>> : " + e);
		}
		finally {
			try {
				ConnProperty.conClose(conn, pstmt);				
			}
			catch(Exception e2) {}
		}
		
		return nCnt;
		
	} // end of bookInsert(bvo)

	// 도서 정보 수정
	@Override
	public int bookUpdate(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookDAOImpl.booUpdate(bvo) >>> : ");

		Connection			conn = null;
		PreparedStatement	pstmt = null;
		int nCnt = 0;
		
		try {			

			conn = ConnProperty.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			pstmt = conn.prepareStatement(BookSqlMap.getBookUpdateQuery());
			System.out.println("수정하기 >>> : \n"+ BookSqlMap.getBookUpdateQuery());
  			
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBprice());
			pstmt.setString(2, bvo.getBqty());
			pstmt.setString(3, bvo.getBnum());			
			
			nCnt = pstmt.executeUpdate();			
			if (!conn.getAutoCommit()) conn.commit();			
			System.out.println("nCnt >>> : " + nCnt + " 건 수정되었음 ");
			
			ConnProperty.conClose(conn, pstmt);
		}
		catch(Exception e) {
			System.out.println("수정 디비연동에 문제가 생겼습니다. >>> : " + e);
		}
		finally {
			try {
				ConnProperty.conClose(conn, pstmt);				
			}
			catch(Exception e2) {}
		}
		
		return nCnt;
		
	} // end of bookUpdate(bvo)

	// 도서 정보 삭제
	@Override
	public int bookDelete(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookDAOImpl.bookDelete(bvo) >>> : ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try {			

			conn = ConnProperty.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			pstmt = conn.prepareStatement(BookSqlMap.getBookDeleteQuery());
			System.out.println("삭제하기 >>> : \n"+ BookSqlMap.getBookDeleteQuery());
  			
			pstmt.clearParameters();		
			pstmt.setString(1, bvo.getBnum());			
			
			nCnt = pstmt.executeUpdate();			
			if (!conn.getAutoCommit()) conn.commit();			
			System.out.println("nCnt >>> : " + nCnt + " 건 삭제되었음 ");
			
			ConnProperty.conClose(conn, pstmt);
		}
		catch(Exception e) {
			System.out.println("삭제 디비연동에 문제가 생겼습니다. >>> : " + e);
		}
		finally {
			try {
				ConnProperty.conClose(conn, pstmt);				
			}
			catch(Exception e2) {}
		}
		
		return nCnt;
		
	} // end of bookDelete(bvo)

} // END OF BookDAOImpl
