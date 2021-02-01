package bingo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;


/**
 * Initalises a Server to repeatedly send out ball objects with different Values
 * @author eeub10
 *
 */
public class BallServer {
	private int port = 8888;
	
	public BallServer() throws IOException {
		ServerSocket s = new ServerSocket(port);
		System.out.println("Server Running");
		s.accept();
		System.out.println("Socket Accepted");
		
		//loops new ball objects with random values
		while(true) {
			Ball ball = new Ball( (int) (Math.random()*99));
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("ball.dat"));
			objOut.writeObject(ball);
			objOut.close();
		}
		
	}
	public static void main(String[] args) {
		try {
			BallServer server = new BallServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}