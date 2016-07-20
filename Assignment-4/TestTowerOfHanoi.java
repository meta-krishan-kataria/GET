import static org.junit.Assert.*;

import org.junit.Test;


public class TestTowerOfHanoi {

	@Test
	public void testSolveTOH() {
		TowerOfHanoi toh1=new TowerOfHanoi(3);
		TowerOfHanoi toh2=new TowerOfHanoi(2);
		TowerOfHanoi toh3=new TowerOfHanoi(1);
		
		
		
		String[] expected1= {"A->C","A->B","C->B","A->C","B->A","B->C","A->C"};
		String[] result1=new String[7];
		toh1.tower(3, 'A', 'C', 'B');
		assertArrayEquals(expected1,toh1.result );
		
		String[] expected2= {"A->B","A->C","B->C"};
		String[] result2= new String[3];
		toh2.tower(2, 'A', 'C', 'B');
		assertArrayEquals(expected2,toh2.result );
		
		String[] expected3= {"A->C"};
		String result3[]= new String[1];
		toh3.tower(1, 'A', 'C', 'B');
		assertArrayEquals(expected3, toh3.result);
	}

}
