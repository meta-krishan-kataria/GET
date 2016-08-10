
public class MyListAddition {

	public static void main(String[] args) {
		//List 1
		MyArrayList<String> ml=new MyArrayList<String>();
		
		ml.add("krish");
		ml.add("pratap");
		ml.add("rohit");
		ml.add("prateek");
		
		//List 2
		MyArrayList<String> ml2=new MyArrayList<String>();
		
		ml2.add("rohan");
		ml2.add("ashu");
		ml2.add("rajendra");
		ml2.add("faisal");
		
		//adding elements
		for(int i=0; i<ml2.getSize(); i++ ){
			ml.add( (String)ml2.get(i) );
		}
		
		//printing list
		for(int i=0; i < ml.getSize() ; i++){
			System.out.println(i + "  " + ml.get(i));
		}
		

	}

}
