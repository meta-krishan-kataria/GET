package MyUtil;



public class Test2 {

	public static void main(String[] args) {
		LinkedList<String> list=new LinkedList<String>();
		
		list.add("A");
		list.add("B");
		list.add("c");
		list.add("d");
		
		String t="c";
		
		System.out.println( list.getSize() );
		
		System.out.println( list.remove( t ) );
		System.out.println( list.getSize() );
		
		System.out.println( list.getElement(1) );
		

	}

}

