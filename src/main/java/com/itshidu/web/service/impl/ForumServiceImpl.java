package com.itshidu.web.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.itshidu.web.dao.ArticleDao;
import com.itshidu.web.dao.CommentDao;
import com.itshidu.web.dao.FavorDao;
import com.itshidu.web.entity.Article;
import com.itshidu.web.service.ForumService;
import com.itshidu.web.util.EhcacheUtil;
import com.itshidu.web.vo.ArticleVO;
import com.itshidu.web.vo.Result;

@Service
public class ForumServiceImpl implements ForumService {
	
	@Autowired ArticleDao articleDao;
	@Autowired CommentDao commentDao;
	@Autowired FavorDao favorDao;

	@Override
	public void findForumArticles(String forumCode,String sortType,int page,ModelAndView mv) {

		Sort sort=null;
		if(sortType==null||sortType.trim().length()==0) {
			sort = new Sort(Direction.DESC, "createTime");
		}else if("newest".equals(sortType)) {
			sort = new Sort(Direction.DESC, "createTime");
		}else if("hottest".equals(sortType)) {
			sort = new Sort(Direction.DESC, "hits");
		}
		Pageable pageable = PageRequest.of(page-1,7, sort);
		Page<Article> data=articleDao.findByForumCode(forumCode,pageable);
		
		mv.addObject("pageInfo", data); //主要目的：将分页信息传到页面，虽然也有文章信息但我不用

		List<ArticleVO> list = new ArrayList();//主要目的：文章信息，带有喜欢数和评论数
		//查询每个文章的评论数和喜欢数
		for(int i=0;i<data.getContent().size();i++) {
			Article a = data.getContent().get(i);
			ArticleVO v = new ArticleVO();
			BeanUtils.copyProperties(a, v);
			list.add(v);
			
			//查询评论数，设置10秒缓存
			String key = "wzpl_"+a.getId();
			Integer count = EhcacheUtil.get("mytest", key);
			if(count==null) {
				count=commentDao.countByArticleId(a.getId());//查询文章的评论数
				EhcacheUtil.put("mytest", key, count,10,10);
			}
			v.setPinglun(count);
			//查询喜欢数，设置10秒缓存
			String key2 = "wzxh_"+a.getId();
			Integer favorCount = EhcacheUtil.get("mytest", key2);
			if(favorCount==null) {
				favorCount = favorDao.countByArticle(a.getId());
				EhcacheUtil.put("mytest", key2, favorCount,10,10);
			}	
			v.setXihuan(favorCount);
			
		}
		mv.addObject("articleList", list);

	}

}
