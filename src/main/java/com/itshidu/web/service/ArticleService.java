package com.itshidu.web.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.itshidu.web.entity.Article;
import com.itshidu.web.vo.Result;

public interface ArticleService {
	Result save(String title,long group,String content,HttpServletRequest request);

	void view(long articleId,ModelAndView modelAndview);
	
	Article getArticleById(long articleId);
}
