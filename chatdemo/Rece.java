package chatdemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Rece implements Runnable {

private DatagramSocket ds;
	
	public Rece(DatagramSocket ds) {
		this.ds = ds;
	}
	
	public void run() {
		
		try {
		while(true) {
			//�������ݰ���
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf,buf.length);
			
			//ʹ�ý��շ��������ݴ洢�����ݰ��С�
			ds.receive(dp);//����ʽ�ġ�
			
			//ͨ�����ݰ�����ķ������������е����ݣ����磬��ַ���˿ڣ��������ݡ�
			String ip = dp.getAddress().getHostAddress();
			int port = dp.getPort();
			String text = new String(dp.getData(),0,dp.getLength());
			
			System.out.println(ip+":"+text);
			
			if(text.equals("bye")) {
				System.out.println(ip+"�˳�������...");
			}
			}
		}catch(Exception e) {
			
		}
	}

}
