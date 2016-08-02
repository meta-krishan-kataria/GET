import java.util.*;
import java.io.*;



public class Counselling {
	
	//Student Queue	
	MyUtil.MyQueue<Student> sq;
	//queue for allotted students
	MyUtil.MyQueue<Student> resultantSQ;
	//Seat allocator object
	SeatAllocator allocator=new SeatAllocator();
	//Scanner object
	Scanner sc=new Scanner(System.in);
	
	
	/**
	 *sets the counselling process 
	 * */
	public  void setUp(){
	
	
		//Student Queue	
		 sq=new MyUtil.MyQueue<Student>();
		//queue for allotted students
		 resultantSQ=new MyUtil.MyQueue<Student>();
		//Seat allocator object
		allocator=new SeatAllocator();
		//scanner
		sc=new Scanner(System.in);
		
		Student s1=new Student("krishan", 1);
		Student s2=new Student("prateek",2 );
		Student s3=new Student("rahul",3 );
		Student s4=new Student("arpit",4 );
		Student s5=new Student("dheeraj",5 );
		Student s6=new Student("jai",6 );
		Student s7=new Student("deepak",7 );
		
		sq.enqueue(s1);
		sq.enqueue(s2);
		sq.enqueue(s3);
		sq.enqueue(s4);
		sq.enqueue(s5);
		sq.enqueue(s6);
		sq.enqueue(s7);
		
	}	//end setUp
	
	
	/**
	 * Starts counseling process, asks for responses and do allocation work
	 * */
	public void startCounselling(){
	
		int sno=1;
		
		while( sq.getSize() > 0 ){
			
			Student x=sq.dequeue();
			
			System.out.println("You are " + x);
			System.out.println("\nUpdated Seat Matrix");
			System.out.println(  allocator.showSeatMatrix() );;
			
			System.out.println("Enter your choice   "+ x.name);
			
			
			do{
				try{
					
					int choice=sc.nextInt();
					switch(choice){
						case 1 :  x.allotedCollege=allocator.allocateC1();
							break;
						case 2 :  x.allotedCollege=allocator.allocateC2();
							break;
						case 3 :  x.allotedCollege=allocator.allocateC3();
							break;
						default: System.out.println("Invalid choice");	
							
					}
					
					
				}catch(NoVacantSeatException ex){
					System.out.println("Sorry seat is not available");
					System.out.println("Choose another option");
					
				}
			}while( x.allotedCollege.equals("None") );
			
			//storing result
			resultantSQ.enqueue(x);
			
			//checking whether seats are full or not
			if( allocator.numberOfSeatsLeft() <= 0 ){
				System.out.println("All Seats Full");
				break;	//breaking for loop
			}
			
			System.out.println("                 SUCCESSFULLY ALLOTED");
			System.out.println("*****************************************************************");
		}//end while
	
	}
	
	
	/**
	 * prints student list with allocated seat
	 * */
	void printCounsellingResult( ){
		while( resultantSQ.getSize() > 0 ){
			System.out.println( resultantSQ.dequeue());
		}
	}
	
	
}
