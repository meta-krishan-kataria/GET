package MyUtil;

public class Testing {

	public static void main(String[] args) {
		LinkedList<Integer> list=new LinkedList<Integer>();
		
		list.add(new Integer(5));
		list.add(new Integer(6));
		list.add(new Integer(7));
		list.add(new Integer(8));
		
		System.out.println( list.getSize() );
		
		System.out.println( list.remove( new Integer(6) ) );
		System.out.println( list.getSize() );
		
		System.out.println( list.getElement(1) );
		

	}

}
