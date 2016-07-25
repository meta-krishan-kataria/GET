
public class Display {
	
	void printMatrix(int[][] matrix){
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				System.out.print("   " + getSymbol(matrix[i][j]) );
			}
			System.out.println();
		}		
	}
	
	void printLayout(){
		int location=0;
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				System.out.print("   " + (++location) );
			}
			System.out.println();
		}
	}
	
	char getSymbol(int i){
		if(i==0){
			return '0';
		}else if(i==-1){
			return '_';
		}else if(i==1){
			return 'X';
		}else{
			return '#';	//invalid input	
		}
	}
	
}
