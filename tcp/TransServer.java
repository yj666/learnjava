package cn.itcast.p1.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TransServer {

	public static void main(String[] args) throws IOException {
		
		//ServerSocket����
		ServerSocket ss = new ServerSocket(10003);
		
		//��ȡsocket����
		Socket s = ss.accept();
		
		//��ȡip��
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"...connected");
		//��ȡsocket��ȡ������װ�Ρ�
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//��ȡsocket�����������װ�Ρ�
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
