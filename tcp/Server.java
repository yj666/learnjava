package cn.itcast.p1.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {

	public static void main(String[] args) throws IOException {
		
		//创建服务端对象。
		ServerSocket ss = new ServerSocket(10002);
		
		//获取连接过来的客户端对象。
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		//通过socket对象获取输入流，要读取客户端发来的数据。
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		String text = new String(buf,0,len);
		System.out.println(ip+":"+text);
		
		s.close();
		ss.close();
	}

}
