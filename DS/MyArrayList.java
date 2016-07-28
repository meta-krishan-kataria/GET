
public class MyArrayList <E> {
	/**
	 * 
	 * Conventions:
	 * 
	 * 'capacity' implies total length of array whether filled or unfilled
	 * 'size' implies length of elements which are filled (numeric value)
	 * 
	 * */
	
	private Object[] data;
	
	private final int DEFAULT_CAPACITY=10;
	private final int DEFAULT_INCREMENT=10;
	
	private int size=0;
	
	/**Constructor with no argument
	*/
	public MyArrayList(){
		data=new Object[ DEFAULT_CAPACITY ];
	}
	
	/**Constructor with argument for initial capacity
	*/
	public MyArrayList( int initialCapacity ){
		data=new Object[ initialCapacity ];
	}
	
	/**
	 * returns size of array
	 * */
	public int getSize(){
		return size;
	}
	
	/**
	 * returns capacity of array
	 * */
	public int getCapacity(){
		return data.length;
	}
	
	/**
	 * maintains capacity, check capacity and increments if required
	 * */
	private void maintainCapacity(){
		boolean isSufficient;
		//checking capacity
		if( data.length - size > 1 ){
			isSufficient= true;
		}else{
			isSufficient= false;
		}
		//incrementing if required
		if(isSufficient==false){
			increaseCapacity();
		}
		
	}
	
	
	/**
	 * Ensures capacity of array
	 * */
	private boolean ensureCapacity(){
		if( data.length - size > 1 ){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Ensures capacity of array with minimum required 
	 * */
	private boolean ensureCapacity(int minimumRequired){
		if( data.length - size >= minimumRequired  ){
			return true;
		}else{
			return false;
		}
	}
	
	
	/**
	 * Increments array capacity
	 * */
	private void increaseCapacity(){
		//copying array to temp
		Object[] temp=clone(data);
		//creating new array
		data=new Object[temp.length + DEFAULT_INCREMENT ];
		//copying elements to new increased sized array
		for( int i=0; i<temp.length; i++ ){
			data[i]=temp[i];
		}
	}
	
	/**
	 * clones the array 
	 * */
	public Object[] clone(Object[] o){
		Object[] copy=new Object[o.length];
		for(int i=0; i < o.length; i++){
			copy[i]=o[i];
		}
		return copy;		
	}
	
	/**
	 * function to append element 
	 * */
	public void add(E e){
		if( ensureCapacity() == true){	//have enough capacity
			data[size++]=e;
			
		}else{							//no sufficient capacity
			increaseCapacity();			//increasing size
			data[size++]=e;
			
		}
	}
	
	/**
	 * adds element at particular index
	 * */
	public void addAt(E e,int index){
		//maintaining capacity
		maintainCapacity();
		//shifting 
			// size is n means last index of filled element is n-1
		for( int i=size ; i > index; i-- ){
			data[i]=data[i-1];
		}
		//placing e
		data[index]=e;
	}
	
	/**
	 * returns list element form the index
	 * */
	public Object get(int index){
		//handle exception
		return data[index];
	}
	
	/**
	 * returns first index of item in the list
	 * */
	/*
	public int find(E e){
		for(int i=0; i < getSize(); i++){
			if
		}
		
	}
	*/
	
	
	
}
