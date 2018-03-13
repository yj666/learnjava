package cn.itcast.p1.uploadpic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;



public class UploadPicClient {

	public static void main(String[] args) throws IOException {
		
		//创建socket客户端对象。
		Socket s = new Socket("192.168.1.110",10005);
				
		//获取图片
		FileInputStream fis = new FileInputStream("d:\\1.jpg");
				
		//获取socket输出流，将读取的图片数据发送给服务端。
		OutputStream out = s.getOutputStream();
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		while((len=fis.read(buf))!=-1) {
			out.write(buf,0,len);
		}
		
		//告诉服务端，这边数据发送完毕，让服务端停止读取。
		s.shutdownOutput();
		
		//读取服务端发回的内容。
		InputStream in = s.getInputStream();
		byte[] bufIn = new byte[1024];
		
		int lenIn = in.read(bufIn);
		String text = new String(buf,0,lenIn);
		System.out.println(text);
		
		fis.close();
		s.close();
	}

}
