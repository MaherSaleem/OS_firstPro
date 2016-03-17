import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Driver {

	public static void main(String[] args)
	{
		
		AllProcesses allProcesses = new AllProcesses();//
		int timeQuantum = 1;
		String fileName = "m.txt";
		Scanner in = null;
		try
		{
			in = new Scanner(new File(fileName));
		}
		catch (FileNotFoundException e)
		{

			JOptionPane.showMessageDialog(null, "file not found");
		}

		in.nextLine();// remove the header line
		
		Process temp ;
		//read the processes from the file
		while (in.hasNextInt())
		{
			 temp = new Process(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
			 allProcesses.addNewProcess(temp);
		}
		
//		System.out.println(allProcesses.toString());
		
//		SJF sjf = new SJF(allProcesses);
//		sjf.SJF_Algorithm();
//		sjf.printChart();
		
		RR rr = new RR(allProcesses , timeQuantum);
		rr.RR_Algorithm();
		rr.printChart();
		
//		SRTF srtf = new SRTF(allProcesses);
//		srtf.SRTF_Algorithm();
//		srtf.printChart();
//		
//		EP ep  =new EP(allProcesses);
//		ep.EP_Algorithm();
//		ep.printChart();

	}
}
