import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestingBinarySearch {
	
	int array1[]={23,32,56,58,60,78,88,91};
	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		//positive
		assertEquals(6, BinarySearch.searchLeftMostOccurence( array1, 88,
				BinarySearch.binarySearch(array1, 0, array1.length-1, 88)  ) );
		
		//negative
		assertEquals(-1, BinarySearch.searchLeftMostOccurence( array1, 65,
				BinarySearch.binarySearch(array1, 0, array1.length-1, 65)  ) );
		
		//negative
				assertEquals(-1, BinarySearch.searchLeftMostOccurence( array1, 100,
						BinarySearch.binarySearch(array1, 0, array1.length-1, 100)  ) );
		
	}

}
