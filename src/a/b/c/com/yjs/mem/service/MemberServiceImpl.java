package a.b.c.com.yjs.mem.service;

import java.util.ArrayList;

import a.b.c.com.yjs.mem.vo.MemberVO;
import a.b.c.com.yjs.mem.dao.MemberDAO;
import a.b.c.com.yjs.mem.dao.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {

	// ��ü ��ȸ
	@Override
	public ArrayList<MemberVO> memberSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl.memberSelectAll() ���� >>> : ");		
		
		MemberDAO mdao = new MemberDAOImpl();
		return mdao.memberSelectAll();	
	} // end of memberSelectAll()

	// ���� ��ȸ
	@Override
	public ArrayList<MemberVO> memberSelect(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl.memberSelect(mvo) ���� >>> : ");		
		
		MemberDAO mdao = new MemberDAOImpl();
		return mdao.memberSelect(mvo);	
	} // end of memberSelect(mvo)

	// ȸ�� ���� ���
	@Override
	public boolean memberInsert(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl.memberInsert(mvo) ���� >>> : ");		
		
		MemberDAO mdao = new MemberDAOImpl();
		return mdao.memberInsert(mvo);	
	} // end of memberInsert(mvo)

	// ȸ�� ���� ����
	@Override
	public boolean memberUpdate(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl.memberUpdate(mvo) ���� >>> : ");		
		
		MemberDAO mdao = new MemberDAOImpl();
		return mdao.memberUpdate(mvo);	
	} // end of memberUpdate(mvo)

	// ȸ�� ���� ����
	@Override
	public boolean memberDelete(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl.memberDelete(mvo) ���� >>> : ");		
		
		MemberDAO mdao = new MemberDAOImpl();
		return mdao.memberDelete(mvo);	
	} // end of memberDelete(mvo)

}
