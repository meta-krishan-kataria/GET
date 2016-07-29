import java.util.*;

/**
 * @author krishan
 *
 */
public class MyStack < E > {
	//protected LinkedList<E> data=new LinkedList<E>();
	
	private LinkedList<Object> data=new LinkedList<Object>();
	//stack implementation is through linked list hence there is no condition of stack overflow
	
	
	/**
	 * 
	 * 'top' is the index of the last element(topmost element) of the stack
	 * also top is equivalent to 'size' of the stack
	 * where size is the number of elements in the stack
	 * 
	 * */
	
	private int top=-1;	// -1 signifies empty stack
	

	
	/**
	 * adds element to the top of the stack
	 * */
	//here top is the tail element of the list
	public boolean push( E e ){
		data.add(e);
		top=data.size();
		return true;
	}
	
	/**
	 * pops or removes the top element from the stack and returns it
	 * throws MyStackUnderFlowException when stack is empty
	 * */
	public synchronized E pop(){
		E lastElement;
		try{
			lastElement = ( (E) data.removeLast() );		//** casting  //**
			top=data.size();
			return lastElement;
			
		}catch(NoSuchElementException ex){	//when list is empty
			
			throw new MyStackUnderFlowException();
		}
		
	}
	
	/**
	 * returns (not removes) the top element of the stack
	 * throws MyStackUnderFlowException when stack is empty
	 * */
	public synchronized E peek(){
		try{
			return ( (E) data.getLast() );		//** casting  //**
		
		}catch(NoSuchElementException ex){	//when list is empty
			
			throw new MyStackUnderFlowException();
		}
		
	}
	
}
