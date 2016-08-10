package MyUtil;

public class DoublyLinkedList<E> {
	/**
	 * pointer to the head of the node i.e the first element of list
	 * */
	Node2<E> first;		 
	
	/**
	 * pointer to the tail of the node i.e. the last element of list
	 * */
	Node2<E> last;		
	
	
	/**
	 * @returns the size of list
	 * the number of elements in the list
	 * */
	public int size(){
		Node2<E> ptr=first;
		
		int size=0;
		
		while( ptr != null ){
			size++;
			ptr = ptr.next;
		}
		return size;
	}
	
	/**
	 * checks is list is empty or not
	 * */
	boolean isEmpty(){
		if( size()==0 ){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * adds an element e to the end of the list
	 * */
	public void add(E e){
		//if list is empty
		if( isEmpty() ){
			
			Node2<E> newNode=new Node2<E>();
			//
			newNode.data=e;
			newNode.next=null;
			first=newNode;
			newNode.previous=first;
			last=newNode;
			
		}else{	//if list is not empty
			
			Node2<E> newNode=new Node2<E>();
			//
			newNode.data=e;
			newNode.next=null;
			newNode.previous=last;
			last.next=newNode;
			last=newNode;
			
		}
	}
	
	/**
	 * removes the last element form the list and return
	 * 
	 * 
	 * */
	public E remove(){
		E output=last.data;
		
		//updating last pointer
		last=last.previous;
		last.next=null;
		
		return output;
	}
	
	
	/**
	 * @return element of list from particular index
	 * @throws NoSuchElementException for invalid index
	 * 
	 * */
	public E get(int index){
		Node2<E> ptr=first;
		
		int internalIndex=0;
		
		while( ptr != null ){
			if(internalIndex==index){
				return ptr.data;
			}
			ptr = ptr.next;
			internalIndex++;
		}
		throw new NoSuchElementException();
	}
	
	
	
	
	
	
	
	
	
}
