import static org.junit.Assert.*;

import org.junit.Test;


public class TestQueensProblem {
	
	int table[][] = {{0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
	int table2[][] = {{0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
	int[][] res1={{ 0,0,1,0},{ 1,  0,  0,  0},{ 0,  0,  0,  1},{ 0,  1,  0,  0}};
	
	QueensProblem ob=new QueensProblem(4);
	QueensProblem ob2=new QueensProblem(5);
	
	@Test
	public void test() {
		assertEquals(true,ob.solveProblem(table, 0));
		ob.printSolution(table);
		for(int i=0; i<4 ;i++){
			assertArrayEquals(res1[i], table[i]);
		}
		
		assertEquals(false,ob2.solveProblem(table2, 0));
	}
	}
