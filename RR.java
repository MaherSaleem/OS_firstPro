import java.util.ArrayList;

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
		for (int i = 0; i < fullTime;)
		{
			for (Process p : a)
			{
				if (p.isInReadyQueue(i))
				{
					p.timeStartWork.add(i);// add the time the process entered
											// the
											// cpu
					if (p.burstTime < this.quantumTime)
					{// check if its finished before the time quantum
						p.timeFinishedWork.add(i = i + p.burstTime);// add the time the process out from the cpu
						p.timeFinished = p.burstTime; // the process has  finished
					}
					else
					{
						p.timeFinishedWork.add(i = i + this.quantumTime);
						p.timeFinished += this.quantumTime;
					}

				}
			}
		}
	}

}
