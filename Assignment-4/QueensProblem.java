public class QueensProblem {
	
	int N;
	//constructor
	public QueensProblem(int n) {
		this.N=n;
	}
	
	//function to check that a queen can be placed or not at position table[row][col]
	boolean isSafe(int[][] table, int row, int col){
		int i,j;
		
		//checking the row on left side
		for (i = 0; i < col; i++){
            if (table[row][i] == 1)
                return false;
		}    
		//checking upper diagonal on left side
		for(i=row,j=col;  i>=0 && j>=0;  i--,j--){
			if(table[i][j]==1){
				return false;
			}
		}
		//checking lower diagonal on left side
		for(i=row,j=col;  i<N && j>=0;  i++,j--){
			if(table[i][j]==1){
				return false;
			}
		}
		
		//safe 
		return true;
		
	}
	
	boolean solveProblem(int table[][], int col){
		//base condition, when all queens are palced
		if(col >= N){
			return true;
		}
		
	//placing queens in each row
	for (int i = 0; i < N; i++)
        {
            //checking for safe position
            if (isSafe(table, i, col))
            {
                //marking position
                table[i][col] = 1;
 
           
                if (solveProblem(table, col + 1) == true)
                    return true;
                //if no solution
                table[i][col] = 0; // BACKTRACK
            }
        }
		//if no solution exist
		return false;
		
	}
	
     //printing solution	
    void printSolution(int table[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + table[i][j]
                                 + " ");
            System.out.println();
        }
    }
	


}//
