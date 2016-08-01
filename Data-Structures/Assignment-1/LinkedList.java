package MyUtil;

/**
 * 
 * 
 * 
 * 
 */


public class LinkedList <E> {
	
	/**
	 * pointer to the head of the node i.e the first element of list
	 * */
	Node<E> first;		 
	
	/**
	 * pointer to the tail of the node i.e. the last element of list
	 * */
	Node<E> last;		 
	
	/*
	/**
	 * size of the list i.e. number of elements in the list
	 * 
	int size;		
	*/
	
	/**
	 * return the size of list i.e. number of elements in the list
	 */
	int getSize(){
		//Traversing
			Node<E> ptr=first;		
			int size=0;			//count 
			while(  ptr != null ){	//till end of the list
				size++;
				ptr = ptr.next;
			}
			return size;
	}
	
	
	/**
	 * adds (appends) an element to the end of the list
	 * */
	void add(E e){
		//first node case
		if( getSize()==0 ){
			//new node
			Node<E> newNode=new Node<E>();
			//setting its next as null
			newNode.next=null;
			//updating 'first' pointer
			first=newNode;
			//updating 'last' pointer
			last=newNode;
		}else{
		
			//new node
			Node<E> newNode=new Node<E>();
			//setting its next as null
			newNode.next=null;
			//linking
			last.next=newNode;
			//updating 'last' pointer
			last=newNode;
		}	
	}
	
	
	/**
	 * removes the first occurrence of the specified item
	 * e is the data item to be searched for
	 * @throws NoSuchElementException if the specified element not found
	 * */
	public boolean remove(Object o){
		Node<E> ptr=first;		
		Node<E> predecessor=null;		//Maintaining pointer to immediate predecessor node of ptr
		
		while( ptr != null ){
			if( ptr.data.equals(o) ){		//comparison !!
				//disconnecting, linking its predecessor node to its successor node
				predecessor.next = ptr.next;
				return true;
			}
			//moving forward
			predecessor=ptr;
			ptr = ptr.next;
		}
		
		//failure case
		throw new NoSuchElementException();
		
	}
	
	
	/**
	 * return the element form the specified index (index starts from 0)
	 * @throws InvailidIndexException if specified index is invalid or out of bound
	 * */
	public E getElement(int index){
		if(index<0){
			throw new InvalidIndexException();
		}
		//Traversing
		Node<E> ptr=first;		
		int i=0;	//internal index
		while( i <= index &&  ptr != null ){
			if( i == index ){
				return ptr.data;
			}
			//moving forward
			i++;
			ptr = ptr.next;
		}
		
		//failure case
		throw new InvalidIndexException("Index Out Of Bound");
		
	}
	
	

	 /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public E getFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.data;
    }

    
    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public E getLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.data;
    }
	
	
	
}
