package cn.itcast.p1.uploadpic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class UploadPicServer {

	public static void main(String[] args) throws IOException {
		
		//����TCP��socket����ˡ�
		ServerSocket ss = new ServerSocket(10005);
		
		//��ȡ�ͻ��ˡ�
		Socket s = ss.accept();
		
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"...connected");
		
		//��ȡ�ͻ��˷��������ݡ�
		InputStream in = s.getInputStream();
		
		//����ȡ�������ݴ洢��һ���ļ����С�
		File dir = new File("d:\\pic");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		File file = new File(dir,ip+".jpg");
		FileOutputStream fos = new FileOutputStream(file);
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		while((len=in.read(buf))!=-1) {
			fos.write(buf,0,len);
		}
		
		//��ȡsocket����������ϴ��ɹ����������ͻ��ˡ�
		OutputStream out = s.getOutputStream();
		out.write("�ϴ��ɹ�".getBytes());
		
		fos.close();
		s.close();
		ss.close();
		
	}

}