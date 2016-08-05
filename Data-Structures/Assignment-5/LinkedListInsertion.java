import java.util.LinkedList;

public class LinkedListInsertion < E >{

	/**
	 * inserts the element e in sorted liked list in the appropriate position
	 * */
	void insert(LinkedList<E> llist,E item){
		int position=0;
		//finding the position
		for( int i=0; i<llist.size(); i++ ){
			if(  (  (Comparable)llist.get(i)  ).compareTo(item) < 0 ){	//item is greater than current element
				continue;
			}else{
				position=i-1;		//storing suitable index
			}
		}
		llist.add(position, item);		
		
	}
	
	
	/**
	 * inserts the element e in sorted liked list in the appropriate position
	 * VERSION 2 (Recursive)
	 * */
	void insertRecursive(LinkedList<E> llist,int index,E item){
	
		//comparing the element at current index 

		if(  (  (Comparable)llist.get(index)  ).compareTo(item) < 0 ){	//item is greater than current element
			
			insertRecursive(llist, ++index, item);
			
		}else{
			
			llist.add( index, item);
			return;
		}
	}
			

	/*
	method to demonstrate insertion
	*/
	public static void main(String[] args) {
		LinkedList<Integer> llist=new LinkedList<Integer>();
		
		llist.add(new Integer(2) );
		llist.add(new Integer(5) );
		llist.add(new Integer(10) );
		llist.add(new Integer(15) );
		llist.add(new Integer(20) );
		
		//printing list
		System.out.println(llist);

		//inserting 12 in sorted linked list
		LinkedListInsertion<Integer> insertion=new LinkedListInsertion<Integer>();
		
		insertion.insert(llist, new Integer(12) );
		//printing resultant
		System.out.println(llist);
		
		//inserting 17 (using recursive method)
		insertion.insertRecursive(llist, 0, new Integer(17));
		
		//printing resultant
		System.out.println(llist);

	}

}
