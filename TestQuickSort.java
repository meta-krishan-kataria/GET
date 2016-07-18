import static org.junit.Assert.*;

import org.junit.Test;


public class TestQuickSort {
	int[] arr1={2,5,8,9,10,77,55,11};
	int[] expected1={2,5,8,9,10,11,55,77};
	
	
	@Test
	public void test() {
		QuickSort.qsort(arr1, 0, 7);
		assertArrayEquals(expected1, arr1);
		
	}

}
