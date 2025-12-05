package com.demo.service;

import com.demo.beans.MyUser;

public interface LoginService {

	MyUser validateuser(String uname, String pass);

}
