package com.service;

import com.bean.MyUser;
import com.dao.LoginDao;
import com.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService{
	private LoginDao ldao;

	public LoginServiceImpl() {
	ldao=new LoginDaoImpl();
	}

	@Override
	public MyUser validateUser(String uname, String upass) {
	
		return ldao.checkUser(uname,upass);
	}
	

}
