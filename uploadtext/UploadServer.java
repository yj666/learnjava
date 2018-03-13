package cn.itcast.p1.uploadtext;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {

	public static void main(String[] args) throws IOException {
		
		//ServerSocket服务。
		ServerSocket ss = new ServerSocket(10004);
		
		//获取socket对象。
		Socket s = ss.accept();
		System.out.println(s.getInetAddress().getHostAddress()+"...connected");
		//获取socket读取流。
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//获取socket输出流。
		BufferedWriter bufw = new BufferedWriter(new FileWriter("d://server.txt"));
		
		String line = null;
		while((line=bufIn.readLine())!=null) {
			
			//if("!@#$%^&*(".equals(line))
			//	break;
			bufw.write(line);
			bufw.newLine();
			bufw.flush();
		}
		
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("上传成功");
		
		bufw.close();
		s.close();
		ss.close();
		

	}

}
