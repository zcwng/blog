package com.itshidu.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itshidu.web.entity.User;
import com.itshidu.web.service.RegisterService;
import com.itshidu.web.test.QQConnectUtil;

@Controller
public class PublicController {
	
	@Autowired RegisterService _regService;
	
	@RequestMapping("/register.html")
	public Object register(ModelAndView mv) {
		mv.setViewName("register");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/public/register")
	public Object register(User formUser) {
		Map<String, Object> result=_regService.register(formUser);
		return result;
	}
	@RequestMapping("/public/active")
	public Object active(long userid,String code) {
		return _regService.active(userid,code);
	}
	@ResponseBody
	@RequestMapping("/public/login")
	public Object login(String username,String password) {
		return _regService.login(username,password);
	}

	@RequestMapping("/public/logout")
	public Object logout(HttpServletRequest request) {
		//request.getSession().removeAttribute("loginInfo");
		//request.getSession().setMaxInactiveInterval(1); //1秒超时
		request.getSession().invalidate(); //废弃现有session
		return "redirect:/login.html";
	}
	
	
	
	
	
}
