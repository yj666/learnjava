package cn.itcast.p1.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TransClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//创建socket客户端对象。
		Socket s = new Socket("192.168.1.110",10003);
		
		//获取键盘录入。
		BufferedReader bufr = 
				new BufferedReader(new InputStreamReader(System.in));
		
		//socket输出流。
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		//socket输入流，读取服务端返回的大写数据。
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String line = null;
		
		while((line=bufr.readLine())!=null) { //阻塞。
			if("over".equals(line))
				break;
			
			out.println(line);
			
			//读取服务端发回的一行大写数。
			String upperStr = bufIn.readLine();
			System.out.println(upperStr);
		}
		
		s.close();
	}

}
//阻塞一般会造成双方等待，所以要刷新或者有换行动作。
