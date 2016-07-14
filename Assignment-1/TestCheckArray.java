package first;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCheckArray  {
	CheckArray ob=new CheckArray();
	
	int[] array1={2,3,5,6,8,50};
	int[] array2={6,4,3,2,1,0};
	int[] array3={2,16,5,3,8,5};
	
		
	
	
	@Test
	public void test() {
		System.out.println("Inside checkArrayIsSorted()");
		assertEquals(1, ob.checkArrayIsSorted(array1));
		assertEquals(2, ob.checkArrayIsSorted(array2));
		assertEquals(0, ob.checkArrayIsSorted(array3));
		
	}

}


