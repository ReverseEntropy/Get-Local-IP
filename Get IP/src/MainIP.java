import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.net.DatagramSocket;


public class MainIP {

	public static void main(String[] args) {
		ArrayList<String> adapters = new ArrayList<>();
		try {
			Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
			
			while(NetworkInterface.getNetworkInterfaces().hasMoreElements()) {
				NetworkInterface ni = nis.nextElement();
				adapters.add(ni.toString());
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			System.out.println("exception block");
			e.printStackTrace();
		}catch(NoSuchElementException nsee) {
			System.out.println("finished iterating");
		}
		
		for(String s: adapters) {
			System.out.println(s);
		}
		
		try(final DatagramSocket socket = new DatagramSocket()){
			  try {
				socket.connect(InetAddress.getByName("1.1.1.1"), 10002);
				String ip = socket.getLocalAddress().getHostAddress();
				System.out.println("IP: " + ip);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			} catch (SocketException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		

	}

}
