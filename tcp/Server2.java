package cn.itcast.p1.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Server2 {

	public static void main(String[] args) throws IOException {
		
		//��������˶���
		ServerSocket ss = new ServerSocket(10002);
		
		//��ȡ���ӹ����Ŀͻ��˶���
		Socket s = ss.accept();//����ʽ��
		String ip = s.getInetAddress().getHostAddress();
		//ͨ��socket�����ȡ��������Ҫ��ȡ�ͻ��˷��������ݡ�
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		String text = new String(buf,0,len);
		System.out.println(ip+":"+text);
		
		//ʹ�ÿͻ���socket�������������ͻ��˷������ݡ�
		OutputStream out = s.getOutputStream();
		out.write("����Ү��".getBytes());
		s.close();
		ss.close();
	}

}