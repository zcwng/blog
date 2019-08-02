package com.itshidu.web.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
/**
 * FTP连接池
 * @author XiaZengming
 * @URL http://new.itshidu.com
 */
public class FtpClientPool {
	
	String host;
	int port;
	String username;
	String password;
	
	private int MAX_SIZE = 50;
	private int INIT_SIZE = 5;
	
	
	
	public FtpClientPool(String host, int port, String username, String password) {
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
		init();
	}
	private void init() {
		try {
			for(int i=0;i<INIT_SIZE;i++) {
				FTPClient ftpClient = new FTPClient();
		        ftpClient.connect(host,port);
		        ftpClient.login(username,password);
		        infos.put(ftpClient, null);
			}
			ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
			//final String[] cmds = new String[] {"NOOP","LIST","REST 0","TYPE A","TYPE I"};
			ses.scheduleAtFixedRate(new Runnable() {
				public void run() { //每隔10秒发送一次心跳
					Set<FTPClient> fcs = infos.keySet();
					for(FTPClient fc:fcs) {
						try {
							//String cmd = cmds[(int)(Math.random()*cmds.length)];
							int code=fc.sendCommand("NOOP");
							System.out.println(code);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			},10, 10, TimeUnit.SECONDS);
			ses.scheduleAtFixedRate(new Runnable() {
				public void run() { //每隔10秒发送一次心跳
					Set<FTPClient> fcs = infos.keySet();
					for(FTPClient fc:fcs) {
						try {
							//String cmd = cmds[(int)(Math.random()*cmds.length)];
							int code=fc.sendCommand("NOOP");
							System.out.println(code);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			},10, 10, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private Map<FTPClient,Thread> infos = new HashMap();
	
	/** 从这个池子中租用一条连接 */
	public FTPClient getFtpClient() throws SocketException, IOException, InterruptedException {
		Thread thread = Thread.currentThread();
		System.out.println(thread+"::开始排队获取FtpClient...");
		synchronized (infos) {
			while(true) {
				Set<Entry<FTPClient, Thread>> ens = infos.entrySet();
				Iterator<Entry<FTPClient, Thread>> it =ens.iterator();
				int n = 1;
				while(it.hasNext()) {
					Entry<FTPClient, Thread> en = it.next();
					if(en.getValue()==null) {
						en.setValue(thread);
						System.out.println(thread+"::成功取得FtpClient:"+n);
						return en.getKey();
					}
					n++;
				}
				if(infos.size()<MAX_SIZE) {
					System.out.println(thread+"::创建Ftp连接");
					FTPClient ftpClient = new FTPClient();
			        ftpClient.connect(host,port);
			        ftpClient.login(username,password);
			        infos.put(ftpClient, null);
			        System.out.println(thread+"::成功取得新创建的Ftp连接。");
			        return ftpClient;
				}else {
					System.out.println(thread+"::未取得，正在排队，准备重新获取...");
					infos.wait();
				}
			}
		}
	}
	/** 归还一条连接 */
	public void restore(FTPClient ftpClient) {
		synchronized (infos) {
			if(ftpClient!=null) {
				infos.put(ftpClient, null);
				infos.notifyAll();
				System.out.println("资源释放，通知其他人");
			}
		}
	}

	public void upload(FTPClient client,String savePath,String filename,InputStream in) throws SocketException, IOException, InterruptedException {
        synchronized (client) {
			System.out.println("::"+savePath);
	        mkdirs(client, savePath);
	        client.changeWorkingDirectory(savePath);
	        client.setFileType(FTP.BINARY_FILE_TYPE);
	        client.storeFile(filename, in);
		}
	}
	
	public void upload(String savePath,String filename,InputStream in) throws SocketException, IOException, InterruptedException {
		FTPClient client = getFtpClient();
		upload(client, savePath, filename, in);
		restore(client);
	}
	
	/**
	 * 通过ftp创建多层目录（要求path中的路径分隔符使用"/"）
	 * @param client
	 * @param path
	 * @throws IOException
	 */
	public void mkdirs(FTPClient client,String path) throws IOException {
		if(path.contains("\\")) {
			throw new RuntimeException("'\\' is not allowed in the path,please use '/'");
		}
		File f = new File(path);
		List<String> names = new LinkedList();
		while(f!=null&&f.toString().length()>0) {
			names.add(0, f.toString().replaceAll("\\\\", "/"));
			f=f.getParentFile();
		}
		for(String name:names) {
			client.makeDirectory(name);
		}
	}
	public static void main(String[] args) {
		
		
		
	}
}
