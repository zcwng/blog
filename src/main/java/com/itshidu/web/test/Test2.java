package com.itshidu.web.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itshidu.web.dao.ArticleDao;
import com.itshidu.web.entity.Article;
import com.itshidu.web.entity.Forum;
import com.itshidu.web.entity.User;

public class Test2 {

	public static void main(String[] args) throws IOException, ParseException {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/ApplicationContext.xml");
		ArticleDao dao = ctx.getBean(ArticleDao.class);
		
		Forum forum = new Forum();
		forum.setId(1L);
		User user = new User();
		user.setId(15L);
		
		
		for(int i=1;i<=5;i++) {
			Document document = Jsoup.connect("https://bbs.csdn.net/forums/Java?page="+i).get();
			//Element table = document.getElementsByClass("forums_tab_table").first();
			Elements elements = document.getElementsByClass("forums_title");
			for(Element element : elements) {
				String url = "https://bbs.csdn.net"+element.attr("href");
				
				Document doc2 = Jsoup.connect(url).get();
				Element 一楼 = doc2.getElementsByClass("mod_topic_wrap").first();
				Element 时间 = 一楼.getElementsByClass("date_time").first();
				String hots = 一楼.getElementsByClass("reply_num").first().text();
				
				
				Element e2 = doc2.getElementsByClass("post_body").first();
				
				//-----------------------------
				
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				
				Article a = new Article();
				e2.getElementsByTag("script").remove();
				//String text = StringEscapeUtils.escapeHtml4(e2.html());
				a.setContent(e2.html());
				a.setCreateTime(sf.parse(时间.text()));
				a.setHits(Long.parseLong(hots));
				
				a.setTitle(element.text());
				a.setUser(user);
				a.setForum(forum);
				
				dao.save(a);
				
			}
		}
		

	}

}
