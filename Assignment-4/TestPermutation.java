import static org.junit.Assert.*;

import org.junit.Test;


public class TestPermutation {

	@Test
	public void test() {
		
		char[] arr1="ABC".toCharArray();
		String[] expected={"ABC","ACB","BAC","BCA","CBA","CAB"};
		PermutationsOfString ob=new PermutationsOfString(arr1.length);
		assertArrayEquals(expected, ob.printPermutationOfString(arr1));
		
	}

}
