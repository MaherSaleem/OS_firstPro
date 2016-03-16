import java.util.ArrayList;


public class AllProcesses {
	ArrayList<Process> all;
	
	//constructor 
	public AllProcesses() {
		this.all = new ArrayList<Process>();
	}
	
	
	/*
	 * function to add new process 
	 */
	public void addNewProcess(Process p){
		this.all.add(p);
	}
		
	public String toString(){
		
		String out="";
		for (Process p : all)
		{
			out += p.pid +" "+ p.arriveTime +" "+ p.burstTime+" " + p.repeat +" "+ p.interval +" "+ p.deadline+ "\n";
		}
		
		return out;
	}
	
	
	/*
	 * function to get the sum of burst time for all processes
	 */
	public int getFullTime(){
		int sum = 0;
		for (Process p : all)
		{
			sum += p.burstTime;
		}
		return sum;
	}
	
}
