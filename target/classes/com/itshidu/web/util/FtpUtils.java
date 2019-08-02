package com.itshidu.web.util;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.net.ftp.FTPClient;

public class FtpUtils {
	public static void upload(String host,int port,String username,String password,InputStream in,String path,String filename) {
		FtpClientPool fcp=null;
		if(fcp==null) {
			fcp = new FtpClientPool(host,port,username,password);
		}
		String result = null;
		try {
			FTPClient client = fcp.getFtpClient();
			fcp.upload(client,path, filename, in);
			fcp.restore(client);
			//result = "http://"+FTP_SERVER_IP+savePath+newFileName;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
