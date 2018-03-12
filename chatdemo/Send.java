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
				
				
				//使用DatagramPacket将数据封装到该对象包中。
				byte[] buf = line.getBytes();
				
				DatagramPacket dp = 
						new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.110"),10001);
				
				//通过udp的socket服务将将数据包发送出去。使用send方法。
				ds.send(dp);
				
				if("bye".equals(line))
					break;
			}
			ds.close();
		}catch (Exception e) {
			
		}
	}

	
}
