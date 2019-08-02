package com.itshidu.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.itshidu.web.dao.ArticleDao;
import com.itshidu.web.dao.CommentDao;
import com.itshidu.web.dao.FollowDao;
import com.itshidu.web.dao.NotifyDao;
import com.itshidu.web.entity.Follow;
import com.itshidu.web.entity.Notify;
import com.itshidu.web.entity.User;
import com.itshidu.web.service.HomeService;
import com.itshidu.web.util.LoginUtil;
import com.itshidu.web.vo.UserVO;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired FollowDao followDao;
	@Autowired ArticleDao articleDao;
	@Autowired CommentDao commentDao;
	@Autowired NotifyDao notifyDao;
	
	@Override
	public void follows(Integer page, ModelAndView mv) {
		User loginUser = LoginUtil.getLoginUser();
		Pageable pageable = PageRequest.of(page-1, 20);
		Page<Follow> data = followDao.findFollows(loginUser.getId(), pageable);
		List<UserVO> list = new ArrayList();
		for(Follow fo : data.getContent()) {
			User user = fo.getTarget();
			UserVO vo = new UserVO();
			BeanUtils.copyProperties(user, vo);
			//该用户发表的文章数
			int articleCount = articleDao.countByUser(user.getId());
			int commentCount = commentDao.countByUser(user.getId());
			vo.setArticleCount(articleCount);
			vo.setCommentCount(commentCount);
			list.add(vo);
		}
		mv.addObject("data", data); //分页数据
		mv.addObject("voList", list); //userVO列表
		
	}

	@Override
	public void fans(Integer page, ModelAndView mv) {
		User loginUser = LoginUtil.getLoginUser();
		Pageable pageable = PageRequest.of(page-1, 20);
		Page<Follow> data = followDao.findFans(loginUser.getId(), pageable);
		List<UserVO> list = new ArrayList();
		for(Follow fo : data.getContent()) {
			User user = fo.getSource(); //粉丝
			UserVO vo = new UserVO();
			BeanUtils.copyProperties(user, vo);
			//该用户发表的文章数
			int articleCount = articleDao.countByUser(user.getId());
			int commentCount = commentDao.countByUser(user.getId());
			vo.setArticleCount(articleCount);
			vo.setCommentCount(commentCount);
			list.add(vo);
		}
		mv.addObject("data", data); //分页数据
		mv.addObject("voList", list); //userVO列表
	}

	@Override
	public void notifies(Integer page, ModelAndView mv) {
		User loginUser = LoginUtil.getLoginUser();
		Pageable pageable = PageRequest.of(page-1, 20);
		Page<Notify> data=notifyDao.findByUser(loginUser.getId(), pageable);
		mv.addObject("data", data);
	}

}
