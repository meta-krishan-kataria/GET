package MyUtil;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestFindThirdLargest {

	int array[]={10,3,4,7,5,4,2,1,0};

	@Test
	public void test() {
		assertEquals(5, FindThirdLargest.findThirdLargest( array ));
	}

}
