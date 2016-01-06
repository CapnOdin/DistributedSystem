package server_eng;

public abstract class TaskTemplate {
	private String id;
	private String instruction;
	private String clientAddress;
	private String description;
	
	public TaskTemplate(String id, String instruction, String clientAddress) {
		this.id = id;
		this.instruction = instruction;
		this.clientAddress = clientAddress;
	}
	
	public TaskTemplate(String id, String instruction, String clientAddress, String description) {
		this.id = id;
		this.instruction = instruction;
		this.clientAddress = clientAddress;
		this.description = description;
	}

	abstract void runTask(ServerTupleSpace space);
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
