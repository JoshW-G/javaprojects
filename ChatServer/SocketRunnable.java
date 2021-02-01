package chatclient;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketRunnable implements Runnable{
	
	private Socket socket;
	private Thread thread;
	private Scanner fromSocket;
	private PrintWriter toSocket;
	private boolean done;
	private String msg;
	
	
	public SocketRunnable(Socket s) throws IOException {
		this.socket = s;
		thread = new Thread(this);
		thread.start();
		fromSocket = new Scanner(socket.getInputStream());
		toSocket = new PrintWriter(socket.getOutputStream());
		msg = "";
		done = false;
		
	}
	
	
	/*@Override
	public void run() {
		String msg="";
		for(;;) {
			msg = getSocketMsg();
			if(msg.equals())
		}
		
	}*/
	public void sendtoClient(String msg) {
		
		toSocket.println(msg);
		toSocket.flush();

	}



	public String getSocketMsg() {
		String servMsg;
		servMsg = fromSocket.nextLine();
		
		return servMsg;
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


	
	
}
