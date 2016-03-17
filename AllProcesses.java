import java.util.ArrayList;
import java.util.Collections;

public class AllProcesses {
	ArrayList<Process> all;
	ArrayList<chartObject> chart;

	// constructor
	public AllProcesses() {
		this.all = new ArrayList<Process>();
		chart = new ArrayList<chartObject>();
	}

	/*
	 * function to add new process
	 */
	public void addNewProcess(Process p) {
		this.all.add(p);
	}

	public String toString() {

		String out = "";
		for (Process p : all) {
			out += p.pid + " " + p.arriveTime + " " + p.burstTime + " "
					+ p.repeat + " " + p.interval + " " + p.deadline + "\n";
		}

		return out;
	}

	/*
	 * function to get the sum of burst time for all processes
	 */
	public int getFullTime() {
		int sum = 0;
		for (Process p : all) {
			sum += p.burstTime;
		}
		return sum;
	}

	void buildChart() {
		for (Process p : all) {
			for (int i = 0; i < p.timeFinishedWork.size(); i++)
				chart.add(new chartObject(p.pid, p.timeStartWork.get(i),
						p.timeFinishedWork.get(i)));
		}
		Collections.sort(chart);

	}
	
	void printChart(){
		for (chartObject c: chart) {
			System.out.println(c.toString());
		}
		
		System.out.println("-----------------------------------------------------------");
		for (Process p : all) {
			System.out.println("p" + p.pid + " "+ "turn around is " + p.turnaround() + " waiting time is " + p.waitTime() );
		}
	}

	class chartObject implements Comparable {
		int pid;
		int arriveTime;
		int finishTime;

		public chartObject(int pid, int arriveTime, int finishTime) {
			this.pid = pid;
			this.arriveTime = arriveTime;
			this.finishTime = finishTime;
		}

		@Override
		public int compareTo(Object c) {

			return (int) (arriveTime - ((chartObject) c).arriveTime);
		}
		
		public String toString(){
			return "pid = " + pid + " start time = " + arriveTime + " finish time = " + finishTime;
		}

	}

}
