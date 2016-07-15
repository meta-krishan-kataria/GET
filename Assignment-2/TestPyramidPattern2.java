import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestPyramidPattern2{

PyramidPattern ob=new PyramidPattern();

@Test
public void testGetPyramidPattern(){
	String expArray[]={"----1----","---121---","--12321--","-1234321-","123454321","-1234321-","--12321--","---121---","----1----"};
	assertArrayEquals(expArray, ob.printPyramidPattern(5));	
}


}
