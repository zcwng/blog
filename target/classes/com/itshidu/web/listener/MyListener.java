package com.itshidu.web.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;

import com.itshidu.web.dao.ForumDao;
import com.itshidu.web.entity.Forum;
import com.itshidu.web.util.SpringContext;

@WebListener
public class MyListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ApplicationContext ctx = SpringContext.getApplicationContext();
		ForumDao forumDao = ctx.getBean(ForumDao.class);
		System.out.println("---------"+forumDao);
		
	  /*Group probe = new Group();
		probe.setStatus(true);
		ExampleMatcher matcher=ExampleMatcher.matching();
		Example<Group> example=Example.of(probe, matcher);
		List<Group> list = groupDao.findAll(example);*/

		List<Forum> list = forumDao.findByStatus(true);
//		for(Forum g:list) {
//			System.out.println(g.getName());
//		}
		sce.getServletContext().setAttribute("FORUM_LIST", list);
		
		// application,session,request,page
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
