import java.util.Scanner;


public class DriverClass {

	public static void main(String[] args) {
		TicTacToe game=new TicTacToe();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("0. Play with computer");
		System.out.println("1. Two Player Game");
		System.out.println("Select your choice (0/1)  ");
		
		int choice=sc.nextInt();
		
		if(choice==0){
			game.playWtihComputer();
		}else if(choice==1){
			game.startTwoPlayerGame();
		}else{
			System.out.println("Invalid input");
		}
		
	
	}

}
