package first;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestRemoveDuplicate {

	RemoveDuplicate ob=new RemoveDuplicate();
	
	int[] array1={ 2,5,4,6,3,8,5,9,3,3,6,3,9,0};
	int[] expected1={0,2,3,4,5,6,8,9};
	
	int[] array2={ 2,2,2,3,3,4,4,2,3,4};
	int[] expected2={2,3,4};
	
	
	

	@Test
	public void test() {
		assertArrayEquals(expected1,ob.removeDuplicate(array1) );
		assertArrayEquals(expected2,ob.removeDuplicate(array2) );
	}

}
