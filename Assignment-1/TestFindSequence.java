package first;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestFindSequence {
	FindSequence ob=new FindSequence();
	int test1[]={1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9,12};
	int expected1[]={1, 2,4,5,6,7,8,9,12};

	int test2[]={1,2,3,0,2,5,7,8,4,5};
	int expected2[]={0,2,5,7,8};

	@Test
	public void test() {
		assertArrayEquals(expected2, ob.longestSequence(test2));
		assertArrayEquals(expected1, ob.longestSequence(test1));
	}
	
	

}
