import java.util.Scanner;


public class Sort {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Plese select type of sorting u want");
		System.out.println("1-Comparison sorting");
		System.out.println("2-Linear sorting");
		System.out.println("Enter your choice");
		int choice=sc.nextInt();
		
		System.out.println("Enter size of array");
		int size=sc.nextInt();
		int input[]=new int[size];
		System.out.println("Enter numbers");
		for(int i=0; i<size; i++){
			input[i]=sc.nextInt();
		}
		

		
		switch (choice){
		case 1 : ComparisonSort.sort(input);
		break;
		case 2: input=LinearSort.sort(input);
		break;
		default : System.out.println("Invalid Choice");
		}
		
		System.out.println("Sorted result");
		for(int x : input){
			System.out.println(x);
		}
	}

}
