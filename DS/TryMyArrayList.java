
public class TryMyArrayList {

	public static void main(String[] args) {
		MyArrayList<String> ml=new MyArrayList<String>();
		
		System.out.println( "size="+ml.getSize() );
		System.out.println( "capacity="+ml.getCapacity() );
		
		
		ml.add("krish");
		ml.add("pratap");
		ml.add("rohit");
		ml.add("prateek");
		
		int size=ml.getSize();
		
		for(int i=0; i < size ; i++){
			System.out.println(i + "  " + ml.get(i));
		}
		
		System.out.println( "size="+ml.getSize() );
		System.out.println( "capacity="+ml.getCapacity() );
		
		ml.add("krish");
		ml.add("pratap");
		ml.add("rohit");
		ml.add("prateek");
		ml.add("krish");
		ml.add("pratap");
		ml.add("rohit");
		ml.add("prateek");

		System.out.println( "size="+ml.getSize() );
		System.out.println( "capacity="+ml.getCapacity() );
		
		ml.addAt("kkkkkkk", 3);
		
		for(int i=0; i < size ; i++){
			System.out.println(i + "  " + ml.get(i));
		}
		
	}

}
