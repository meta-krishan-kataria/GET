import java.util.Scanner;


public class MainMenu {
	String 
	
	void printMainMenu(){
		Scanner sc=new Scanner(System.in); 
		
		int sno=0;	//serial number
		System.out.println(++sno + "Clothes");
		System.out.println(++sno + "Electronics");
		System.out.println(++sno + "Home and Kitchen");
		System.out.println(++sno + "Books");
		
		System.out.println("Enter your choice ");
		int choice=sc.nextInt();
		
		switch(choice){
		case 1 :
		}
		
	}
}
