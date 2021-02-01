package chatclient;
import java.net.*;
import java.io.*;
import java.util.*;
public class ChatServer3{

	private Socket  socket;
  private ServerSocket server;
	private Scanner in;
	private PrintWriter out;
	private SocketHandler handler;

	public ChatServer3(int port)throws IOException{
		try
		{
			server = new ServerSocket(port);
			handler = new SocketHandler();
			System.out.println("Server started: " + server);
			System.out.println("Waiting for connection ...");


			while (true)
			{
				socket = server.accept();
				System.out.println("Socket created: " + socket);
				System.out.println("Connected to client ..." );
				SocketRunnable runnable = new SocketRunnable(socket);
				handler.addSocket(runnable);
			}
		}
		catch(IOException e)
		{
		 System.out.println(e);
		}
		finally
		{
		 
		}
	}


	public static void main(String args[]) throws IOException
	{
   	ChatServer3 server;

   	if (args.length != 1){
      	System.out.println(
				"Usage: java ChatServer3 port");
		}
		else
   	{
    		int port = Integer.parseInt(args[0]);
				server = new ChatServer3(port);
   }
	}


	

}
