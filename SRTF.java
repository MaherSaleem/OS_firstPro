import java.util.ArrayList;


public class SRTF {
	ArrayList<Process> a;
	int fullTime;

	public SRTF(AllProcesses allPrecess) {
		this.a = allPrecess.all;
		this.fullTime = allPrecess.getFullTime();
	}

	public void SRTF_Algorithm()
	{
		Process best = null;
		for (int i = 0; i < fullTime; )
		{
			if(i == 0)
				 best = null;
			for (Process p : a)
			{
				if (p.isInReadyQueue(i) )
				{
					// the first process in the queue
					if (best == null)
						best = p;
					else if (p.RemainingTime() < best.RemainingTime())
						best = p;

				}
			}

				// no process arrive at time i (queue in empty)
				if (best != null)
				{
					int size = best.timeFinishedWork.size();
					if(size != 0 && i == best.timeFinishedWork.get(size-1))
						best.timeFinishedWork.set(size-1, i+1);
						
					else{
						best.timeStartWork.add(i);
						best.timeFinishedWork.add(i+1);
					}
					best.timeFinished += 1;
					if(best.timeFinished == best.burstTime)//the process has finished
						best=null;// so its not the new best

					i = i + 1; 
				}
		}
	}
	
	public void printChart(){
		for (Process p : a)
		{

			for (int i = 0; i < p.timeFinishedWork.size(); i++)
				System.out.println(p.pid + " " + p.timeStartWork.get(i) + " "
						+ p.timeFinishedWork.get(i));
			System.out.println("------------------");
		}
	}

}
