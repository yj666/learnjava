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

		//�����ͻ���socket����
		Socket s = new Socket("192.168.1.110",10004);
		
		//��ȡ�ı�
		BufferedReader bufr = 
				new BufferedReader(new FileReader("d://client.txt"));
		
		//sockets�����
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		String line = null;
		while((line=bufr.readLine())!=null) {
			
			out.println(line);
		}
		
		//���߷���ˣ��ͻ���д���ˡ�
		s.shutdownOutput();
		//out.println("!@#$%^&*(");
		
		//socket����������ȡ����˷��ص����ݡ�
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String str = bufIn.readLine();
		System.out.println(str);
		
		bufr.close();
		s.close();
	}

}
