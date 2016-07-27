import java.util.Random;
import java.util.Scanner;

/*
 * CONVENTIONS AND SYMBOLS USED :
 * 	
 * Symbol face
 * player1: '0'
 * player2: 'X'
 *  
 * Symbol Values for 	'0'	->	0
 * 			'X'	->	1
 * 			unplace	->	-1
 * 
 * */


public class TicTacToe {
	/*	Operation to be performed
	 * 
	 * initialize players
	 * 
	 * show layout
	 * maintain turns
	 * ask choice
	 * fill choice
	 * check rules
	 * get status
	 * 
	 * repeat
	 * 
	 * */
	
	private int[][] matrix={ {-1,-1,-1},{-1,-1,-1},{-1,-1,-1} };
	
	boolean draw=false;		//status of draw
	int winner=0;			//1->player1  2->player2 0->none
	
	Player p1=Player.getPlayerInstance('0');
	Player p2=Player.getPlayerInstance('X');;
	
	Display display=new Display();
	GameRules rules=new GameRules();
	
	Scanner sc=new Scanner(System.in);
	
	int gameType=0;
	
	
	/*
	 * Two Player Game
	 * */
	
	public void startTwoPlayerGame(){
		int turn=0;		// 0 -> player1  1->player2
		String name="";
		/*
		
	*/
		System.out.println("****************************************");
		System.out.println("Let's Play");
		System.out.println("****************************************");
		display.printLayout();
		
		
		do{
			//asking for input
			System.out.println("****************************************");
			name = (turn%2==0) ? "Player 1" : "Player 2";
			System.out.println("YOUR TURN : " + name);
			
			//display.printLayout();
			System.out.println("Enter your choice-  ");
			
			int choice;
			while( rules.isValid(  ( choice=sc.nextInt() ) ,matrix ) != true ){
				System.out.println("Invalid Input");
			}
			
			
			//placing
			if( turn%2==0 ){
				p1.placeAt(choice, matrix);
				turn++;
				
			}else{
				p2.placeAt(choice, matrix);
				turn++;
			}
			
			//printing matrix
			display.printMatrix(matrix);
			
			//checking rules
			draw=rules.checkDraw(matrix);
			if(draw==true){
				System.out.println("OOOOPPSSSS!!!Match Tie");
				break;
			}
			
			winner=rules.checkWin(matrix);
			if(winner==1){
				printWinnerName("PLAYER 1");
				break;
			}else if(winner==2){
				printWinnerName("PLAYER 2");
				break;
			}else{
				continue;
			}
			
		}while(true);
	}	
	
	/*
	 * Play with Computer
	 * 
	 * */
	public void playWtihComputer(){
		int turn=0;		// 0 -> player1  1->player2
		String name="";
		
		System.out.println("****************************************");
		System.out.println("Let's Play");
		System.out.println("****************************************");
		display.printLayout();
		
		
		do{
			//asking for input
			System.out.println("****************************************");
			name = (turn%2==0) ? "Player 1" : "Computer";
			System.out.println("TURN : " + name);
			
			if(turn%2==0)
			{	
				System.out.println("Enter your choice-  ");
			
				int choice;
				while( rules.isValid(  ( choice=sc.nextInt() ) ,matrix ) != true ){
					System.out.println("Invalid Input");
				}
				//placing
				p1.placeAt(choice, matrix);
				turn++;
			}else
			{
				Random random=new Random();
				int choice;
				while( rules.isValid(  choice=((random.nextInt() % 9)+1) , matrix) != true ){
				}
				//placing
				p2.placeAt(choice, matrix);
				turn++;
				
			}
			
	
			//printing matrix
			display.printMatrix(matrix);
			
			//checking rules
			draw=rules.checkDraw(matrix);
			if(draw==true){
				System.out.println("\n    OOOOPPSSSS !!! Match Tie");
				break;
			}
			
			winner=rules.checkWin(matrix);
			if(winner==1){
				printWinnerName("PLAYER 1");
				break;
			}else if(winner==2){
				printWinnerName("COMPUTER");
				break;
			}else{
				continue;
			}
			
		}while(true);
		
		
		
	}
	
	void printWinnerName(String name){
		System.out.println("****************************************");
		System.out.println( name + " WON");
		System.out.println("****************************************");
	}
	
	
}
