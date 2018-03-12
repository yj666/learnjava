package cn.itcast.p1.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException  {
		
		//创建客户端socket服务。
		Socket socket = new Socket("192.168.1.110",10002);
		
		//获取socket流中的输出流。
		OutputStream out = socket.getOutputStream();
		
		//使用输出流将制定的数据写出去。
		out.write("莱维贝贝，法克耶！".getBytes());
		
		//关闭资源。
		socket.close();

	}

}
