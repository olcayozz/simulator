public abstract class Processor {	
	private int processTime = 0;
	private int clock = 0;
	private int index = 0;
	private int totalWorkinTime= 0;
	private Status status = Status.IDLE;
	
	public int getClock() {
		return clock;
	}

	public void setClock(int clock) {
		this.clock = clock;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getProcessTime() {
		return this.processTime;
	}

	public void setProcessTime(int processTime) {
		this.processTime = processTime;
	}
/*
	public void setProcessTime() {
		this.processTime = SimulatorUtility.randomGenerator();
	}
	*/
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getTotalWorkinTime() {
		return totalWorkinTime;
	}

	public void setTotalWorkinTime(int totalWorkinTime) {
		this.totalWorkinTime = totalWorkinTime;
	}
}
