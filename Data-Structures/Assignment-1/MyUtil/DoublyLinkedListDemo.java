package MyUtil;

public class DoublyLinkedListDemo {

	public static void main(String[] args) {
		DoublyLinkedList<String> dl=new DoublyLinkedList<String>();
		
		dl.add("Krishan");
		dl.add("Prateek");
		dl.add("Rahul");
		
		System.out.println("Size: "+ dl.size());
		
		//removing last element of list
		System.out.println("Removing last :"+dl.remove());
		
		System.out.println("Size: " +dl.size());
		
		for(int i=0; i<dl.size(); i++){
			System.out.println( dl.get(i) );
		}

	}

}
