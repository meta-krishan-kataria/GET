import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class to represent the Printer machine
 * 
 * */
public class Printer {
	
	/**
	 * utility function to print list
	 * 
	 * */
	public static void printList(List<Job> a){
		for( int i=0; i < a.size();  i++ ){
			System.out.println("Sno: "+ (i+1) + "  "+ a.get(i));
		}
	}
	
	/**
	 * Driver method to accept new jobs and maintian their order priority wise 
	 * using heap 
	 * 
	 * */
	
	public static void main(String args[]){
		
		Scanner sc=new  Scanner(System.in);
		
		
		
		int id;
		int priority;
		
		//buffer for all jobs to be executed
		List<Job> jobList=new ArrayList<Job>();
		
		int i=0;
		
		
		try {
			while(true){
				
				//taking inputs for the new job
				System.out.println("********************Insert new job************");
				System.out.println("Enter Job id = "+i);
				//id=sc.nextInt();
				System.out.print("Enter Job priority   ");
				priority=sc.nextInt();
				
				//adding job to the buffer
				jobList.add(  new Job(i, priority) );
				System.out.println("Job added Successfully");
				
				//creating heap object
				JobHeap heap=new JobHeap(jobList);
				
				//maintaining job order 
				//List<Job> resultant =  heap.buildHeap(jobList) ;
				
				//sorting
				heap.heapSort(jobList);
				
				//showing the updated buffer
				System.out.println("\n\nBuffer State");
				printList(jobList);
				System.out.println();
				
				i++;
				
				
			}
		} catch (Exception e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
		
	}
}
