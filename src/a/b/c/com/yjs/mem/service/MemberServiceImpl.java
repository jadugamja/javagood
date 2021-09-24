package a.b.c.com.yjs.mem.service;

import java.util.ArrayList;

import a.b.c.com.yjs.mem.vo.MemberVO;
import a.b.c.com.yjs.mem.dao.MemberDAO;
import a.b.c.com.yjs.mem.dao.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {

	// 전체 조회
	@Override
	public ArrayList<MemberVO> memberSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl.memberSelectAll() 진입 >>> : ");		
		
		MemberDAO mdao = new MemberDAOImpl();
		return mdao.memberSelectAll();	
	} // end of memberSelectAll()

	// 조건 조회
	@Override
	public ArrayList<MemberVO> memberSelect(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl.memberSelect(mvo) 진입 >>> : ");		
		
		MemberDAO mdao = new MemberDAOImpl();
		return mdao.memberSelect(mvo);	
	} // end of memberSelect(mvo)

	// 회원 정보 등록
	@Override
	public boolean memberInsert(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl.memberInsert(mvo) 진입 >>> : ");		
		
		MemberDAO mdao = new MemberDAOImpl();
		return mdao.memberInsert(mvo);	
	} // end of memberInsert(mvo)

	// 회원 정보 수정
	@Override
	public boolean memberUpdate(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl.memberUpdate(mvo) 진입 >>> : ");		
		
		MemberDAO mdao = new MemberDAOImpl();
		return mdao.memberUpdate(mvo);	
	} // end of memberUpdate(mvo)

	// 회원 정보 삭제
	@Override
	public boolean memberDelete(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl.memberDelete(mvo) 진입 >>> : ");		
		
		MemberDAO mdao = new MemberDAOImpl();
		return mdao.memberDelete(mvo);	
	} // end of memberDelete(mvo)

}
