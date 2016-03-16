import java.util.ArrayList;

public class SJF {
	ArrayList<Process> a;
	int fullTime;

	public SJF(AllProcesses allPrecess) {
		this.a = allPrecess.all;
		this.fullTime = allPrecess.getFullTime();
	}

	public void SJF_Algorithm()
	{
		for (int i = 0; i < fullTime; i++)
		{
			Process best = null;
			for (Process p : a)
			{
				if (p.isInReadyQueue(i))
				{
					// the first process in the queue
					if (best == null)
						best = p;
					else if (p.burstTime < best.burstTime)
						best = p;

				}
			}

				// no process arrive at time i (queue in empty)
				if (best != null)
				{
					//TODO if the same burst time , choose the lower pid
					best.timeFinished = best.burstTime;// finish the process
					best.timeStartWork.add(i);
					i = i + best.burstTime; // advance time to skip the finshed process time
											 
					best.timeFinishedWork.add(i);
					i = i - 1; // to remove the effect of i++
				}
		}
	}
	
	public void printChart(){
		for (Process p : a){
			System.out.println(p.pid + " " + p.timeStartWork.get(0) + " " + p.timeFinishedWork.get(0));
		}
	}

}
