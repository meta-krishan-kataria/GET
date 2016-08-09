import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class TestTreeSort {
	
	
	List<Student> slist=new LinkedList<Student>();
	List<Student> expectedslist=new LinkedList<Student>();
	
	
	@Before
	public void setUp(){
		slist.add(new Student("kk",12 ));
		slist.add(new Student("hh", 45));
		slist.add(new Student("hh", 10));
		slist.add(new Student("ff", 30));
		
		expectedslist.add(new Student("hh",10 ));
		expectedslist.add(new Student("kk",12 ));
		expectedslist.add(new Student("ff",30 ));
		expectedslist.add(new Student("hh", 45));
		
		
	}
	
	
	@Test
	public void test() {
		assertArrayEquals( expectedslist.toArray(), new TreeSort<Student>().sort(slist).toArray() );
	}

}
