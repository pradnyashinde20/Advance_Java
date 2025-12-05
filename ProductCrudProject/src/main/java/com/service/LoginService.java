package com.service;

import com.bean.MyUser;

public interface LoginService {

	MyUser validateUser(String uname, String upass);

}
