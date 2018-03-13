package cn.itcast.p1.uploadpic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;



public class UploadPicClient {

	public static void main(String[] args) throws IOException {
		
		//����socket�ͻ��˶���
		Socket s = new Socket("192.168.1.110",10005);
				
		//��ȡͼƬ
		FileInputStream fis = new FileInputStream("d:\\1.jpg");
				
		//��ȡsocket�����������ȡ��ͼƬ���ݷ��͸�����ˡ�
		OutputStream out = s.getOutputStream();
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		while((len=fis.read(buf))!=-1) {
			out.write(buf,0,len);
		}
		
		//���߷���ˣ�������ݷ�����ϣ��÷����ֹͣ��ȡ��
		s.shutdownOutput();
		
		//��ȡ����˷��ص����ݡ�
		InputStream in = s.getInputStream();
		byte[] bufIn = new byte[1024];
		
		int lenIn = in.read(bufIn);
		String text = new String(buf,0,lenIn);
		System.out.println(text);
		
		fis.close();
		s.close();
	}

}
