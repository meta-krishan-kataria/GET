import static org.junit.Assert.*;

import org.junit.Test;


public class TestTowerOfHanoi {

	@Test
	public void testSolveTOH() {
		TowerOfHanoi toh1=new TowerOfHanoi();
		TowerOfHanoi toh2=new TowerOfHanoi();
		
		String[] expected1= {"A->C","A->B","C->B","A->C","B->A","B->C","A->C"};
		String[] result1=new String[7];
		assertArrayEquals(expected1, toh1.solve(3, "A", "B", "C", result1));
		
		String[] expected2= {"A->B","A->C","B->C"};
		String[] result2= new String[3];
		assertArrayEquals(expected2, toh2.solve(2, "A", "B", "C", result2));
		
		String[] expected3= {"A->C"};
		String result3[]= new String[1];;
		assertArrayEquals(expected3, new TowerOfHanoi().solve(1, "A", "B", "C", result3));
	}

}