package cn.itcast.p1.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {

	public static void main(String[] args) throws UnknownHostException, IOException  {
		
		//�����ͻ���socket����
		Socket socket = new Socket("192.168.1.110",10002);
		
		//��ȡsocket���е��������
		OutputStream out = socket.getOutputStream();
		
		//ʹ����������ƶ�������д��ȥ��
		out.write("��ά����������Ү��".getBytes());
		
		
		//��ȡ����˷��ص����ݣ�ʹ��socket��ȡ����
		InputStream in = socket.getInputStream();
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		String text = new String(buf,0,len);
		System.out.println(text);
		//�ر���Դ��
		socket.close();

	}

}
