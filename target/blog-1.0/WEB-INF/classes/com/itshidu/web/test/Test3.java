package com.itshidu.web.test;

import org.apache.commons.lang3.StringEscapeUtils;

public class Test3 {

	public static void main(String[] args) {
		String a = "<script>alert('HelloWorld');</script>";
		a=StringEscapeUtils.escapeHtml4(a);
		a=StringEscapeUtils.unescapeHtml4(a);
		System.out.println(a);
		
	}
	
	

}
