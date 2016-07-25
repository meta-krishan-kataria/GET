
public class GameRules {
	
	/*	Function to check where the game is draw
	 * true->game is draw		false->not draw
	 * */
	boolean checkDraw(int[][] matrix){
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if( matrix[i][j]== -1 ){
					return false;
				}
			}
		}
		//else case
		return true;	
	}
	
	
	
	
	/*Function to check wining condition
	 * Output 	0 -> none
	 * 			1 -> player1 ('0')
	 * 			2 -> player2 ('X')
	 * 
	 * */
	int checkWin(int [][] matrix){
		int zeroCount;
		int	crossCount;
		
		//horizontal case
		for(int i=0; i<3 ;i++){
			zeroCount=0;
			crossCount=0;
			for(int j=0; j<3; j++){	
				//counting
				if(	matrix[i][j] == 0 ){
					zeroCount++;
				}else if( matrix[i][j] == 1  ){
					crossCount++;
				}
			}
			if(	zeroCount==3){
				return 1;
			}else if( crossCount==3 ){
				return 2;
			}else{
				continue;
			}			
		}
		
		//vertical case
		for(int j=0; j<3 ;j++){
			zeroCount=0;
			crossCount=0;
			for(int i=0; i<3; i++){	
				//counting
				if(	matrix[i][j] == 0 ){
					zeroCount++;
				}else if( matrix[i][j] == 1  ){
					crossCount++;
				}
			}
			if(	zeroCount==3){
				return 1;
			}else if( crossCount==3 ){
				return 2;
			}else{
				continue;
			}			
		}
		
		//diagonal case : diagonal 1
		zeroCount=0;
		crossCount=0;
		for(int i=0,j=0;  i<3 && j<3 ;   j++,i++){
			if(	matrix[i][j] == 0 ){
				zeroCount++;
			}else if( matrix[i][j] == 1  ){
				crossCount++;
			}
		}
		if(	zeroCount==3){
			return 1;
		}else if( crossCount==3 ){
			return 2;
		}
		
		//diagonal case : diagonal 2
		zeroCount=0;
		crossCount=0;
		for(int i=2,j=2;  i>=0 && j>=0 ;   j--,i--){
			if(	matrix[i][j] == 0 ){
				zeroCount++;
			}else if( matrix[i][j] == 1  ){
				crossCount++;
			}
		}
		if(	zeroCount==3){
			return 1;
		}else if( crossCount==3 ){
			return 2;
		}
		
		
		
		//else case
		return 0;	//no one has win the game
						
		
	}
	
	//function to check validity of input
	boolean isValid(int location,int[][] matrix){
		int i=0,j=0;
		//
		if(location>9 || location<1){
			return false;
		}
		
		switch (location){
			case 1: i=0;j=0;
			break;
			case 2: i=0;j=1;
			break;
			case 3: i=0;j=2;
			break;
			case 4: i=1;j=0;
			break;
			case 5:  i=1;j=1;
			break;
			case 6:  i=1;j=2;
			break;
			case 7:  i=2;j=0;
			break;
			case 8: i=2;j=1;
			break;
			case 9: i=2;j=2;
			break;
			default:	;
		}	
		if(matrix[i][j]==-1){
			return true;	
		}else{
			return false;
		}

	}
	
	
	
	
}
