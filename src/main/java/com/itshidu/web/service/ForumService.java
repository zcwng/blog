package com.itshidu.web.service;
/**
 * 版块业务
 * @author Master.Xia
 */

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.servlet.ModelAndView;

import com.itshidu.web.entity.Article;
import com.itshidu.web.vo.Result;

public interface ForumService {
	
	void findForumArticles(String forumCode,String sortType,int page,ModelAndView mv);

}
