public class Worker extends Processor {
	private Machines Que = new Machines();
	
	public Worker(){
		this.setProcessTime(5);
	}
	
	public void Repaired()
	{
		
		Machine repairedMachine = this.Que.get(0);
		repairedMachine.setStatus(Status.BUSY);
		repairedMachine.setProcessTime(SimulatorUtility.randomGenerator());//bozulan makinanın bir sonraki bozulma zamanını random verdik.
		repairedMachine.setClock(repairedMachine.getProcessTime()+this.getClock());
		repairedMachine.setRepairTime(SimulatorUtility.randomGenerator());//bozulan makinanın bir sonraki tamir suresini random verdik.
		
		this.Que.remove(0);
		if(this.Que.size()>0) 
		{
			this.setClock(repairedMachine.getRepairTime()+this.getClock()); 
			this.setStatus(Status.BUSY);
		}
		else 
		{
			this.setStatus(Status.IDLE);
			this.setClock(0);
		}
	}

	public void Repair(Machine brokenMachine) {
		brokenMachine.setStatus(Status.OUT_OF_SERVICE);
		this.Que.add(brokenMachine);
		if(this.getStatus()==Status.IDLE){
			this.setClock(brokenMachine.getRepairTime() + brokenMachine.getClock());
			this.setStatus(Status.BUSY);
		}
		brokenMachine.setClock(0);
	}
	
	public int QueSize(){ return this.Que.size(); }
}
