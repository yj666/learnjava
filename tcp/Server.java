package cn.itcast.p1.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {

	public static void main(String[] args) throws IOException {
		
		//��������˶���
		ServerSocket ss = new ServerSocket(10002);
		
		//��ȡ���ӹ����Ŀͻ��˶���
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		//ͨ��socket�����ȡ��������Ҫ��ȡ�ͻ��˷��������ݡ�
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		String text = new String(buf,0,len);
		System.out.println(ip+":"+text);
		
		s.close();
		ss.close();
	}

}
