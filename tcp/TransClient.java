package cn.itcast.p1.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TransClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//����socket�ͻ��˶���
		Socket s = new Socket("192.168.1.110",10003);
		
		//��ȡ����¼�롣
		BufferedReader bufr = 
				new BufferedReader(new InputStreamReader(System.in));
		
		//socket�������
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		//socket����������ȡ����˷��صĴ�д���ݡ�
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String line = null;
		
		while((line=bufr.readLine())!=null) { //������
			if("over".equals(line))
				break;
			
			out.println(line);
			
			//��ȡ����˷��ص�һ�д�д����
			String upperStr = bufIn.readLine();
			System.out.println(upperStr);
		}
		
		s.close();
	}

}
//����һ������˫���ȴ�������Ҫˢ�»����л��ж�����
