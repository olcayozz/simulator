public class Machine extends Processor {
	public Machine(){
		this.setProcessTime(SimulatorUtility.randomGenerator());
		this.setStatus(Status.BUSY);
		this.setRepairTime(SimulatorUtility.randomGenerator());
	}
	private int repairTime = 0;

	public int getRepairTime() {
		return repairTime;
	}

	public void setRepairTime(int repairTime) {
		this.repairTime = repairTime;
	}

}