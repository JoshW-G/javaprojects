package chatclient;
import java.io.IOException;

public class ServerSetup {
	public static void main(String[] args) throws IOException {
		ChatServer3 server = new ChatServer3(8888);
	}
}
