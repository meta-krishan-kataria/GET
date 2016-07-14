package first;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBaseConversion {


	@Test
	public void test() {
		
		assertEquals(65, BaseConversion2.convertBinaryToOctal(110101));
		assertEquals(11, BaseConversion2.convertBinaryToOctal(1001));
	}

}
