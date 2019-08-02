package com.itshidu.web.test;

import java.util.Date;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itshidu.web.dao.ArticleDao;
import com.itshidu.web.dao.ForumDao;
import com.itshidu.web.dao.StudentDao;
import com.itshidu.web.dao.UserDao;
import com.itshidu.web.entity.Article;
import com.itshidu.web.entity.Forum;
import com.itshidu.web.entity.Student;
import com.itshidu.web.entity.User;

public class TestSave {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/ApplicationContext.xml");
		UserDao userDao = ctx.getBean(UserDao.class);
		ForumDao forumDao = ctx.getBean(ForumDao.class);
		ArticleDao articleDao = ctx.getBean(ArticleDao.class);
		Date dt = new Date();
		long time = dt.getTime();
		/*for(int i=1;i<=200;i++) {
			Student s = new Student();
			s.setName("悟空"+i);
			s.setCode(String.format("XH%04d", i));
			s.setCreateTime(dt);
			s.setUpdateTime(dt);
			dao.save(s);
		}*/
		
		User user = userDao.getOne((long)14);
		Forum forum = forumDao.getOne((long)1);
		
		
		for(int i=1;i<=100;i++) {
			Article a = new Article();
			a.setCreateTime(new Date(time));
			a.setForum(forum);
			a.setUser(user);
			a.setTitle("标题："+i);
			a.setContent(i+":::SpringBoot提供了非常方便的事务操作，通过注解就可以实现事务的回滚，非常方便快捷，下面我们就说一下如何进行事务操作。");
			a.setHits((long)(Math.random()*1000));
			articleDao.save(a);
			time+=1000;
		}
	}

}
