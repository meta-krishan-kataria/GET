import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Printer {
	/**
	 * utility function to print array
	 * 
	 * */
	public static void printArray(Job[] a){
		for(Job x : a){
			 System.out.print(x +" ");
		 }
	}
	
	public static void main(String args[]){
		Scanner sc=new  Scanner(System.in);
		JobHeap heap=new JobHeap();
		
		int id;
		int priority;
		
		//Job[] jobList=new Job[10];	// maximum 10 jobs can be in buffer
		List<Job> jobList=new ArrayList<Job>();
		
		int i=0;
		while(true){
			System.out.println("Insert job");
			System.out.println("Enter id");
			id=sc.nextInt();
			System.out.println("Enter priority");
			priority=sc.nextInt();
			
			jobList.add(  new Job(id, priority) );
			System.out.println("Result");
			System.out.println(  heap.buildHeap(jobList) );
			
			
			
		}
		
	}
}
