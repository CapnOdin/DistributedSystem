package server_eng;

public class ServerSlave implements Runnable {
	private ServerTupleSpace space;
	
	public ServerSlave(ServerTupleSpace space) {
		this.space = space;
	}

	@Override
	public void run() {
		while(true) {
			
		}
	}

}
