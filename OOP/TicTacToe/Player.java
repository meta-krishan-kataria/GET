/*
 * CONVENTIONS AND SYMBOLS USED :
 * 	
 * Symbol face
 * player1: '0'
 * player2: 'X'
 *  
 * Symbol Values for 	'0'			->	0
 * 						'X'			->	1
 * 						unplaced	->	-1
 * 
 * */


public class Player {
	int symbol;
	char symbolFace;
	String playername;
	
	//private class 	SINGLETON CLASS
	private Player(char symbolFace) {
		
		this.symbolFace = symbolFace;
		if( symbolFace=='0' ){
			this.symbol=0;
		}else if( symbolFace=='X' ){
			this.symbol=1;
		}
	}
	
	
	public static Player getPlayerInstance(char symbolFace){
		Player p=new Player(symbolFace);
		return p;
	}
	
	

	
	void placeAt(int location,int[][] matrix){
		switch (location){
			case 1: matrix[0][0]=symbol;
			break;
			case 2: matrix[0][1]=symbol;
			break;
			case 3: matrix[0][2]=symbol;
			break;
			case 4: matrix[1][0]=symbol;
			break;
			case 5: matrix[1][1]=symbol;
			break;
			case 6: matrix[1][2]=symbol;
			break;
			case 7: matrix[2][0]=symbol;
			break;
			case 8: matrix[2][1]=symbol;
			break;
			case 9: matrix[2][2]=symbol;
			break;
			default:	;
		}
			
		
	}
	
	
	public String toString(){
		return playername;
	}
	
	
		
		
}
	
	

