
public class MyQueue < E >{
	
	private Object[] data;

	/**
	 * index of the front most element of queue
	 * */
	private int front;

	/**
	 * index of the rear most element of queue
	 * */
	private int rear;
	
	/**
	 * Default capacity
	 * */
	private final int CAPACITY=10;
	//capacity = 10 means last index is 9
	private int lastindex=9;
	
	//Constructor
	public MyQueue(){
		data=new Object[CAPACITY];
		
		front=-1;	//for the empty list
		rear=-1;	//for the empty list
				
	}
	

	
	/**
	 * adds an element to the rear end of queue
	 * throws MyQueueOverFlowException when capacity exceeds
	 * */
	public void enqueue(E e){
		if( front==-1 && rear==-1 ){		//for the first most element
			front=0;
		}
		//checking over flow condition
		if( rear >= lastindex  ){
			throw new MyQueueOverFlowException();
		}else{
			data[ ++rear ]=e;
		}
	}
	
	/**
	 * removes and return the the element from the front of the queue
	 * throws EmptyMyQueueException when queue is empty
	 * 
	 * */
	public  E dequeue(){
		E item;
		if(front==-1 && rear==-1){				//empty list
			throw new EmptyMyQueueException();
		}else if(front==rear){					//only single element in list
			item=((E)data[front]);	//**casting ??**
			front=-1;
			rear=-1;
		}else{									//
			item=((E)data[front]);	//**casting ??**
			front++;
		}
		
		return item;
		
	}
	
	/**
	 * makes queue empty
	 * */
	public void makeEmpty(){
		front=-1;
		rear=-1;
	}
	
	
}
