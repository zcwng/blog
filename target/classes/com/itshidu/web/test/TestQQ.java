package com.itshidu.web.test;

import com.itshidu.web.util.HttpClientUtil;

public class TestQQ {

	public static void main(String[] args) {
		//https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=101340964&redirect_uri=http://www.shiduketang.com/login/bind/qq/callback&state=1006

		//Authorization Code: 388502FFBE89D05918A27B4E652318E5
		
		String url="https://graph.qq.com/oauth2.0/token?grant_type=authorization_code&client_id=101340964&client_secret=92c367a3cec734a0cb2c4fa49e421e04&code=388502FFBE89D05918A27B4E652318E5&redirect_uri=http://www.shiduketang.com/login/bind/qq/callback";
		String text=HttpClientUtil.doGet(url);
		System.out.println(text);
		
		String access_token = "8E1F37EF9271ABECB51DAC9C131B06AA";
		String openid = "8F8026A66BF3C88709939AA9371ED87A";
		
		String a="https://graph.qq.com/user/get_user_info?access_token=8E1F37EF9271ABECB51DAC9C131B06AA&oauth_consumer_key=101340964&openid=8F8026A66BF3C88709939AA9371ED87A";
		String info = HttpClientUtil.doGet(a);
		System.out.println(info);
	}
	
	

}
