import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;


public class MyQueue < E >{
	
	private LinkedList<Object> data;


	//Constructor
	public MyQueue(){
		data=new LinkedList<Object>();
			
	}
	
	
	/**
	 * adds an element to the rear end of queue
	 * 
	 * */
	public void enqueue(E e){
		//adding in the rear
		data.addLast(e);
	}
	
	/**
	 * removes and return the the element from the front of the queue
	 * throws EmptyMyQueueException when queue is empty
	 * 
	 * */
	public  E dequeue(){
		try {
			//removing from front
			return (E)data.removeFirst();
			
		}catch (NoSuchElementException e) {
			throw new EmptyMyQueueException("Queue is Empty");
		}
		
	}
	
	/**
	 * makes queue empty
	 * */
	public void makeEmpty(){
		data.clear();
	}
	
	
}
