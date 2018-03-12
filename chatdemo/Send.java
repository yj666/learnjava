package chatdemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send implements Runnable {

	private DatagramSocket ds;
	
	public Send(DatagramSocket ds) {
		this.ds = ds;
	}
	public void run() {

		try {
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			
			while((line = bufr.readLine())!=null) {
				
				
				//ʹ��DatagramPacket�����ݷ�װ���ö�����С�
				byte[] buf = line.getBytes();
				
				DatagramPacket dp = 
						new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.110"),10001);
				
				//ͨ��udp��socket���񽫽����ݰ����ͳ�ȥ��ʹ��send������
				ds.send(dp);
				
				if("bye".equals(line))
					break;
			}
			ds.close();
		}catch (Exception e) {
			
		}
	}

	
}
