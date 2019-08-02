package com.itshidu.web.service;

import org.springframework.web.servlet.ModelAndView;

import com.itshidu.web.vo.Result;

/**
 * 与登录相关的接口
 * @author Master.Xia
 */
public interface LoginService {

	void qqLogin(String code, String state,ModelAndView mav)throws Exception;
	
	Result bindUser(String username,String password);

	Result bindCreate(String username, String password);
}
