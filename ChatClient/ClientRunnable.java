package client;
public class ClientRunnable implements Runnable {
	
	private Client client;
	private ClientTextArea msgArea;
	private Thread thread;
	
	public ClientRunnable(Client c, ClientTextArea t) {
		this.client = c;
		this.msgArea = t;
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		String servMsg;
		for(;;){
			servMsg=client.getServMsg();
			if(!servMsg.equals("")) {
			msgArea.displayMsg(servMsg);
			}
		}
	}

	

}
