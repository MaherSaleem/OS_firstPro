

public class EP extends schedule {

	public EP(AllProcesses allPrecess) {
		this.a = allPrecess.all;
		this.fullTime = allPrecess.getFullTime();
		this.allPrecess = allPrecess;

	}

	public void EP_Algorithm()
	{
		Process best = null;
		boolean isCpuIdel = true;//
		
		for (int i = 0; i < fullTime; i++ )
		{
			isCpuIdel = true;
			if(i == 0)
				 best = null;
			for (Process p : a)
			{
				if (p.isInReadyQueue(i) )
				{
					isCpuIdel = false;//there is a proccess in the queue , so its not idil
					// the first process in the queue
					if (best == null)
						best = p;
					else if (p.priority <= best.priority  )//check the priority
					{
						if(p.priority  == best.priority  && p.pid > best.pid);//do nothing
							
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
				}
		}
	}
	

}
