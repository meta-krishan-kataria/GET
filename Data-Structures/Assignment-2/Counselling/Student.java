import java.util.*;
import java.io.*;



public class Counselling {
	public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	
	//Student Queue	
	Queue<Student> sq=new LinkedList<Student>();
	//Seat allocator object
	SeatAllocator sa=new SeatAllocator();
	
	Student s1=new Student("krishan", 1);
	Student s2=new Student("prateek",2 );
	Student s3=new Student("rahul",3 );
	Student s4=new Student("arpit",4 );
	Student s5=new Student("dheeraj",5 );
	Student s6=new Student("jai",6 );
	Student s7=new Student("deepak",7 );
	
	sq.add(s1);
	sq.add(s2);
	sq.add(s3);
	sq.add(s4);
	sq.add(s5);
	sq.add(s6);
	sq.add(s7);
	
	int sno=1;
	for( Student x : sq ){
		System.out.println("Give your choice "+ x.name+ "  "+x.rank);
		
		
		do{
			try{
				System.out.println( sa.showSeatMatrix() );;
				int choice=sc.nextInt();
				switch(choice){
					case 1 :  x.allotedCollege=sa.allocateC1();
						break;
					case 2 :  x.allotedCollege=sa.allocateC2();
						break;
					case 3 :  x.allotedCollege=sa.allocateC3();
						break;
					default: System.out.println("Invalid choice");	
						
				}
			}catch(NoVacantSeatException ex){
				System.out.println("Sorry seat is not available");
				System.out.println("Choose another option");
				
			}
		}while(x.allotedCollege == null );
		
		
	}
	
	
	
	
	
	
	}
	
	
	
	
}
