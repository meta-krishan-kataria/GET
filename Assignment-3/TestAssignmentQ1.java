import static org.junit.Assert.*;

import org.junit.Test;


public class TestAssignmentQ1 {

	@Test
	public void test() {
		
		System.out.println("Tesinting rem()");
		assertEquals(3,AssignmentQ1.rem(10, 7));
		assertEquals(0,AssignmentQ1.rem(7, 7));
		assertEquals(0,AssignmentQ1.rem(21, 7));
		assertEquals(2,AssignmentQ1.rem(10, 8));
		
		System.out.println("Testing findMaxOfArray()");
		AssignmentQ1 ob1=new AssignmentQ1();
		AssignmentQ1 ob2=new AssignmentQ1();
		int arr1[]={23,445,34,554,6554,333,5};
		int arr2[]={34,46,45,45,67,46,45};
		assertEquals(6554, ob1.findMaxOfArray(arr1, 0, arr1.length-1));
		assertEquals(67, ob2.findMaxOfArray(arr2, 0, arr2.length-1));
		
		System.out.println("Testing gcd()");
		assertEquals(1, AssignmentQ1.gcd(2, 1));
		assertEquals(6, AssignmentQ1.gcd(12, 18));
		assertEquals(1, AssignmentQ1.gcd(100, 3));
		
		//
		System.out.println("Testinf largestDigit()");
		assertEquals(6, ob1.largestDigit(123456));
		assertEquals(9, ob2.largestDigit(89090987));
		
		
	}

}
