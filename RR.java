
public class RR  extends schedule{
	int quantumTime;

	public RR(AllProcesses allPrecess, int quantumTime) {
		this.a = allPrecess.all;
		this.fullTime = allPrecess.getFullTime();
		this.quantumTime = quantumTime;
		this.allPrecess = allPrecess;

	}

	public void RR_Algorithm()
	{
		boolean isCpuIdel = true;
		for (int i = 0; i < fullTime;){
			isCpuIdel = true;
			for (Process p : a){
				if (p.isInReadyQueue(i)){
					isCpuIdel = false;//there is a proccess in the queue , so its not idil
					p.timeStartWork.add(i);// add the time the process entered the cpu
					if (p.burstTime < this.quantumTime){// check if its finished before the time quantum
						p.timeFinishedWork.add(i = i + p.burstTime);// add the time the process out from the cpu
						p.timeFinished = p.burstTime; // the process has  finished
					}
					else{
						p.timeFinishedWork.add(i = i + this.quantumTime);
						p.timeFinished += this.quantumTime;
					}
				}
			}
			if(isCpuIdel){
				fullTime++;//the cpu must work for additional second
				i++;
			}

		}
	}

}
