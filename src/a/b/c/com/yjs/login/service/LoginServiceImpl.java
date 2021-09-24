package a.b.c.com.yjs.login.service;

import a.b.c.com.yjs.mem.vo.MemberVO;
import a.b.c.com.yjs.login.dao.LoginDAO;
import a.b.c.com.yjs.login.dao.LoginDAOImpl;

public class LoginServiceImpl implements LoginService {

	@Override
	public int loginCheckCnt(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("LoginServiceImpl loginCheckCnt() 함수 진입 >>> : ");		
		
		LoginDAO ldao = new LoginDAOImpl();
		return ldao.loginCheckCnt(mvo);

	}

}
