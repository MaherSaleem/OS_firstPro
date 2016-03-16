import java.util.ArrayList;


public class Process {
	
	public int pid;
	public int arriveTime;
	public int burstTime ;
	public int repeat ;
	public int interval ;
	public int  deadline;
	public int timeFinished;//time finished from the burst
	
	public ArrayList<Integer> timeStartWork;
	public ArrayList<Integer> timeFinishedWork;
	
	
	/*Constructor*/
	public Process(int pid, int arriveTime, int burstTime, int repeat,
			int interval, int deadline) {
		this.pid = pid;
		this.arriveTime = arriveTime;
		this.burstTime = burstTime;
		this.repeat = repeat;
		this.interval = interval;
		this.deadline = deadline;
		
		this.timeStartWork= new ArrayList<Integer>();
		this.timeFinishedWork =new ArrayList<Integer>();
	}
	
	


	/*
	 * function to check if the process started
	 */
	public boolean isStarted(int currentTime){
		return this.arriveTime <= currentTime;
	}
	
	
	/*
	 * function to check if the process has finished
	 */
	public boolean isFinished(int currentTime){
		return this.burstTime == this.timeFinished;
	}
	
	
	
	
	public boolean isInReadyQueue(int currentTime){
		return !isFinished(currentTime) && isStarted(currentTime);
	}
	
	public int RemainingTime(){
		if (burstTime - timeFinished == 0)
			return Integer.MAX_VALUE;
		return burstTime - timeFinished;
	}
	
	public int turnaround(){
		return this.timeFinishedWork.get(timeFinishedWork.size()-1) - this.arriveTime;
	}
	
	
	public int waitTime(){
		return this.turnaround() - this.burstTime;
	}

	
	
}
