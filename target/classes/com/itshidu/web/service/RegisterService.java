package com.itshidu.web.service;

import java.util.Map;

import com.itshidu.web.entity.User;
import com.itshidu.web.vo.Result;

public interface RegisterService {

	Map<String, Object> register(User formUser);
	
	Result login(String username,String password);

	Result active(long userid, String code);
	
}
