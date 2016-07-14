package first;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestMergeSortedArray {
	MergeSortedArray ob=new MergeSortedArray();
	int a[]={1,3,6,9,13,67};
	int b[]={2,5,13,24,66};
	int c[];
	int expectedArray[]={1,2,3,5,6,9,13,13,24,66,67};

	
	@Test
	public void test() {
		System.out.println();
		
		assertArrayEquals(expectedArray, ob.join(a,a.length,b,b.length,c));
		
	}

}
