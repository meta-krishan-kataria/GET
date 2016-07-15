import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestPattern2 {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		int n1=5;
		
		char expected1[][]={{'1','2','3','4','5'},{'-','1','2','3','4'},{'-','-','1','2','3'},
				{'-','-','-','1','2'},{'-','-','-','-','1'}};
		
		char[][] actual=Pattern2.printPattern2(n1);
		
		//passing from row by row form 2d array
		for(int i=0; i<5; i++){
			assertArrayEquals(expected1[i],actual[i] );
		}
		
		
		
		
	}

}
