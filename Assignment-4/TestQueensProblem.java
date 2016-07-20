import static org.junit.Assert.*;

import org.junit.Test;


public class TestQueensProblem {
	
	int table[][] = {{0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
	int table2[][] = {{0, 0, 0, 0,0},
            {0, 0, 0, 0,0},
            {0, 0, 0, 0,0},
            {0, 0, 0, 0,0},
            {0, 0, 0, 0,0}
        };
	int[][] res1={{ 0,0,1,0},{ 1,  0,  0,  0},{ 0,  0,  0,  1},{ 0,  1,  0,  0}};
	
	QueensProblem ob1=new QueensProblem(4);
	QueensProblem ob2=new QueensProblem(5);
	QueensProblem ob3=new QueensProblem(5);
	
	
	@Test
	public void test() {
		assertEquals(true,ob1.solveProblem(table, 0));
		ob1.printSolution(table);
		for(int i=0; i<4 ;i++){
			assertArrayEquals(res1[i], table[i]);
		}
		
		
		//assertEquals(true,ob2.solveProblem(table2, 0));
		
		System.out.println();
		assertEquals(true,ob2.solveProblem(table2, 0));
		ob2.printSolution(table2);
		//for(int i=0; i<5 ;i++){
			//assertArrayEquals(res1[i], table[i]);
		//}
		
	}
	}
