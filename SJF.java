
public class SJF  extends schedule{
	
	
	public SJF(AllProcesses allPrecess) {
		this.a = allPrecess.all;
		this.fullTime = allPrecess.getFullTime();
		this.allPrecess = allPrecess;
	}

	public void SJF_Algorithm()
	{
		boolean isCpuIdel = true;

		for (int i = 0; i < fullTime; i++)
		{
			isCpuIdel = true;
			Process best = null;
			for (Process p : a)
			{
				if (p.isInReadyQueue(i))
				{
					isCpuIdel = false;//there is a proccess in the queue , so its not idil
					// the first process in the queue
					if (best == null)
						best = p;
					else if (p.burstTime <= best.burstTime )
					{
						if(p.burstTime == best.burstTime && p.pid > best.pid);//do nothing
							
						else//in case of tie
							best = p;
					}

				}
			}
			if(isCpuIdel)
				fullTime++;//the cpu must work for additional second


				// no process arrive at time i (queue in empty)
				if (best != null)
				{
					best.timeFinished = best.burstTime;// finish the process
					best.timeStartWork.add(i);
					i = i + best.burstTime; // advance time to skip the finshed process time
											 
					best.timeFinishedWork.add(i);
					i = i - 1; // to remove the effect of i++
				}
		}
	}
	

}
