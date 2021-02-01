package client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends ClientFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Socket socket;
	PrintWriter toServ;
	BufferedReader fromServ;
	public Client(String serverName, int port) throws IOException{
		
		
		try
		{
			Socket socket = new Socket(serverName, port);
			
			
			toServ = new PrintWriter(socket.getOutputStream());
			fromServ = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			
			
			
		} // End try
		catch(UnknownHostException e){}
		catch(IOException e) {}
		finally
		{
			//super.displayMsg("Console: Closing connection ...");
			//socket.close();
		}
	}
	
	/*
	public static void main(String args[]) throws IOException
	{
		Client client;

		if (args.length != 2)
			System.out.println("Usage: java ChatClient serverName port");
		else
		{
			String serverName = args[0];
			int port = Integer.parseInt(args[1]);
			client = new Client(serverName, port);
		}
	}
	*/

	public Socket getSocket() {
		return socket;
		
	}
	public void sendMsg(String msg) {
			
				toServ.println(msg);
				toServ.flush();
	
	}

	

	public String getServMsg() {
		String servMsg;
		try {
			servMsg = fromServ.readLine();
			return servMsg;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return "";
	}
		
	
}
