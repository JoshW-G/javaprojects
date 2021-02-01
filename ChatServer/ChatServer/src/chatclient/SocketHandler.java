package chatclient;
import java.util.ArrayList;

public class SocketHandler implements Runnable {
	
	private ArrayList<SocketRunnable> sockets;
	private Thread thread;
	public SocketHandler() {
		sockets = new ArrayList<SocketRunnable>();
		thread = new Thread(this);
		thread.start();
	}
	
	public void addSocket(SocketRunnable s) {
		sockets.add(s);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Boolean send= false;
		String msg="";
		int socketID= -1; //So can increment ID each loop but still start off at 0
		int senderID=-1;
		for(;;) {
			if(socketID>sockets.size()) {socketID = -1;}
			for(SocketRunnable s: sockets) {
				socketID++;
				if(send==true) {
					if(socketID!=senderID) {
						s.sendtoClient(msg);
					}
				}
				msg=s.getSocketMsg();
				if(!(msg.isEmpty())) {
					System.out.println("socket is not empty");
					//s.sendtoClient(msg);
					senderID=socketID;
					send = true;
				}
				else {
					send = false;
					System.out.println("socket is empty");
				}
			}
		}
	}
}
