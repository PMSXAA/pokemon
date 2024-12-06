package pokemon.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Utils {
	
	private Utils() {}
	
	public static String getIpServer() {
		InetAddress localhost;
		String ip = "";
		try {
			localhost = InetAddress.getLocalHost();
			ip = localhost.getHostAddress().trim();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			ip = "";
		}
		
		return ip;
	}

}
