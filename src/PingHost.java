import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PingHost {
	public static void main(String[] args) {
		String host = "daerndvault02.eur.ad.sag";
		int port = 8081;
		int timeout = 1000;
		Boolean tpVaultAvailability = pingHost(host, port, timeout);
		System.out.println(tpVaultAvailability);
	}

	public static boolean pingHost(String host, int port, int timeout) {
		try (Socket socket = new Socket()) {
			socket.connect(new InetSocketAddress(host, port), timeout);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false; // Either timeout or unreachable or failed DNS lookup.
		}
	}
}
