import static org.junit.Assert.*;

import org.junit.Test;


public class TestBinarySearch {
	
	int arr1[]={2,5,8,9,10,55,77};
	int key1=88;
	
	int arr2[]={2,5,8,9,10,55,77};
	int key2=77;
	@Test
	public void test() {
		assertEquals(-1, BinarySearch.binarySearch(arr1, key1, 0, 6));
		assertEquals(6, BinarySearch.binarySearch(arr2, key2, 0, 6));
	}

}
