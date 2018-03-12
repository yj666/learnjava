package cn.itcast.p1.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Server2 {

	public static void main(String[] args) throws IOException {
		
		//创建服务端对象。
		ServerSocket ss = new ServerSocket(10002);
		
		//获取连接过来的客户端对象。
		Socket s = ss.accept();//阻塞式。
		String ip = s.getInetAddress().getHostAddress();
		//通过socket对象获取输入流，要读取客户端发来的数据。
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		String text = new String(buf,0,len);
		System.out.println(ip+":"+text);
		
		//使用客户端socket对象的输出流给客户端返回数据。
		OutputStream out = s.getOutputStream();
		out.write("法克耶！".getBytes());
		s.close();
		ss.close();
	}

}
