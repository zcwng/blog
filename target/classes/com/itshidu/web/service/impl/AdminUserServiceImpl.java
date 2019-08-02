package com.itshidu.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.itshidu.web.dao.UserDao;
import com.itshidu.web.entity.User;
import com.itshidu.web.service.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired UserDao userDao;
	
	@Override
	public void list(ModelAndView mav, int pn, String key) {
		Pageable pageable=PageRequest.of(pn-1,10);
		Page<User> data=userDao.findByUsernameLike("%"+key+"%",pageable);
		mav.addObject("data", data);
		//data.isLast()
		//data.hasNext()
	}
	
}
