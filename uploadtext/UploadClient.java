package cn.itcast.p1.uploadtext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadClient {

	public static void main(String[] args) throws UnknownHostException, IOException {

		//创建客户端socket对象。
		Socket s = new Socket("192.168.1.110",10004);
		
		//获取文本
		BufferedReader bufr = 
				new BufferedReader(new FileReader("d://client.txt"));
		
		//sockets输出流
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		String line = null;
		while((line=bufr.readLine())!=null) {
			
			out.println(line);
		}
		
		//告诉服务端，客户端写完了。
		s.shutdownOutput();
		//out.println("!@#$%^&*(");
		
		//socket输入流。读取服务端返回的数据。
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String str = bufIn.readLine();
		System.out.println(str);
		
		bufr.close();
		s.close();
	}

}
