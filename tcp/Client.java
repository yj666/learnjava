package cn.itcast.p1.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException  {
		
		//�����ͻ���socket����
		Socket socket = new Socket("192.168.1.110",10002);
		
		//��ȡsocket���е��������
		OutputStream out = socket.getOutputStream();
		
		//ʹ����������ƶ�������д��ȥ��
		out.write("��ά����������Ү��".getBytes());
		
		//�ر���Դ��
		socket.close();

	}

}
