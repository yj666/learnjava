package cn.itcast.p1.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TransServer {

	public static void main(String[] args) throws IOException {
		
		//ServerSocket服务。
		ServerSocket ss = new ServerSocket(10003);
		
		//获取socket对象。
		Socket s = ss.accept();
		
		//获取ip。
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"...connected");
		//获取socket读取流，并装饰。
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//获取socket的输出流，并装饰。
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		String line = null;
		while((line=bufIn.readLine())!=null){
			
			System.out.println(line);
			out.println(line.toUpperCase());
		}
		
		s.close();
		ss.close();

	}

}
