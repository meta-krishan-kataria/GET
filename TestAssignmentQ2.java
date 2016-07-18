import static org.junit.Assert.*;

import org.junit.Test;


public class TestGCD {

	@Test
	public void test() {
		//Testing gcd()
		assertEquals(6, AssignmentQ1.gcd(12,18));
		assertEquals(1, AssignmentQ1.gcd(2,1));
		assertEquals(1, AssignmentQ1.gcd(100,3));
		
		//Testing rem()
		assertEquals(3, AssignmentQ1.rem(10, 7));
		assertEquals(0, AssignmentQ1.rem(99, 99));
	}

}
