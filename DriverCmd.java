import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class DriverCmd {
	public static void main(String[] args)
	{
		
		System.out.println(args[0]);
		AllProcesses allProcesses = new AllProcesses();//
		String fileName = args[0];
		int timeQuantum = Integer.parseInt(args[1]);
		
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
			 temp = new Process(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
			 allProcesses.addNewProcess(temp);
		}
		
//		System.out.println(allProcesses.toString());
		
		SJF sjf = new SJF(allProcesses);
		sjf.SJF_Algorithm();
		sjf.printChart();
		
//		RR rr = new RR(allProcesses , timeQuantum);
//		rr.RR_Algorithm();
//		rr.printChart();
		
//		SRTF srtf = new SRTF(allProcesses);
//		srtf.SRTF_Algorithm();
//		srtf.printChart();
//		
//		EP ep  =new EP(allProcesses);
//		ep.EP_Algorithm();
//		ep.printChart();

	}
}
