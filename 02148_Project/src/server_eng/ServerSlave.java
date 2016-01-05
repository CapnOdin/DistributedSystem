package server_eng;

public class ServerSlave implements Runnable {
	private TCPServer parent;
	
	public ServerSlave(TCPServer parent) {
		this.parent = parent;
	}

	@Override
	public void run() {
		
	}

}
