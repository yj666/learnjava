package cn.itcast.p1.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {

	public static void main(String[] args) throws UnknownHostException, IOException  {
		
		//创建客户端socket服务。
		Socket socket = new Socket("192.168.1.110",10002);
		
		//获取socket流中的输出流。
		OutputStream out = socket.getOutputStream();
		
		//使用输出流将制定的数据写出去。
		out.write("莱维贝贝，法克耶！".getBytes());
		
		
		//读取服务端返回的数据，使用socket读取流。
		InputStream in = socket.getInputStream();
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		String text = new String(buf,0,len);
		System.out.println(text);
		//关闭资源。
		socket.close();

	}

}
