import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestCountSort {
	
	int input[]={2,5,8,4,4,5,6,5,6,9};
	int expectedOutput[]={2,4,4,5,5,5,6,6,8,9};
	
	

	@Test
	public void test() {

		assertArrayEquals(expectedOutput, CountSort.sort(input));
		
	}

}
