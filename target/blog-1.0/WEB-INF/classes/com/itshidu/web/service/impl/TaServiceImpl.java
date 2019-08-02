package com.itshidu.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.itshidu.web.dao.ArticleDao;
import com.itshidu.web.dao.UserDao;
import com.itshidu.web.entity.Article;
import com.itshidu.web.entity.User;
import com.itshidu.web.service.TaService;
import com.itshidu.web.vo.Result;

@Service
public class TaServiceImpl implements TaService{

	@Autowired UserDao userDao;
	@Autowired ArticleDao articleDao;
	
	@Override
	public void findData(long userId, int page,ModelAndView mav) {
		
		User user = userDao.getOne(userId);
		mav.addObject("user", user);
		
		Sort sort=new Sort(Direction.DESC, "createTime");
		Pageable pageable = PageRequest.of(page, 10, sort);
		Page<Article> data=articleDao.findByUserId(userId, pageable);
		mav.addObject("data",data);
		
	}

}
