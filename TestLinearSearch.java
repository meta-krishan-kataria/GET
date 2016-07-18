import static org.junit.Assert.*;

import org.junit.Test;


public class TestLinearSearch {

	@Test
	public void test() {
		int arr1[]={23,14,56,78,555,99,67,44};
		assertEquals(5, LinearSearch.linearSearch(arr1, 99, 0, arr1.length-1));
		assertEquals(-1, LinearSearch.linearSearch(arr1, 55, 0, arr1.length-1));
	}

}
