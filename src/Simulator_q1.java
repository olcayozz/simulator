/**
 * 
 */

/**s
 * @author olcay
 * Question1
 */
public class Simulator_q1 {
	public static Machines Machines = new Machines();
	public static int SystemSize = 3;
	public static int[] initialClocks = { 1, 4, 9 };
	public static int Clock = 0;
	public static int iterator = 10;
	public static Worker RepairMan = new Worker();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Initialize();
		WriteClocks();
		
		for(int m = 0; m<iterator; m++){
			Clock = GetNextEventTime();
			if(RepairMan.getClock() - Clock == 0)//DEPARTURE
				RepairMan.Repaired();
			
			for(int i=0; i< Machines.size(); i++)
				if( Machines.get(i).getClock() - Clock == 0 ) {
					RepairMan.Repair(Machines.get(i));
				}
			WriteClocks();
		}
	}
	
	public static void Initialize() {
		System.out.println("MC		CL1		CL2		CL3		CL4		N		R");
		Machines machines = new Machines();
		for (int i = 0 ; i < SystemSize; i++)
		{	
			Machine m = new Machine();
			m.setIndex(i);
			m.setClock(initialClocks[i]);
			machines.add(m);
		}
		Machines = machines;
	}
	public static int GetNextEventTime() {
		int nextClockTime = 999;
		if(RepairMan.getStatus() == Status.BUSY) nextClockTime = RepairMan.getClock();
		for(int j=0; j < Machines.size(); j++)
			if( Machines.get(j).getStatus() == Status.BUSY && Machines.get(j).getClock() < nextClockTime )
				nextClockTime =  Machines.get(j).getClock();
		return nextClockTime;
	}
	
	public static void WriteClocks(){
		String clockLine, seperator = new String("");
		seperator = "		";
		clockLine = String.valueOf(Clock) + seperator;
		for(int j=0; j< Machines.size(); j++)
			if(Machines.get(j).getStatus() == Status.OUT_OF_SERVICE)
				clockLine += "-" + seperator;
			else
				clockLine += String.valueOf(Machines.get(j).getClock()) + seperator;
		
		if( RepairMan.getStatus() == Status.IDLE )
			clockLine += String.valueOf("-") + seperator;
		else
			clockLine += String.valueOf(RepairMan.getClock()) + seperator;
	
		clockLine += String.valueOf(RepairMan.QueSize())  + seperator;
		clockLine += RepairMan.getStatus().toString();
		System.out.println(clockLine);
	}
}
