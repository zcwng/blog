package com.itshidu.web.test;

import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class BBB {

	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		WebClient wc = new WebClient(BrowserVersion.CHROME);  
	       wc.getOptions().setJavaScriptEnabled(true); //启用JS解释器，默认为true  
	       wc.setJavaScriptTimeout(100000);//设置JS执行的超时时间
	       wc.getOptions().setCssEnabled(false); //禁用css支持  
	       wc.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常  
	       wc.getOptions().setTimeout(10000); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待  
	       wc.setAjaxController(new NicelyResynchronizingAjaxController());//设置支持AJAX
	      
	       HtmlPage page = wc.getPage("https://www.bilibili.com/video/av33962846");
	       FileWriter fileWriter = new FileWriter("D:\\text.html");
	       String str = "";
	       str = page.asXml();
	       fileWriter.write( str );
	       wc.close();
	       fileWriter.close();

	}

}
