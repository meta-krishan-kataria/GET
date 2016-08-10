package MyUtil;



public class Test2 {

	public static void main(String[] args) {
		LinkedList<String> list=new LinkedList<String>();
		
		list.add("k");
		list.add("j");
		list.add("c");
		list.add("a");
		
		String t="c";
		
		System.out.println( list.getSize() );
		
		System.out.println( list.remove( t ) );
		System.out.println( list.getSize() );
		
		System.out.println( list.getElement(1) );
		
		
		System.out.println("*********");
		for(int i=0; i<list.getSize(); i++){
			System.out.println( list.getElement(i) );
		}
		
		list.sort();
		System.out.println("*****After sorting****");
		for(int i=0; i<list.getSize(); i++){
			System.out.println( list.getElement(i) );
		}
		

	}

}

